// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.utils.Event;
import com.github.gwtcannonjs.client.utils.EventListener;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class SleepDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Sleep";
    }
    
    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.sleepDemo().getText();
    }
    
    @Override
    public void run() {
        /**
         * When a body sleeps, it does not move until it gets touched by another body.
         * Why is this handy? Well, it can help you get a more stable simulation, and increase performance. No collision detection is made between sleeping bodies (and static ones).
         */

        final Demo demo = CANNON.newDemo();
        final double size = 1;

        // Sleep demo
        demo.addScene("Sleep", new AddSceneCallback() {
            @Override
            public void execute() {
                // Create world and collision detection
                World world = demo.getWorld();
                world.getGravity().set(0,0,-10);
                world.setBroadphase(CANNON.newNaiveBroadphase());

                world.getDefaultContactMaterial().setContactEquationStiffness(1e7);
                world.getDefaultContactMaterial().setContactEquationRelaxation(5);

                // Create ground plane
                Shape groundShape = CANNON.newPlane();
                Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                groundBody.addShape(groundShape);

                // Create sphere
                Shape sphere = CANNON.newSphere(size);
                Body sphereBody = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
                sphereBody.addShape(sphere);
                sphereBody.getPosition().set(0,0,size*6);

                // Allow sleeping
                world.setAllowSleep(true);
                sphereBody.setAllowSleep(true);

                // Sleep parameters
                sphereBody.setSleepSpeedLimit(0.1); // Body will feel sleepy if speed<1 (speed == norm of velocity)
                sphereBody.setSleepTimeLimit(1); // Body falls asleep after 1s of sleepiness

                sphereBody.addEventListener("sleepy", new EventListener() {
                    @Override
                    public void onEvent(Event event) {
                        consoleLog("The sphere is feeling sleepy...");
                    }
                });

                sphereBody.addEventListener("sleep", new EventListener() {
                    @Override
                    public void onEvent(Event event) {
                        consoleLog("The sphere fell asleep!");
                    }
                });

                // Add bodies to the world
                world.addBody(sphereBody);
                world.addBody(groundBody);

                // Add visuals
                demo.addVisual(sphereBody);
                demo.addVisual(groundBody);
            }
        });


        // Wake up demo
        demo.addScene("Wake up", new AddSceneCallback() {
            @Override
            public void execute() {
                // Create world and collision detection
                World world = demo.getWorld();
                world.getGravity().set(0,0,-10);
                world.setBroadphase(CANNON.newNaiveBroadphase());

                // Create ground plane
                Shape groundShape = CANNON.newPlane();
                Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                groundBody.addShape(groundShape);

                // Create sphere
                double size = 2;
                Shape sphere = CANNON.newSphere(size);
                Body sphereBody = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
                sphereBody.addShape(sphere);
                sphereBody.getPosition().set(0,0,size);
                sphereBody.sleep();

                // Create sphere that will wake up the first one
                Body sphereBody2 = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
                sphereBody2.addShape(sphere);
                sphereBody2.getPosition().set(size*10,0,size);
                sphereBody2.getVelocity().set(-10,0,0);
                sphereBody2.setAngularDamping(0.0);
                sphereBody2.setLinearDamping(0.0);

                world.setAllowSleep(true);
                sphereBody.setAllowSleep(true);
                sphereBody2.setAllowSleep(true);

                sphereBody.setSleepSpeedLimit(0.5);
                sphereBody.setSleepTimeLimit(1);

                // The body wakes up when it gets a new contact
                sphereBody.addEventListener("wakeup", new EventListener() {
                    @Override
                    public void onEvent(Event event) {
                        consoleLog("The sphere woke up!");
                    }
                });

                // Add bodies to the world
                world.addBody(sphereBody);
                world.addBody(sphereBody2);
                world.addBody(groundBody);

                // Add visuals
                demo.addVisual(sphereBody);
                demo.addVisual(sphereBody2);
                demo.addVisual(groundBody);
            }
        });

        demo.start();
    }
    
    private native void consoleLog(Object o) /*-{
        $wnd.console.log(o);
    }-*/;

}
