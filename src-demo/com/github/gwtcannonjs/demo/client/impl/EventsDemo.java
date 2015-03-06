// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.utils.CollideEvent;
import com.github.gwtcannonjs.client.utils.Event;
import com.github.gwtcannonjs.client.utils.EventListener;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class EventsDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Events";
    }
    
    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.eventsDemo().getText();
    }
    
    @Override
    public void run() {
        /**
         * For demonstrating events.
         */

        final Demo demo = CANNON.newDemo();
        final double size = 1;

        demo.addScene("'collide' event", new AddSceneCallback() {
            @Override
            public void execute() {
                // Create world
                World world = demo.getWorld();

                world.getDefaultContactMaterial().setContactEquationStiffness(5e7);
                world.getDefaultContactMaterial().setContactEquationRelaxation(4);

                world.getGravity().set(0,0,-20);

                // ground plane
                Shape groundShape = CANNON.newPlane();
                Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                groundBody.addShape(groundShape);
                world.addBody(groundBody);
                demo.addVisual(groundBody);

                // Sphere
                Shape sphere = CANNON.newSphere(size);
                Body sphereBody = CANNON.newBody(CANNON.newBodyOptions().withMass(30));
                sphereBody.addShape(sphere);
                sphereBody.getPosition().set(0,0,size*6);
                world.addBody(sphereBody);
                demo.addVisual(sphereBody);

                // When a body collides with another body, they both dispatch the "collide" event.
                sphereBody.addEventListener("collide", new EventListener() {
                    @Override
                    public void onEvent(Event event) {
                        consoleLog("The sphere just collided with the ground!");
                        consoleLog("Collided with body:", ((CollideEvent) event.cast()).getBody());
                        consoleLog("Contact between bodies:", ((CollideEvent) event.cast()).getContact());
                    }
                    
                    private native void consoleLog(Object o) /*-{
                        $wnd.console.log(o);
                    }-*/;
                    
                    private native void consoleLog(Object o1, Object o2) /*-{
                        $wnd.console.log(o1, o2);
                    }-*/;
                });
            }
        });

        demo.start();
    }
}
