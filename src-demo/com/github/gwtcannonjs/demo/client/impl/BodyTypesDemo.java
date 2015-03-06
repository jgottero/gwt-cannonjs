// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.demo.client.DemoInstance;
import com.google.gwt.user.client.Timer;
import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Box;
import com.github.gwtcannonjs.client.shapes.Plane;
import com.github.gwtcannonjs.client.shapes.Sphere;
import com.github.gwtcannonjs.client.solver.GSSolver;
import com.github.gwtcannonjs.client.world.World;

public class BodyTypesDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Body types";
    }
    
    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.bodyTypesDemo().getText();
    }
    
    @Override
    public void run() {
        /**
         * Demos of the Body.type types.
         */
        final Demo demo = CANNON.newDemo();
        final int size = 2;

        demo.addScene("Moving box", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                Box boxShape = CANNON.newBox(CANNON.newVec3(size,size,size));
                Sphere sphereShape = CANNON.newSphere(size);

                double mass = 5, boxMass = 0;

                // Kinematic Box
                // Does only collide with dynamic bodies, but does not respond to any force.
                // Its movement can be controlled by setting its velocity.
                final Body b1 = CANNON.newBody(CANNON.newBodyOptions().
                        withMass(boxMass).
                        withType(Body.KINEMATIC).
                        withPosition(CANNON.newVec3(0, 0, 0.5*size)));
                b1.addShape(boxShape);
                world.addBody(b1);
                demo.addVisual(b1);

                // To control the box movement we must set its velocity
                b1.getVelocity().set(0,0,5);
                new Timer() {
                    @Override
                    public void run() {
                        if(b1.getVelocity().getZ()<0)
                            b1.getVelocity().set(0,0,5);
                        else
                            b1.getVelocity().set(0,0,-5);
                    }
                }.scheduleRepeating(1000);

                // Dynamic Sphere
                // Dynamic bodies can collide with bodies of all other types.
                Body b2 = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                b2.addShape(sphereShape);
                b2.getPosition().set(0,0,3*size);
                world.addBody(b2);
                demo.addVisual(b2);
            }
        });

        demo.start();
    }
    
    private static World setupWorld(Demo demo) {
        World world = demo.getWorld();
        world.getGravity().set(0,0,-40);
        world.setBroadphase(CANNON.newNaiveBroadphase());
        ((GSSolver) world.getSolver().cast()).setIterations(10);

        world.getDefaultContactMaterial().setContactEquationStiffness(1e8);
        world.getDefaultContactMaterial().setContactEquationRelaxation(10);

        // Static ground plane
        // Static bodies only interacts with dynamic bodies. Velocity is always zero.
        Plane groundShape = CANNON.newPlane();
        double mass = 0; // mass=0 will produce a static body automatically
        Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
        groundBody.addShape(groundShape);
        world.addBody(groundBody);
        demo.addVisual(groundBody);

        return world;
    }
}
