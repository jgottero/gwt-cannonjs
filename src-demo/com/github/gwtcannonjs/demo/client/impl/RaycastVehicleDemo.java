package com.github.gwtcannonjs.demo.client.impl;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.material.ContactMaterial;
import com.github.gwtcannonjs.client.material.Material;
import com.github.gwtcannonjs.client.math.Quaternion;
import com.github.gwtcannonjs.client.math.Transform;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.objects.RaycastVehicle;
import com.github.gwtcannonjs.client.objects.WheelInfo;
import com.github.gwtcannonjs.client.objects.WheelInfoOptions;
import com.github.gwtcannonjs.client.shapes.Cylinder;
import com.github.gwtcannonjs.client.shapes.Heightfield;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class RaycastVehicleDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Raycast vehicle";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.raycastVehicleDemo().getText();
    }
    
    @Override
    public void run() {
        final Demo demo = CANNON.newDemo();
        final double mass = 150;
        
        demo.addScene("car", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = demo.getWorld();
                world.setBroadphase(CANNON.newSAPBroadphase(world));
                world.getGravity().set(0, 0, -10);
                world.getDefaultContactMaterial().setFriction(0);

                Material groundMaterial = CANNON.newMaterial("groundMaterial");
                Material wheelMaterial = CANNON.newMaterial("wheelMaterial");
                ContactMaterial wheelGroundContactMaterial = /* window.wheelGroundContactMaterial = */ CANNON.newContactMaterial(wheelMaterial, groundMaterial, CANNON.newContactMaterialOptions().
                    withFriction(0.3).
                    withRestitution(0).
                    withContactEquationStiffness(1000)
                );

                // We must add the contact materials to the world
                world.addContactMaterial(wheelGroundContactMaterial);

                Shape chassisShape;
                chassisShape = CANNON.newBox(CANNON.newVec3(2, 1,0.5));
                Body chassisBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                chassisBody.addShape(chassisShape);
                chassisBody.getPosition().set(0, 0, 4);
                chassisBody.getAngularVelocity().set(0, 0, 0.5);
                demo.addVisual(chassisBody);

                WheelInfoOptions options = CANNON.newWheelInfoOptions().
                        withRadius(0.5).
                        withDirectionLocal(CANNON.newVec3(0, 0, -1)).
                        withSuspensionStiffness(30).
                        withSuspensionRestLength(0.3).
                        withFrictionSlip(5).
                        withDampingRelaxation(2.3).
                        withDampingCompression(4.4).
                        withMaxSuspensionForce(100000).
                        withRollInfluence(0.01).
                        withAxleLocal(CANNON.newVec3(0, 1, 0)).
                        withChassisConnectionPointLocal(CANNON.newVec3(1, 1, 0)).
                        withMaxSuspensionTravel(0.3).
                        withCustomSlidingRotationalSpeed(-30).
                        withUseCustomSlidingRotationalSpeed(true);

                // Create the vehicle
                final RaycastVehicle vehicle = CANNON.newRaycastVehicle(CANNON.newRaycastVehicleOptions().
                    withChassisBody(chassisBody)
                );

                options.getChassisConnectionPointLocal().set(1, 1, 0);
                vehicle.addWheel(options);

                options.getChassisConnectionPointLocal().set(1, -1, 0);
                vehicle.addWheel(options);

                options.getChassisConnectionPointLocal().set(-1, 1, 0);
                vehicle.addWheel(options);

                options.getChassisConnectionPointLocal().set(-1, -1, 0);
                vehicle.addWheel(options);

                vehicle.addToWorld(world);

                final JsArray<Body> wheelBodies = JsArray.createArray().cast();
                for(int i=0; i<vehicle.getWheelInfos().length(); i++){
                    WheelInfo wheel = vehicle.getWheelInfos().get(i);
                    Cylinder cylinderShape = CANNON.newCylinder(wheel.getRadius(), wheel.getRadius(), wheel.getRadius() / 2, 20);
                    Body wheelBody = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
                    Quaternion q = CANNON.newQuaternion();
                    q.setFromAxisAngle(CANNON.newVec3(1, 0, 0), Math.PI / 2);
                    wheelBody.addShape(cylinderShape, CANNON.newVec3(), q);
                    wheelBodies.push(wheelBody);
                    demo.addVisual(wheelBody);
                }

                // Update wheels
                world.addEventListener("postStep", new com.github.gwtcannonjs.client.utils.EventListener() {
                	public void onEvent(com.github.gwtcannonjs.client.utils.Event event) {
                        for (int i = 0; i < vehicle.getWheelInfos().length(); i++) {
                            Transform t = vehicle.getWheelInfos().get(i).getWorldTransform();
                            wheelBodies.get(i).getPosition().copy(t.getPosition());
                            wheelBodies.get(i).getQuaternion().copy(t.getQuaternion());
                        }
                	}
                });

                JsArray<JsArrayNumber> matrix = JsArray.createArray().cast();
                double sizeX = 64,
                        sizeY = 64;

                for (int i = 0; i < sizeX; i++) {
                    matrix.push((JsArrayNumber) JsArray.createArray().cast());
                    for (int j = 0; j < sizeY; j++) {
                        double height = Math.cos(i / sizeX * Math.PI * 5) * Math.cos(j/sizeY * Math.PI * 5) * 2 + 2;
                        if(i==0 || i == sizeX-1 || j==0 || j == sizeY-1)
                            height = 3;
                        matrix.get(i).push(height);
                    }
                }

                Heightfield hfShape = CANNON.newHeightfield(matrix, CANNON.newHeightfieldOptions().
                    withElementSize(100 / sizeX)
                );
                Body hfBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                hfBody.addShape(hfShape);
                hfBody.getPosition().set(-sizeX * hfShape.getElementSize() / 2, -sizeY * hfShape.getElementSize() / 2, -1);
                world.addBody(hfBody);
                demo.addVisual(hfBody);

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
    
    public static void handler(Event event, RaycastVehicle vehicle) {
        boolean up = (event.getTypeInt() == Event.ONKEYUP);

        if(!up && (event.getTypeInt() != Event.ONKEYDOWN)){
            return;
        }

        double maxSteerVal = 0.5;
        double maxForce = 1000;
        double brakeForce = 1000000;

        vehicle.setBrake(0, 0);
        vehicle.setBrake(0, 1);
        vehicle.setBrake(0, 2);
        vehicle.setBrake(0, 3);

        switch(event.getKeyCode()){

        case 38: // forward
            vehicle.applyEngineForce(up ? 0 : -maxForce, 2);
            vehicle.applyEngineForce(up ? 0 : -maxForce, 3);
            break;

        case 40: // backward
            vehicle.applyEngineForce(up ? 0 : maxForce, 2);
            vehicle.applyEngineForce(up ? 0 : maxForce, 3);
            break;

        case 66: // b
            vehicle.setBrake(brakeForce, 0);
            vehicle.setBrake(brakeForce, 1);
            vehicle.setBrake(brakeForce, 2);
            vehicle.setBrake(brakeForce, 3);
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
