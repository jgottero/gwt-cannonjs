// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.constraints.HingeConstraint;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.material.ContactMaterial;
import com.github.gwtcannonjs.client.material.Material;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;
import com.google.gwt.core.client.JsArray;

public class HingeDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Hinge";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.hingeDemo().getText();
    }
    
    @Override
    public void run() {
        /**
         * Demonstrates how to use the HingeConstraint.
         * A hinge constraint makes sure that two bodies can rotate around a common axis. For example, think of a door hinge.
         */

        final Demo demo = CANNON.newDemo();
        final double mass = 1;

        demo.addScene("car", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = demo.getWorld();
                world.getGravity().set(0,0,-20);
    
                Material groundMaterial = CANNON.newMaterial("groundMaterial");
                Material wheelMaterial = CANNON.newMaterial("wheelMaterial");
                ContactMaterial wheelGroundContactMaterial = CANNON.newContactMaterial(groundMaterial,wheelMaterial, CANNON.newContactMaterialOptions().withFriction(0.5).withRestitution(0.3));
                world.addContactMaterial(wheelGroundContactMaterial);
    
                Shape wheelShape =      CANNON.newSphere(1.2);
                Body leftFrontWheel =  CANNON.newBody(CANNON.newBodyOptions().withMass(mass).withMaterial(wheelMaterial));
                leftFrontWheel.addShape(wheelShape);
                Body rightFrontWheel = CANNON.newBody(CANNON.newBodyOptions().withMass(mass).withMaterial(wheelMaterial));
                rightFrontWheel.addShape(wheelShape);
                Body leftRearWheel =   CANNON.newBody(CANNON.newBodyOptions().withMass(mass).withMaterial(wheelMaterial));
                leftRearWheel.addShape(wheelShape);
                Body rightRearWheel =  CANNON.newBody(CANNON.newBodyOptions().withMass(mass).withMaterial(wheelMaterial));
                rightRearWheel.addShape(wheelShape);
    
                Shape chassisShape = CANNON.newBox(CANNON.newVec3(5,2,0.5));
                Body chassis = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                chassis.addShape(chassisShape);
    
                // Position constrain wheels
                Vec3 zero = CANNON.newVec3();
                leftFrontWheel .getPosition().set(  5,  5, 0);
                rightFrontWheel.getPosition().set(  5, -5, 0);
                leftRearWheel  .getPosition().set( -5,  5, 0);
                rightRearWheel .getPosition().set( -5, -5, 0);
    
                // Constrain wheels
                JsArray<HingeConstraint> constraints = JsArray.createArray().cast();
    
                // Hinge the wheels
                Vec3 leftAxis =       CANNON.newVec3(0,1,0);
                Vec3 rightAxis =      CANNON.newVec3(0,-1,0);
                Vec3 leftFrontAxis =  CANNON.newVec3(0,1,0);
                Vec3 rightFrontAxis = CANNON.newVec3(0,-1,0);
                if(true){
                    leftFrontAxis =  CANNON.newVec3(0.3,0.7,0);
                    rightFrontAxis = CANNON.newVec3(-0.3,-0.7,0);
                    leftFrontAxis.normalize();
                    rightFrontAxis.normalize();
                }
    
                constraints.push(CANNON.newHingeConstraint(chassis, leftFrontWheel,  CANNON.newHingeConstraintOptions().withPivotA(CANNON.newVec3( 5, 5, 0)).withAxisA(leftFrontAxis). withPivotB(zero).withAxisB(leftAxis)));
                constraints.push(CANNON.newHingeConstraint(chassis, rightFrontWheel, CANNON.newHingeConstraintOptions().withPivotA(CANNON.newVec3( 5,-5, 0)).withAxisA(rightFrontAxis).withPivotB(zero).withAxisB(rightAxis)));
                constraints.push(CANNON.newHingeConstraint(chassis, leftRearWheel,   CANNON.newHingeConstraintOptions().withPivotA(CANNON.newVec3(-5, 5, 0)).withAxisA(leftAxis).      withPivotB(zero).withAxisB(leftAxis)));
                constraints.push(CANNON.newHingeConstraint(chassis, rightRearWheel,  CANNON.newHingeConstraintOptions().withPivotA(CANNON.newVec3(-5,-5, 0)).withAxisA(rightAxis).     withPivotB(zero).withAxisB(rightAxis)));
    
                for(int i=0; i<constraints.length(); i++)
                    world.addConstraint(constraints.get(i));
    
                JsArray<Body> bodies = JsArray.createArray().cast();
                bodies.push(chassis);
                bodies.push(leftFrontWheel);
                bodies.push(rightFrontWheel);
                bodies.push(leftRearWheel);
                bodies.push(rightRearWheel);
                for(int i=0; i<bodies.length(); i++){
                    world.addBody(bodies.get(i));
                    demo.addVisual(bodies.get(i));
                }
    
                // Ground
                Shape groundShape = CANNON.newPlane();
                Body ground = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(groundMaterial));
                ground.addShape(groundShape);
                ground.getPosition().setZ(-3);
                world.addBody(ground);
                demo.addVisual(ground);
    
                // Enable motors and set their velocities
                HingeConstraint frontLeftHinge = constraints.get(2);
                HingeConstraint frontRightHinge = constraints.get(3);
                frontLeftHinge.enableMotor();
                frontRightHinge.enableMotor();
                double v = -14;
                frontLeftHinge.setMotorTargetVelocity(v);
                frontRightHinge.setMotorTargetVelocity(-v);
            }
        });


        demo.addScene("hinge", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = demo.getWorld();
                world.getGravity().set(0,5,-20);
    
                double s = 5, d = 0.1*s;
                Shape shape = CANNON.newBox(CANNON.newVec3(s*0.5,s*0.1,s*0.5));
                Body body = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                body.addShape(shape);
                Body staticBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                staticBody.addShape(shape);
                staticBody.getPosition().setZ(s + d*2);
    
                // Hinge it
                HingeConstraint c = CANNON.newHingeConstraint(staticBody, body, CANNON.newHingeConstraintOptions().
                    withPivotA(CANNON.newVec3(0,0,-s*0.5-d)).
                    withAxisA(CANNON.newVec3(1,0,0)).
                    withPivotB(CANNON.newVec3(0,0,s*0.5+d)).
                    withAxisB(CANNON.newVec3(1,0,0))
                );
                world.addConstraint(c);
    
                world.addBody(body);
                world.addBody(staticBody);
                demo.addVisual(body);
                demo.addVisual(staticBody);
            }
        });

        demo.start();
    }
}
