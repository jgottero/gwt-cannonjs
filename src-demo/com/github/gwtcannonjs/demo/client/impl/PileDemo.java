/* The MIT License (MIT)
 * 
 * Copyright (c) 2015 Jérémie Gottero
 */

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.solver.GSSolver;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Timer;

public class PileDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Pile";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.pileDemo().getText();
    }

    private int i;
    private Timer interval = null;
    
    @Override
    public void run() {
        final Demo demo = CANNON.newDemo();
        final double size = 1;

        // Spheres
        demo.addScene("Pile", new AddSceneCallback() {
            @Override
            public void execute() {
                if (interval != null) interval.cancel();

                final World world = demo.getWorld();

                world.getGravity().set(0,0,-50);
                world.setBroadphase(CANNON.newNaiveBroadphase());
                ((GSSolver) world.getSolver().cast()).setIterations(5);

                world.getDefaultContactMaterial().setContactEquationStiffness(5e6);
                world.getDefaultContactMaterial().setContactEquationRelaxation(10);

                // Since we have many bodies and they don't move very much, we can use the less accurate quaternion normalization
                world.setQuatNormalizeFast(true);
                world.setQuatNormalizeSkip(4); // ...and we do not have to normalize every step.

                // ground plane
                Shape groundShape = CANNON.newPlane();
                Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                groundBody.addShape(groundShape);
                groundBody.getPosition().set(0,0,0);
                world.addBody(groundBody);
                demo.addVisual(groundBody);

                // plane -x
                Shape planeShapeXmin = CANNON.newPlane();
                Body planeXmin = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                planeXmin.addShape(planeShapeXmin);
                planeXmin.getQuaternion().setFromAxisAngle(CANNON.newVec3(0,1,0),Math.PI/2);
                planeXmin.getPosition().set(-5,0,0);
                world.addBody(planeXmin);

                // Plane +x
                Shape planeShapeXmax = CANNON.newPlane();
                Body planeXmax = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                planeXmax.addShape(planeShapeXmax);
                planeXmax.getQuaternion().setFromAxisAngle(CANNON.newVec3(0,1,0),-Math.PI/2);
                planeXmax.getPosition().set(5,0,0);
                world.addBody(planeXmax);

                // Plane -y
                Shape planeShapeYmin = CANNON.newPlane();
                Body planeYmin = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                planeYmin.addShape(planeShapeYmin);
                planeYmin.getQuaternion().setFromAxisAngle(CANNON.newVec3(1,0,0),-Math.PI/2);
                planeYmin.getPosition().set(0,-5,0);
                world.addBody(planeYmin);

                // Plane +y
                Shape planeShapeYmax = CANNON.newPlane();
                Body planeYmax = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                planeYmax.addShape(planeShapeYmax);
                planeYmax.getQuaternion().setFromAxisAngle(CANNON.newVec3(1,0,0),Math.PI/2);
                planeYmax.getPosition().set(0,5,0);
                world.addBody(planeYmax);

                final JsArray<Body> bodies = JsArray.createArray().cast();
                i = 0;
                interval = new Timer() {
                    @Override
                    public void run() {
                        // Sphere
                        i++;
                        Shape sphereShape = CANNON.newSphere(size);
                        Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                        b1.addShape(sphereShape);
                        b1.getPosition().set(2*size*Math.sin(i),2*size*Math.cos(i),7*2*size);
                        world.addBody(b1);
                        demo.addVisual(b1);
                        bodies.push(b1);

                        if(bodies.length()>80){
                            Body b = bodies.shift();
                            demo.removeVisual(b);
                            world.remove(b);
                        }
                    }
                };
                interval.scheduleRepeating(100);
            }
        });

        demo.start();
    }
}
