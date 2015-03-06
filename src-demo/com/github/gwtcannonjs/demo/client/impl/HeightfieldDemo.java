// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Heightfield;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

public class HeightfieldDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Heightfield";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.heightfieldDemo().getText();
    }
    
    @Override
    public void run() {
        // Set to true to create convexes instead. Will prove that performance is much better with a real heightfield.
        final boolean mock = false;

        final Demo demo = CANNON.newDemo();

        demo.addScene("Heightfield", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = demo.getWorld();
                world.getGravity().set(0, 0, -10);
                world.setBroadphase(CANNON.newNaiveBroadphase());
    
                JsArray<JsArrayNumber> matrix = JsArray.createArray().cast();
                double sizeX = 15,
                        sizeY = 15;
    
                for (int i = 0; i < sizeX; i++) {
                    matrix.push((JsArrayNumber) JsArray.createArray().cast());
                    for (int j = 0; j < sizeY; j++) {
                        double height = Math.cos(i/sizeX * Math.PI * 2)*Math.cos(j/sizeY * Math.PI * 2) + 2;
                        if(i==0 || i == sizeX-1 || j==0 || j == sizeY-1)
                            height = 3;
                        matrix.get(i).push(height);
                    }
                }
    
                Heightfield hfShape = CANNON.newHeightfield(matrix, CANNON.newHeightfieldOptions().
                    withElementSize(1)
                );
                Body hfBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                hfBody.addShape(hfShape);
                hfBody.getPosition().set(-sizeX * hfShape.getElementSize() / 2, -20, -10);
                if(!mock){
                    world.addBody(hfBody);
                    demo.addVisual(hfBody);
                }
    
                double mass = 1;
    
                for(int i=0; i<sizeX - 1; i++){
                    for (int j = 0; j < sizeY - 1; j++) {
                        if(i==0 || i >= sizeX-2 || j==0 || j >= sizeY-2)
                            continue;
                        Shape sphereShape = CANNON.newSphere(0.1);
                        Body sphereBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                        sphereBody.addShape(sphereShape);
                        sphereBody.getPosition().set(0.25 + i, 0.25 + j, 3);
                        sphereBody.getPosition().vadd(hfBody.getPosition(), sphereBody.getPosition());
                        world.addBody(sphereBody);
                        demo.addVisual(sphereBody);
                    }
                }
    
                if(mock){
                    for(int i=0; i<sizeX - 1; i++){
                        for (int j = 0; j < sizeY - 1; j++) {
                            for (int k = 0; k < 2; k++) {
                                hfShape.getConvexTrianglePillar(i, j, k != 0);
                                Body convexBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                                convexBody.addShape(hfShape.getPillarConvex());
                                hfBody.pointToWorldFrame(hfShape.getPillarOffset(), convexBody.getPosition());
                                world.addBody(convexBody);
                                demo.addVisual(convexBody);
                            }
                        }
                    }
                }
            }
        });

        demo.start();
    }
}
