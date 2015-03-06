// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.math.Quaternion;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.solver.GSSolver;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class CollisionsDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Collisions";
    }
    
    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.collisionsDemo().getText();
    }
    
    @Override
    public void run() {
        /**
         * For debugging different kinds of pair collisions
         */
        final Demo demo = CANNON.newDemo();

        demo.addScene("Sphere / sphere", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                // Sphere 1
                Shape sphereShape = CANNON.newSphere(1);
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(sphereShape);
                b1.getPosition().set(5,0,0);
                b1.getVelocity().set(-5,0,0);
                b1.setLinearDamping(0);
                world.addBody(b1);
                demo.addVisual(b1);

                // Sphere 2
                Body b2 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b2.addShape(sphereShape);
                b2.setLinearDamping(0);
                b2.getPosition().set(-5,0,0);
                b2.getVelocity().set(5,0,0);
                world.addBody(b2);
                demo.addVisual(b2);
            }
        });

        // Sphere / box side
        demo.addScene("Sphere / box side", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
    
                Shape boxShape = CANNON.newBox(CANNON.newVec3(1,1,1));
                Shape sphereShape = CANNON.newSphere(1);
    
                // Box
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(boxShape);
                b1.getPosition().set(5,0,0);
                b1.getVelocity().set(-5,0,0);
                b1.setLinearDamping(0);
                world.addBody(b1);
                demo.addVisual(b1);
    
                // Sphere
                Body b2 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b2.addShape(sphereShape);
                b2.getPosition().set(-5,0,0);
                b2.getVelocity().set(5,0,0);
                b2.setLinearDamping(0);
                world.addBody(b2);
                demo.addVisual(b2);
            }
        });

        demo.addScene("Sphere / box edge", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                Shape boxShape = CANNON.newBox(CANNON.newVec3(1,1,1));
                Shape sphereShape = CANNON.newSphere(1);

                // Box
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(boxShape);
                b1.getPosition().set(5,0,0);
                b1.getVelocity().set(-5,0,0);
                b1.setLinearDamping(0);
                Quaternion q = CANNON.newQuaternion();
                q.setFromAxisAngle(CANNON.newVec3(0,0,1),Math.PI*0.25);
                b1.getQuaternion().set(q.getX(),q.getY(),q.getZ(),q.getW());
                world.addBody(b1);
                demo.addVisual(b1);

                // Sphere
                Body b2 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b2.addShape(sphereShape);
                b2.getPosition().set(-5,0,0);
                b2.getVelocity().set(5,0,0);
                b2.setLinearDamping(0);
                world.addBody(b2);
                demo.addVisual(b2);
            }
        });

        demo.addScene("Sphere / box corner", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                Shape boxShape = CANNON.newBox(CANNON.newVec3(1,1,1));
                Shape sphereShape = CANNON.newSphere(1);

                // Box
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(boxShape);
                b1.getPosition().set(5,0,0);
                b1.getVelocity().set(-5,0,0);
                b1.setLinearDamping(0);
                Quaternion q1 = CANNON.newQuaternion();
                q1.setFromAxisAngle(CANNON.newVec3(0,0,1),Math.PI*0.25);
                Quaternion q2 = CANNON.newQuaternion();
                q2.setFromAxisAngle(CANNON.newVec3(0,1,0),Math.PI*0.25);
                Quaternion q = q1.mult(q2, null);
                b1.getQuaternion().set(q.getX(),q.getY(),q.getZ(),q.getW());
                world.addBody(b1);
                demo.addVisual(b1);

                // Sphere
                Body b2 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b2.addShape(sphereShape);
                b2.getPosition().set(-5,0,0);
                b2.getVelocity().set(5,0,0);
                b2.setLinearDamping(0);
                world.addBody(b2);
                demo.addVisual(b2);
            }
        });

        demo.start();
    }

    private World setupWorld(Demo demo) {
        // Create world
        World world = demo.getWorld();
        world.getGravity().set(0,0,0); // no gravity
        world.setBroadphase(CANNON.newNaiveBroadphase());
        ((GSSolver) world.getSolver().cast()).setIterations(5);
        world.getDefaultContactMaterial().setContactEquationStiffness(1e6);
        world.getDefaultContactMaterial().setContactEquationRelaxation(10);
        return world;
    }
}
