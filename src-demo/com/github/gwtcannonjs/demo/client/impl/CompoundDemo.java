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

public class CompoundDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Compound";
    }
    
    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.compoundDemo().getText();
    }
    
    @Override
    public void run() {
        /**
         * A Compound shape is a shape built out of other shapes called child-shapes.
         * You can see it as a holder of a group of other shapes.
         * Use the compound shape to build rigid bodies that have more complex geometry.
         * For example, you can build concave shapes. When a child shape is added to
         * the Compound shape, a transform consisting of a position and a quaternion is
         * needed. This enables you to add child shapes at any position, rotated however
         * you like inside the local coordinate system of the Compound shape.
         */

        final Demo demo = CANNON.newDemo();

        // A compound shape consisting of a number of boxes.
        demo.addScene("Boxes", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                // Create the compound shape
                //var compoundShape = CANNON.newCompound();
                double s = 1.5;

                // Now create a Body for our Compound
                double mass = 10;
                Body body = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                body.getPosition().set(0,0,6);
                body.getQuaternion().setFromAxisAngle(CANNON.newVec3(0, 1, 0), Math.PI / 32);

                // Use a box shape as child shape
                Shape shape = CANNON.newBox(CANNON.newVec3(0.5*s,0.5*s,0.5*s));

                // We can add the same shape several times to position child shapes within the Compound.
                body.addShape(shape, CANNON.newVec3( s, 0,-s));
                body.addShape(shape, CANNON.newVec3( s, 0, s));
                body.addShape(shape, CANNON.newVec3(-s, 0,-s));
                body.addShape(shape, CANNON.newVec3(-s, 0, s));
                // Note: we only use translational offsets. The third argument could be a CANNON.Quaternion to rotate the child shape.
                body.addShape(shape, CANNON.newVec3(-s, 0, 0));
                body.addShape(shape, CANNON.newVec3( 0, 0,-s));
                body.addShape(shape, CANNON.newVec3( 0, 0, s));

                world.addBody(body);
                demo.addVisual(body);
            }
        });

        // Here we create a compound made out of spheres
        demo.addScene("Spheres", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                double mass = 10;
                Body body = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));

                // Compound shape
                Shape sphereShape = CANNON.newSphere(1);
                body.addShape(sphereShape, CANNON.newVec3( 1, 0,-1));
                body.addShape(sphereShape, CANNON.newVec3( 1, 0, 1));
                body.addShape(sphereShape, CANNON.newVec3(-1, 0,-1));
                body.addShape(sphereShape, CANNON.newVec3(-1, 0, 1));

                body.getPosition().set(0,0,6);
                body.getQuaternion().set(0,1,0,0.1);
                world.addBody(body);
                demo.addVisual(body);
            }
        });

        demo.start();
    }

    private World setupWorld(Demo demo){
        World world = demo.getWorld();
        world.getGravity().set(0,0,-30);
        world.setBroadphase(CANNON.newNaiveBroadphase());
        ((GSSolver) world.getSolver().cast()).setIterations(10);

        // ground plane
        Shape groundShape = CANNON.newPlane();
        Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
        groundBody.addShape(groundShape);
        world.addBody(groundBody);
        demo.addVisual(groundBody);

        return world;
    };
}
