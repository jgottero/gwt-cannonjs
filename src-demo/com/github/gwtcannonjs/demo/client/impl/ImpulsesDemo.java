// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class ImpulsesDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Impulses";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.impulsesDemo().getText();
    }

    @Override
    public void run() {
        /**
         * Demonstrates how to add impulses and forces to a body. You can add the impulses and forces to any point on the body.
         * Adding a force to the body will add to Body.force and Body.torque.
         * An impulse is a force added to a body during a short period of time (impulse = force * time). Impulses will be added to Body.velocity and Body.angularVelocity.
         */

        final Demo demo = CANNON.newDemo();

        final double radius=1, mass=2, f=500;
        final double dt=1/60., damping=0.5;

        // Add impulse to the body center
        demo.addScene("center impulse", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                Shape shape = CANNON.newSphere(radius);
                Body body = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                body.addShape(shape);
                body.setLinearDamping(damping);
                body.setAngularDamping(damping);
                world.addBody(body);
                demo.addVisual(body);

                // Add an impulse to the center
                Vec3 worldPoint = CANNON.newVec3(0,0,0);
                Vec3 impulse = CANNON.newVec3(f*dt,0,0);
                body.applyImpulse(impulse,worldPoint);
            }
        });

        // Add impulse to the top of the sphere
        demo.addScene("top impulse", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                Shape shape = CANNON.newSphere(radius);
                Body body = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                body.addShape(shape);
                body.setLinearDamping(damping);
                body.setAngularDamping(damping);
                world.addBody(body);
                demo.addVisual(body);

                // Add an impulse to the center
                Vec3 worldPoint = CANNON.newVec3(0,0,radius);
                Vec3 impulse = CANNON.newVec3(f*dt,0,0);
                body.applyImpulse(impulse,worldPoint);
            }
        });


        // Add force to the body center
        demo.addScene("center force", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                Shape shape = CANNON.newSphere(radius);
                Body body = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                body.addShape(shape);
                body.setLinearDamping(damping);
                body.setAngularDamping(damping);
                world.addBody(body);
                demo.addVisual(body);

                // Add an force to the center
                Vec3 worldPoint = CANNON.newVec3(0,0,0);
                Vec3 force = CANNON.newVec3(f,0,0);
                body.applyForce(force,worldPoint);
            }
        });

        // Add force to the top of the sphere
        demo.addScene("top force", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                Shape shape = CANNON.newSphere(radius);
                Body body = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                body.addShape(shape);
                body.setLinearDamping(damping);
                body.setAngularDamping(damping);
                world.addBody(body);
                demo.addVisual(body);

                // Add an force to the center
                Vec3 worldPoint = CANNON.newVec3(0,0,radius);
                Vec3 force = CANNON.newVec3(f,0,0);
                body.applyForce(force,worldPoint);
            }
        });

        demo.start();
    }
    
    private World setupWorld(Demo demo){
        World world = demo.getWorld();
        world.setBroadphase(CANNON.newNaiveBroadphase());
        return world;
    }
}
