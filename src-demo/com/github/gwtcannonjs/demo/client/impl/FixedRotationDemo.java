// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Box;
import com.github.gwtcannonjs.client.shapes.Plane;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class FixedRotationDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Fixed rotation";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.fixedRotationDemo().getText();
    }
    
    @Override
	public void run() {
		final Demo demo = CANNON.newDemo();
		final double size = 1.0;

		demo.addScene("Fixed rotation", new AddSceneCallback() {
			@Override
			public void execute() {
				// Create world
				World world = demo.getWorld();
				world.setBroadphase(CANNON.newNaiveBroadphase());
	
				// ground plane
				Plane groundShape = CANNON.newPlane();
				Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
				groundBody.addShape(groundShape);
				world.addBody(groundBody);
				demo.addVisual(groundBody);
	
				// Create a box with fixed rotation
				Box shape = CANNON.newBox(CANNON.newVec3(size,size,size));
				Body boxBody = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
				boxBody.addShape(shape);
				boxBody.getPosition().set(0,0,size);
				boxBody.setFixedRotation(true);
				boxBody.updateMassProperties();
				world.addBody(boxBody);
				demo.addVisual(boxBody);
	
				// Another one
				Box shape2 = CANNON.newBox(CANNON.newVec3(size, size, size));
				Body boxBody2 = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
				boxBody2.addShape(shape2);
				boxBody2.getPosition().set(size*3/2, 0, size*4);
				boxBody2.setFixedRotation(true);
				boxBody2.updateMassProperties();
				world.addBody(boxBody2);
				demo.addVisual(boxBody2);
	
				// Change gravity so the boxes will slide along x axis
				world.getGravity().set(0, 0, -10);
			}
		});

		demo.start();
	}
}
