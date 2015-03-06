// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.demo.client.DemoInstance;
import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.material.ContactMaterial;
import com.github.gwtcannonjs.client.material.Material;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Plane;
import com.github.gwtcannonjs.client.shapes.Sphere;
import com.github.gwtcannonjs.client.world.World;

public class BounceDemo implements DemoInstance {
	@Override
	public String getName() {
		return "Bounce";
	}

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.bounceDemo().getText();
    }
    
	@Override
    public void run() {
        final Demo demo = CANNON.newDemo();
        final int size = 1;
        final int height = 5;
        final double damping = 0.01;

        demo.addScene("Bounce", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = demo.getWorld();
                world.getGravity().set(0,0,-10);
                world.setBroadphase(CANNON.newNaiveBroadphase());

                // ground plane
                Material groundMaterial = CANNON.newMaterial();
                Plane groundShape = CANNON.newPlane();
                Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(groundMaterial));
                groundBody.addShape(groundShape);
                world.addBody(groundBody);
                demo.addVisual(groundBody);

                double mass = 10;
                Sphere sphereShape = CANNON.newSphere(size);

                // Shape on plane
                Material mat1 = CANNON.newMaterial();
                Body shapeBody1 = CANNON.newBody(CANNON.newBodyOptions().withMass(mass).withMaterial(mat1));
                shapeBody1.addShape(sphereShape);
                shapeBody1.getPosition().set(3*size, size, height);
                shapeBody1.setLinearDamping(damping);
                world.addBody(shapeBody1);
                demo.addVisual(shapeBody1);

                Material mat2 = CANNON.newMaterial();
                Body shapeBody2 = CANNON.newBody(CANNON.newBodyOptions().withMass(mass).withMaterial(mat2));
                shapeBody2.addShape(sphereShape);
                shapeBody2.getPosition().set(0 , size , height);
                shapeBody2.setLinearDamping(damping);
                world.addBody(shapeBody2);
                demo.addVisual(shapeBody2);

                Material mat3 = CANNON.newMaterial();
                Body shapeBody3 = CANNON.newBody(CANNON.newBodyOptions().withMass(mass).withMaterial(mat3));
                shapeBody3.addShape(sphereShape);
                shapeBody3.getPosition().set(-3*size , size , height);
                shapeBody3.setLinearDamping(damping);
                world.addBody(shapeBody3);
                demo.addVisual(shapeBody3);

                // Create contact material behaviour
                ContactMaterial mat1_ground = CANNON.newContactMaterial(groundMaterial, mat1, CANNON.newContactMaterialOptions().withFriction(0.0).withRestitution(0.0));
                ContactMaterial mat2_ground = CANNON.newContactMaterial(groundMaterial, mat2, CANNON.newContactMaterialOptions().withFriction(0.0).withRestitution(0.7));
                ContactMaterial mat3_ground = CANNON.newContactMaterial(groundMaterial, mat3, CANNON.newContactMaterialOptions().withFriction(0.0).withRestitution(0.9));

                world.addContactMaterial(mat1_ground);
                world.addContactMaterial(mat2_ground);
                world.addContactMaterial(mat3_ground);
            }
        });

        demo.start();
    }
}
