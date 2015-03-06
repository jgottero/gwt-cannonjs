// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.material.ContactMaterial;
import com.github.gwtcannonjs.client.material.Material;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.objects.SPHSystem;
import com.github.gwtcannonjs.client.shapes.Plane;
import com.github.gwtcannonjs.client.solver.GSSolver;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class SphDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Sph";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.sphDemo().getText();
    }
    
    @Override
    public void run() {
        final Demo demo = CANNON.newDemo();
        final int nx=4, ny=4, nz=15;
        final double w=10, h=5, mass=0.01;
        final boolean walls = true;

        // Test scalability - add scenes for different number of particles
        demo.addScene((nx*ny*nz)+ " particles", new AddSceneCallback() {
            @Override
            public void execute() {
                // Create world
                World world = demo.getWorld();
                SPHSystem sph = CANNON.newSPHSystem();
                sph.setDensity(1);
                sph.setViscosity(0.03);
                sph.setSmoothingRadius(1.0);
                world.getSubsystems().push(sph);

                // Tweak contact properties.
                world.getDefaultContactMaterial().setContactEquationStiffness(1e11); // Contact stiffness - use to make softer/harder contacts
                world.getDefaultContactMaterial().setContactEquationRelaxation(2); // Stabilization time in number of timesteps

                // Max solver iterations: Use more for better force propagation, but keep in mind that it's not very computationally cheap!
                ((GSSolver) world.getSolver().cast()).setIterations(10);

                world.getGravity().set(0,0,-10);

                // Materials
                Material material = CANNON.newMaterial();
                ContactMaterial material_material = CANNON.newContactMaterial(material, material, CANNON.newContactMaterialOptions().
                        withFriction(0.06).
                        withRestitution(0.0)
                        );
                world.addContactMaterial(material_material);

                // ground plane
                Plane groundShape = CANNON.newPlane();
                Body groundBody = CANNON.newBody(CANNON.newBodyOptions().
                    withMass(0).
                    withMaterial(material)
                );
                groundBody.addShape(groundShape);
                world.addBody(groundBody);
                demo.addVisual(groundBody);

                if(walls){

                    // plane -x
                    Plane planeShapeXmin = CANNON.newPlane();
                    Body planeXmin = CANNON.newBody(CANNON.newBodyOptions().
                        withMass(0).
                        withMaterial(material)
                    );
                    planeXmin.addShape(planeShapeXmin);
                    planeXmin.getQuaternion().setFromAxisAngle(CANNON.newVec3(0,1,0),Math.PI/2);
                    planeXmin.getPosition().set(-w*0.5,0,0);
                    world.addBody(planeXmin);

                    // Plane +x
                    Plane planeShapeXmax = CANNON.newPlane();
                    Body planeXmax = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(material));
                    planeXmax.addShape(planeShapeXmax);
                    planeXmax.getQuaternion().setFromAxisAngle(CANNON.newVec3(0,1,0),-Math.PI/2);
                    planeXmax.getPosition().set(w*0.5,0,0);
                    world.addBody(planeXmax);

                    // Plane -y
                    Plane planeShapeYmin = CANNON.newPlane();
                    Body planeYmin = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(material));
                    planeYmin.addShape(planeShapeYmin);
                    planeYmin.getQuaternion().setFromAxisAngle(CANNON.newVec3(1,0,0),-Math.PI/2);
                    planeYmin.getPosition().set(0,-h*0.5,0);
                    world.addBody(planeYmin);

                    // Plane +y
                    Plane planeShapeYmax = CANNON.newPlane();
                    Body planeYmax = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(material));
                    planeYmax.addShape(planeShapeYmax);
                    planeYmax.getQuaternion().setFromAxisAngle(CANNON.newVec3(1,0,0), Math.PI/2);
                    planeYmax.getPosition().set(0,h*0.5,0);
                    world.addBody(planeYmax);
                }

                // Create particles
                double rand = 0.1;
                for(int i=0; i!=nx; i++){
                    for(int j=0; j!=ny; j++){
                        for(int k=0; k!=nz; k++){
                            Body particle = CANNON.newBody(CANNON.newBodyOptions().
                                    withMass(mass).
                                    withMaterial(material)
                                    );
                            particle.addShape(CANNON.newParticle());
                            particle.getPosition().set((i + (Math.random()-0.5)*rand + 0.5)*w/nx - w*0.5,
                                    (j + (Math.random()-0.5)*rand + 0.5)*h/ny - h*0.5,
                                    k*h/ny);
                            world.addBody(particle);
                            sph.add(particle);
                            demo.addVisual(particle);
                        }
                    }
                }
            }
        });

        demo.start();
    }
}
