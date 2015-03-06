// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.solver.GSSolver;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class CollisionFilterDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Collision filter";
    }
    
    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.collisionFilterDemo().getText();
    }
    
    @Override
    public void run() {
        /**
         * Demonstrates how to filter collisions using Body.collisionFilterGroup and Body.collisionFilterMask.
         * The filters are applied inside the broadphase. It can be used to allow or disallow collisions between bodies.
         *
         * A collision is allowed if
         *   (bodyA.collisionFilterGroup & bodyB.collisionFilterMask) && (bodyB.collisionFilterGroup & bodyA.collisionFilterMask)
         *
         * These are indeed bitwise operations. Learn more about that here: http://en.wikipedia.org/wiki/Bitwise_operation
         */
        final Demo demo = CANNON.newDemo();
        final double size = 1;
        final double mass = 1;

        // Collision filter groups - must be powers of 2!
        final int GROUP1 = 1;
        final int GROUP2 = 2;
        final int GROUP3 = 4;

        demo.addScene("filter", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = demo.getWorld();
                world.getGravity().set(0,0,0); // no gravity
                world.setBroadphase(CANNON.newNaiveBroadphase());
                ((GSSolver) world.getSolver().cast()).setIterations(5);

                // Sphere
                Shape sphereShape = CANNON.newSphere(size);
                Body sphereBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                sphereBody.addShape(sphereShape);
                sphereBody.getPosition().set(5,0,0);
                sphereBody.getVelocity().set(-5,0,0);
                sphereBody.setCollisionFilterGroup(GROUP1);             // Put the sphere in group 1
                sphereBody.setCollisionFilterMask(GROUP2 | GROUP3);     // It can only collide with group 2 and 3

                // Box
                Shape boxShape = CANNON.newBox(CANNON.newVec3(size,size,size));
                Body boxBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                boxBody.addShape(boxShape);
                boxBody.setCollisionFilterGroup(GROUP2);                // Put the box in group 2
                boxBody.setCollisionFilterMask(GROUP1);                 // It can only collide with group 1 (the sphere)

                // Cylinder
                Shape cylinderShape = CANNON.newCylinder(size,size,size*2.2,10);
                Body cylinderBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                cylinderBody.addShape(cylinderShape);
                cylinderBody.getPosition().set(-5,0,0);
                cylinderBody.setCollisionFilterGroup(GROUP3);           // Put the cylinder in group 3
                cylinderBody.setCollisionFilterMask(GROUP1);            // It can only collide with group 1 (the sphere)

                // Add everything to the world and demo
                world.addBody(sphereBody);
                world.addBody(boxBody);
                world.addBody(cylinderBody);
                demo.addVisual(sphereBody);
                demo.addVisual(boxBody);
                demo.addVisual(cylinderBody);
            }
        });

        demo.start();
    }
}
