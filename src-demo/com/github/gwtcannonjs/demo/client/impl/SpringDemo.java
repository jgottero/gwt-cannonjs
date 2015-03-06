/* The MIT License (MIT)
 * 
 * Copyright (c) 2015 Jérémie Gottero
 */

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.objects.Spring;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.utils.Event;
import com.github.gwtcannonjs.client.utils.EventListener;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class SpringDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Spring";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.springDemo().getText();
    }

    @Override
    public void run() {
        final Demo demo = CANNON.newDemo();
        final double size = 1;

        demo.addScene("Box", new AddSceneCallback() {
            @Override
            public void execute() {
                // Create world
                World world = demo.getWorld();
                world.getGravity().set(0,0,-10);
                world.setBroadphase(CANNON.newNaiveBroadphase());

                // Create a static sphere
                Shape sphereShape = CANNON.newSphere(0.1);
                Body sphereBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                sphereBody.addShape(sphereShape);
                world.addBody(sphereBody);
                demo.addVisual(sphereBody);

                // Create a box body
                Vec3 halfExtents = CANNON.newVec3(size,size*0.3,size);
                Shape boxShape = CANNON.newBox(halfExtents);
                Body boxBody = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                boxBody.addShape(boxShape);
                boxBody.getPosition().set(-size,0,-size);
                world.addBody(boxBody);
                demo.addVisual(boxBody);

                final Spring spring = CANNON.newSpring(boxBody,sphereBody,CANNON.newSpringOptions().
                    withLocalAnchorA(CANNON.newVec3(size,0,size)).
                    withLocalAnchorB(CANNON.newVec3(0,0,0)).
                    withRestLength(0).
                    withStiffness(50).
                    withDamping(1)
                );

                // Compute the force after each step
                world.addEventListener("postStep", new EventListener() {
                    @Override
                    public void onEvent(Event event) {
                        spring.applyForce();
                    }
                });
            }
        });

        demo.start();
    }
}
