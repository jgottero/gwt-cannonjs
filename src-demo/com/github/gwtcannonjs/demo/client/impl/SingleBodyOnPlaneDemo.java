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

public class SingleBodyOnPlaneDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Single body on plane";
    }
    
    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.singleBodyOnPlaneDemo().getText();
    }
    
    @Override
    public void run() {
        final Demo demo = CANNON.newDemo();
        final double size = 2;

        demo.addScene("Sphere", new AddSceneCallback() {
            @Override
            public void execute() {
                Shape sphereShape = CANNON.newSphere(size);
                createBodyOnPlane(demo,sphereShape,size);
            }
        });

        demo.addScene("Box", new AddSceneCallback() {
            @Override
            public void execute() {
                Shape boxShape = CANNON.newBox(CANNON.newVec3(size,size,size));
                createBodyOnPlane(demo,boxShape,size);
            }
        });

        demo.start();
    }

    private void createBodyOnPlane(Demo demo, Shape shape, double size){

        // Create world
        World world = demo.getWorld();
        world.getGravity().set(0,0,-10);
        world.setBroadphase(CANNON.newNaiveBroadphase());
        ((GSSolver) world.getSolver().cast()).setIterations(10);

        world.getDefaultContactMaterial().setContactEquationStiffness(1e7);
        world.getDefaultContactMaterial().setContactEquationRelaxation(4);

        // ground plane
        Shape groundShape = CANNON.newPlane();
        Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
        groundBody.addShape(groundShape);
        world.addBody(groundBody);
        demo.addVisual(groundBody);

        // Shape on plane
        Body shapeBody = CANNON.newBody(CANNON.newBodyOptions().withMass(30));
        shapeBody.addShape(shape);
        shapeBody.getPosition().set(0,size,size*2);
        shapeBody.getVelocity().set(0,0,0);
        shapeBody.getAngularVelocity().set(0,0,0);
        world.addBody(shapeBody);
        demo.addVisual(shapeBody);
    }
}
