// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.material.ContactMaterial;
import com.github.gwtcannonjs.client.material.Material;
import com.github.gwtcannonjs.client.math.Quaternion;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.objects.RigidVehicle;
import com.github.gwtcannonjs.client.shapes.Heightfield;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;

public class RigidVehicleDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Rigid vehicle";
    }
    
    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.rigidVehicleDemo().getText();
    }
    
    @Override
    public void run() {
        final Demo demo = CANNON.newDemo();
        final double mass = 1;

        demo.addScene("car", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = demo.getWorld();
                world.getGravity().set(0, 0, -30);
                world.setBroadphase(CANNON.newSAPBroadphase(world));
                world.getDefaultContactMaterial().setFriction(0.2);
    
                Material groundMaterial = CANNON.newMaterial("groundMaterial");
                Material wheelMaterial = CANNON.newMaterial("wheelMaterial");
                ContactMaterial wheelGroundContactMaterial = CANNON.newContactMaterial(wheelMaterial, groundMaterial, CANNON.newContactMaterialOptions().
                    withFriction(0.3).
                    withRestitution(0).
                    withContactEquationStiffness(1000)
                );
    
                // We must add the contact materials to the world
                world.addContactMaterial(wheelGroundContactMaterial);
    
                Shape chassisShape;
                Vec3 centerOfMassAdjust = CANNON.newVec3(0, 0, -1);
                chassisShape = CANNON.newBox(CANNON.newVec3(5, 2, 0.5));
                Body chassisBody = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
                chassisBody.addShape(chassisShape, centerOfMassAdjust);
                chassisBody.getPosition().set(0, 0, 0);
    
                // Create the vehicle
                final RigidVehicle vehicle = CANNON.newRigidVehicle(CANNON.newRigidVehicleOptions().
                    withChassisBody(chassisBody)
                );
    
                double axisWidth = 7;
                Shape wheelShape = CANNON.newSphere(1.5);
                Vec3 down = CANNON.newVec3(0, 0, -1);
    
                Body wheelBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass).withMaterial(wheelMaterial));
                wheelBody.addShape(wheelShape);
                vehicle.addWheel(CANNON.newRigidVehicleOptions().
                    withBody(wheelBody).
                    withPosition(CANNON.newVec3(5, axisWidth/2, 0).vadd(centerOfMassAdjust, null)).
                    withAxis(CANNON.newVec3(0, 1, 0)).
                    withDirection(down)
                );
    
                wheelBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass).withMaterial(wheelMaterial));
                wheelBody.addShape(wheelShape);
                vehicle.addWheel(CANNON.newRigidVehicleOptions().
                    withBody(wheelBody).
                    withPosition(CANNON.newVec3(5, -axisWidth/2, 0).vadd(centerOfMassAdjust, null)).
                    withAxis(CANNON.newVec3(0, -1, 0)).
                    withDirection(down)
                );
    
                wheelBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass).withMaterial(wheelMaterial));
                wheelBody.addShape(wheelShape);
                vehicle.addWheel(CANNON.newRigidVehicleOptions().
                    withBody(wheelBody).
                    withPosition(CANNON.newVec3(-5, axisWidth/2, 0).vadd(centerOfMassAdjust, null)).
                    withAxis(CANNON.newVec3(0, 1, 0)).
                    withDirection(down)
                );
    
                wheelBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass).withMaterial(wheelMaterial));
                wheelBody.addShape(wheelShape);
                vehicle.addWheel(CANNON.newRigidVehicleOptions().
                    withBody(wheelBody).
                    withPosition(CANNON.newVec3(-5, -axisWidth/2, 0).vadd(centerOfMassAdjust, null)).
                    withAxis(CANNON.newVec3(0, -1, 0)).
                    withDirection(down)
                );
    
                // Some damping to not spin wheels too fast
                for(int i=0; i<vehicle.getWheelBodies().length(); i++){
                    vehicle.getWheelBodies().get(i).setAngularDamping(0.4);
                }
    
                // Add visuals
                demo.addVisual(vehicle.getChassisBody());
                for(int i=0; i<vehicle.getWheelBodies().length(); i++){
                    demo.addVisual(vehicle.getWheelBodies().get(i));
                }
    
                vehicle.addToWorld(world);
    
                boolean mock = false;
                JsArray<JsArrayNumber> matrix = JsArray.createArray().cast();
                double sizeX = 64,
                        sizeY = sizeX;

                for (int i = 0; i < sizeX; i++) {
                    matrix.push((JsArrayNumber) JsArray.createArray().cast());
                    for (int j = 0; j < sizeY; j++) {
                        double height = Math.sin(i / sizeX * Math.PI * 8) * Math.sin(j / sizeY * Math.PI * 8) * 8 + 8;
                        if(i==0 || i == sizeX-1 || j==0 || j == sizeY-1)
                            height = 10;

                        matrix.get(i).push(height);
                    }
                }

                Heightfield hfShape = CANNON.newHeightfield(matrix, CANNON.newHeightfieldOptions().
                    withElementSize(300 / sizeX)
                );
                Body hfBody;

                Quaternion quat = CANNON.newQuaternion();
                Vec3 pos = CANNON.newVec3(-sizeX * hfShape.getElementSize() / 2, -20, -20);

                // Use normal
                hfBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(groundMaterial));
                hfBody.addShape(hfShape, CANNON.newVec3(0,0,-1), CANNON.newQuaternion());
                hfBody.getPosition().copy(pos);
                hfBody.getQuaternion().copy(quat);

                if(!mock){
                    world.addBody(hfBody);
                    demo.addVisual(hfBody);
                }

                if(mock){
                    for(int i=0; i<sizeX - 1; i++){
                        for (int j = 0; j < sizeY - 1; j++) {
                            for (int k = 0; k < 2; k++) {
                                hfShape.getConvexTrianglePillar(i, j, k != 0);
                                Body convexBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(groundMaterial));
                                convexBody.addShape(hfShape.getPillarConvex());
                                hfBody.pointToWorldFrame(hfShape.getPillarOffset(), convexBody.getPosition());
                                world.addBody(convexBody);
                                demo.addVisual(convexBody);
                            }
                        }
                    }
                }

                Event.sinkEvents(Document.get().getDocumentElement(), Event.ONKEYDOWN | Event.ONKEYUP);
                Event.setEventListener(Document.get().getDocumentElement(), new EventListener() {
                    @Override
                    public void onBrowserEvent(Event event) {
                        switch (event.getTypeInt()) {
                        case Event.ONKEYDOWN:
                        case Event.ONKEYUP:
                            handler(event, vehicle);
                            break;
                        }
                    }
                });
            }
        });

        demo.start();
    }
    
    private static void handler(Event event, RigidVehicle vehicle) {
        double maxSteerVal = Math.PI / 8;
        double maxForce = 100;
        
        boolean up = (event.getTypeInt() == Event.ONKEYUP);

        if(!up && event.getTypeInt() != Event.ONKEYDOWN)
            return;

        switch(event.getKeyCode()){

        case 38: // forward
            vehicle.setWheelForce(up ? 0 : maxForce, 2);
            vehicle.setWheelForce(up ? 0 : -maxForce, 3);
            break;

        case 40: // backward
            vehicle.setWheelForce(up ? 0 : -maxForce/2, 2);
            vehicle.setWheelForce(up ? 0 : maxForce/2, 3);
            break;

        case 39: // right
            vehicle.setSteeringValue(up ? 0 : -maxSteerVal, 0);
            vehicle.setSteeringValue(up ? 0 : -maxSteerVal, 1);
            break;

        case 37: // left
            vehicle.setSteeringValue(up ? 0 : maxSteerVal, 0);
            vehicle.setSteeringValue(up ? 0 : maxSteerVal, 1);
            break;

        }
    }
}
