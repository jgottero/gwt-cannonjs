// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.material.ContactMaterial;
import com.github.gwtcannonjs.client.material.Material;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.solver.GSSolver;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class FrictionDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Friction";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.frictionDemo().getText();
    }
    
    @Override
    public void run() {
        /**
         * Demonstrates how to make several materials with different friction properties.
         */

        final Demo demo = CANNON.newDemo();
        final double size = 1.0;

        demo.addScene("Friction", new AddSceneCallback() {
            @Override
            public void execute() {
                Shape shape = CANNON.newBox(CANNON.newVec3(size,size,size));

                // Create world
                World world = demo.getWorld();
                world.setBroadphase(CANNON.newNaiveBroadphase());
                ((GSSolver) world.getSolver().cast()).setIterations(10);

                // Materials
                Material groundMaterial = CANNON.newMaterial("groundMaterial");

                // Adjust constraint equation parameters for ground/ground contact
                ContactMaterial ground_ground_cm = CANNON.newContactMaterial(groundMaterial, groundMaterial, CANNON.newContactMaterialOptions().
                    withFriction(0.4).
                    withRestitution(0.3).
                    withContactEquationStiffness(1e8).
                    withContactEquationRelaxation(3).
                    withFrictionEquationStiffness(1e8).
                    withFrictionEquationRelaxation(3)
                );

                // Add contact material to the world
                world.addContactMaterial(ground_ground_cm);

                // ground plane
                Shape groundShape = CANNON.newPlane();
                Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(groundMaterial));
                groundBody.addShape(groundShape);
                world.addBody(groundBody);
                demo.addVisual(groundBody);

                // Create a slippery material (friction coefficient = 0.0)
                Material slipperyMaterial = CANNON.newMaterial("slipperyMaterial");

                // The ContactMaterial defines what happens when two materials meet.
                // In this case we want friction coefficient = 0.0 when the slippery material touches ground.
                ContactMaterial slippery_ground_cm = CANNON.newContactMaterial(groundMaterial, slipperyMaterial, CANNON.newContactMaterialOptions().
                    withFriction(0).
                    withRestitution(0.3).
                    withContactEquationStiffness(1e8).
                    withContactEquationRelaxation(3)
                );

                // We must add the contact materials to the world
                world.addContactMaterial(slippery_ground_cm);

                // Create slippery box
                Body boxBody = CANNON.newBody(CANNON.newBodyOptions().withMass(1).withMaterial(slipperyMaterial));
                boxBody.addShape(shape);
                boxBody.getPosition().set(0,0,5);
                world.addBody(boxBody);
                demo.addVisual(boxBody);

                // Create box made of groundMaterial
                Body boxBody2 = CANNON.newBody(CANNON.newBodyOptions().withMass(10).withMaterial(groundMaterial));
                boxBody2.addShape(shape);
                boxBody2.getPosition().set(size*4,0,5);
                world.addBody(boxBody2);
                demo.addVisual(boxBody2);

                // Change gravity so the boxes will slide along x axis
                world.getGravity().set(-3,0,-60);
            }
        });

        demo.start();
    }
}
