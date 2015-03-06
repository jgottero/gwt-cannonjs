// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.objects.PreStepCallback;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class CallbacksDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Callbacks";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.callbacksDemo().getText();
    }
    
    @Override
    public void run() {
        /**
         * A demo showing how to use the preStep callback to add a force to a body.
         * This will act like a force field.
         */

        final Demo demo = CANNON.newDemo();

        demo.addScene("Moon", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = demo.getWorld();

                double mass = 5;
                Shape moonShape = CANNON.newSphere(0.5);
                Shape planetShape = CANNON.newSphere(3.5);
                final Body moon = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                moon.addShape(moonShape);
                Body planet = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                planet.addShape(planetShape);

                moon.getPosition().set(5,0,0);
                moon.getVelocity().set(0,0,8);
                moon.setLinearDamping(0.0);

                // Use the preStep callback to apply the gravity force on the moon.
                // This callback is evoked each timestep.
                moon.setPreStep(new PreStepCallback() {
                    @Override
                    public void execute() {
                        // Get the vector pointing from the moon to the planet center
                        Vec3 moon_to_planet = CANNON.newVec3();
                        moon.getPosition().negate(moon_to_planet);

                        // Get distance from planet to moon
                        double distance = moon_to_planet.norm();

                        // Now apply force on moon
                        // Fore is pointing in the moon-planet direction
                        moon_to_planet.normalize();
                        moon_to_planet.mult(1500/Math.pow(distance,2),moon.getForce());
                    }
                });

                // We add the objects to the world to simulate them
                world.addBody(moon);
                world.addBody(planet);

                // And we add them to the demo to make them visible
                demo.addVisual(moon);
                demo.addVisual(planet);
            }
        });

        demo.start();
    }
}
