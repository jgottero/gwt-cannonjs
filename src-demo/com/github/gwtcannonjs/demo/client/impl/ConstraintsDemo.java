// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.constraints.PointToPointConstraint;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.shapes.Sphere;
import com.github.gwtcannonjs.client.solver.GSSolver;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class ConstraintsDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Constraints";
    }
    
    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.constraintsDemo().getText();
    }
    
    @Override
    public void run() {
        /**
         * In this demo, we demonstrate some constraint types. Constraints
         * removes degrees of freedom from bodies and forces them to move in
         * a way defined by the constraint.
         */

        final Demo demo = CANNON.newDemo();

        // We link together boxes in a chain
        demo.addScene("links", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                world.getGravity().set(0,-1,-20);
                double size = 1;
                Shape boxShape = CANNON.newBox(CANNON.newVec3(size,size*0.1,size));
                double mass = 0;
                double space = 0.1*size;

                int N=10;
                Body last = null;
                for(int i=0; i<N; i++){
                    // Create a box
                    Body boxbody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                    boxbody.addShape(boxShape);
                    boxbody.getPosition().set(0,0,(N-i)*(size*2+2*space) + size*2+space);
                    boxbody.setLinearDamping(0.01); // Damping makes the movement slow down with time
                    boxbody.setAngularDamping(0.01);
                    world.addBody(boxbody);
                    demo.addVisual(boxbody);

                    if(i!=0){
                        // Connect the current body to the last one
                        // We connect two corner points to each other.
                        PointToPointConstraint c1 = CANNON.newPointToPointConstraint(boxbody,CANNON.newVec3(-size,0,size+space),last,CANNON.newVec3(-size,0,-size-space));
                        PointToPointConstraint c2 = CANNON.newPointToPointConstraint(boxbody,CANNON.newVec3(size,0,size+space),last,CANNON.newVec3(size,0,-size-space));
                        world.addConstraint(c1);
                        world.addConstraint(c2);
                    } else {
                        // First body is now static. The rest should be dynamic.
                        mass=0.3;
                    }

                    // To keep track of which body was added last
                    last = boxbody;
                }
            }
        });

        // Particle cloth on sphere
        demo.addScene("cloth on sphere", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                ((GSSolver) world.getSolver().cast()).setIterations(10);

                // To construct the cloth we need Nrows*Ncols particles.
                double dist = 0.2;
                double mass = 0.5;
                int Nrows = 15, Ncols = 15;
                Map<String, Body> bodies = new HashMap<String, Body>(); // bodies["i j"] => particle
                for(int i=0; i<Ncols; i++){
                    for(int j=0; j<Nrows; j++){
                        // Create a new body
                        Body body = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                        body.addShape(CANNON.newParticle());
                        body.getPosition().set((i-Ncols*0.5)*dist,(j-Nrows*0.5)*dist,5);
                        bodies.put(i+" "+j, body);
                        world.addBody(body);
                        demo.addVisual(body);
                    }
                }
                for(int i=0; i<Ncols; i++){
                    for(int j=0; j<Nrows; j++){
                        // Connect particle at position (i,j) to (i+1,j) and to (i,j+1).
                        if(i<Ncols-1) connect(world,bodies,dist,i,j,i+1,j);
                        if(j<Nrows-1) connect(world,bodies,dist,i,j,i,j+1);
                    }
                }

                // Add the static sphere we throw the cloth on top of
                Sphere sphere = CANNON.newSphere(1.5);
                Body body = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                body.addShape(sphere);
                body.getPosition().set(0,0,3.5);
                world.addBody(body);
                demo.addVisual(body);
            }

            // To connect two particles, we use a distance constraint. This forces the particles to be at a constant distance from each other.
            private void connect(World world, Map<String, Body> bodies, double dist, int i1,int j1,int i2,int j2){
                world.addConstraint(CANNON.newDistanceConstraint(bodies.get(i1+" "+j1),bodies.get(i2+" "+j2),dist));
            }
        });

        // A pendulum made out of two spheres using a PointToPointConstraint
        demo.addScene("Sphere pendulum", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                double size = 1;
                Shape sphereShape = CANNON.newSphere(size);
                double mass = 1;
    
                Body spherebody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                spherebody.addShape(sphereShape);
                spherebody.getPosition().set(0,0,size*3);
                spherebody.getVelocity().set(5,0,0);
                spherebody.setLinearDamping(0);
                spherebody.setAngularDamping(0);
                world.addBody(spherebody);
                demo.addVisual(spherebody);
    
                Body spherebody2 = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                spherebody2.addShape(sphereShape);
                spherebody2.getPosition().set(0,0,size*7);
                world.addBody(spherebody2);
                demo.addVisual(spherebody2);
    
                // Connect this body to the last one
                PointToPointConstraint c = CANNON.newPointToPointConstraint(spherebody,CANNON.newVec3(0,0,size*2),spherebody2,CANNON.newVec3(0,0,-size*2));
                world.addConstraint(c);
            }
        });

        // Sphere chain
        demo.addScene("Sphere chain", new AddSceneCallback() {
            @Override
            public void execute() {
                double size = 0.5;
                double dist = size*2+0.12;
                World world = setupWorld(demo);
                //world.solver.setSpookParams(1e20,3);
                Shape sphereShape = CANNON.newSphere(size);
                double mass = 1;
                Body lastBody = null;
                int N = 20;
                ((GSSolver) world.getSolver().cast()).setIterations(N); // To be able to propagate force throw the chain of N spheres, we need at least N solver iterations.
                for(int i=0; i<N; i++){
                    // Create a new body
                    Body spherebody = CANNON.newBody(CANNON.newBodyOptions().withMass(i==0 ? 0 : mass));
                    spherebody.addShape(sphereShape);
                    spherebody.getPosition().set(0,0,(N-i)*dist);
                    spherebody.getVelocity().setX(i);
                    world.addBody(spherebody);
                    demo.addVisual(spherebody);

                    // Connect this body to the last one added
                    if(lastBody!=null){
                        world.addConstraint(CANNON.newDistanceConstraint(spherebody,lastBody,dist));
                    }

                    // Keep track of the lastly added body
                    lastBody = spherebody;
                }
            }
        });



        // Particle cloth. Same as the previous cloth but here we make the first row of particles static, nailing the cloth it in space
        demo.addScene("Particle cloth", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                //world.solver.setSpookParams(1e20,3);
                ((GSSolver) world.getSolver().cast()).setIterations(18);
                double dist = 0.2;
                double mass = 0.5;
                int Nrows = 15, Ncols = 15;
                Map<String, Body> bodies = new HashMap<String, Body>(); // bodies["i j"] => particle
                for(int i=0; i<Ncols; i++){
                    for(int j=0; j<Nrows; j++){
                        // Create a new body
                        Body body = CANNON.newBody(CANNON.newBodyOptions().withMass(j==Nrows-1 ? 0 : mass));
                        body.addShape(CANNON.newParticle());
                        body.getPosition().set(i*dist,0,j*dist+5);
                        body.getVelocity().set(0, 3*(Math.sin(i*0.1)+Math.sin(j*0.1)),0);
                        bodies.put(i+" "+j, body);
                        world.addBody(body);
                        demo.addVisual(body);
                    }
                }
                for(int i=0; i<Ncols; i++){
                    for(int j=0; j<Nrows; j++){
                        if(i<Ncols-1) connect(world,bodies,dist,i,j,i+1,j);
                        if(j<Nrows-1) connect(world,bodies,dist,i,j,i,j+1);
                    }
                }
            }
            
            private void connect(World world, Map<String, Body> bodies, double dist, int i1,int j1,int i2,int j2){
                world.addConstraint(CANNON.newDistanceConstraint(bodies.get(i1+" "+j1),bodies.get(i2+" "+j2),dist));
            }
        });

        // Particle 3d object
        // Distance constraints can be used to construct even cooler things, like this 3d block.
        demo.addScene("3D cloth structure", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                ((GSSolver) world.getSolver().cast()).setIterations(10);
                double dist = 1;
                double mass = 1;
                int Nx = 6, Ny = 3, Nz = 3;
                Map<String, Body> bodies = new HashMap<String, Body>(); // bodies["i j k"] => particle
                for(int i=0; i<Nx; i++){
                    for(int j=0; j<Ny; j++){
                        for(int k=0; k<Nz; k++){
                            // Create a new body
                            Body body = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                            body.addShape(CANNON.newParticle());
                            body.getPosition().set(i*dist,j*dist, k*dist + Nz*dist*0.3+1);
                            body.getVelocity().set(0, 30*(Math.sin(i*0.1)+Math.sin(j*0.1)),0);
                            bodies.put(i+" "+j+" "+k, body);
                            world.addBody(body);
                            demo.addVisual(body);
                        }
                    }
                }
                for(int i=0; i<Nx; i++){
                    for(int j=0; j<Ny; j++){
                        for(int k=0; k<Nz; k++){
                            // normal directions
                            if(i<Nx-1) connect(world, bodies, i,j,k,  i+1,j,k, dist);
                            if(j<Ny-1) connect(world, bodies, i,j,k,  i,j+1,k, dist);
                            if(k<Nz-1) connect(world, bodies, i,j,k,  i,j,k+1, dist);
    
                            // Diagonals
                            if(i<Nx-1 && j<Ny-1 && k<Nz-1){
                                // 3d diagonals
                                connect(world, bodies, i,j,k,  i+1,j+1,k+1, Math.sqrt(3)*dist);
                                connect(world, bodies, i+1,j,k,  i,j+1,k+1, Math.sqrt(3)*dist);
                                connect(world, bodies, i,j+1,k,  i+1,j,k+1, Math.sqrt(3)*dist);
                                connect(world, bodies, i,j,k+1,  i+1,j+1,k, Math.sqrt(3)*dist);
    
                            }
    
                            // 2d diagonals
                            if(i<Nx-1 && j<Ny-1){
                                connect(world, bodies, i+1,j,k,   i,j+1,k, Math.sqrt(2)*dist);
                                connect(world, bodies, i,j+1,k,   i+1,j,k, Math.sqrt(2)*dist);
                            }
                            if(i<Nx-1 && k<Nz-1){
                                connect(world, bodies, i+1,j,k,   i,j,k+1, Math.sqrt(2)*dist);
                                connect(world, bodies, i,j,k+1,   i+1,j,k, Math.sqrt(2)*dist);
                            }
                            if(j<Ny-1 && k<Nz-1){
                                connect(world, bodies, i,j+1,k,   i,j,k+1, Math.sqrt(2)*dist);
                                connect(world, bodies, i,j,k+1,   i,j+1,k, Math.sqrt(2)*dist);
                            }
                        }
                    }
                }
            }
            
            private void connect(World world, Map<String, Body> bodies, int i1, int j1, int k1, int i2, int j2, int k2, double len){
                world.addConstraint(CANNON.newDistanceConstraint(bodies.get(i1+" "+j1+" "+k1),bodies.get(i2+" "+j2+" "+k2),len));
            }
        });

        demo.start();
    }

    private World setupWorld(Demo demo){
        // Create world
        World world = demo.getWorld();
        world.getGravity().set(0,0,-40);
        world.setBroadphase(CANNON.newNaiveBroadphase());
        ((GSSolver) world.getSolver().cast()).setIterations(10);

        // ground plane
        Shape groundShape = CANNON.newPlane();
        Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
        groundBody.addShape(groundShape);
        groundBody.getPosition().set(0,0,1);
        world.addBody(groundBody);
        demo.addVisual(groundBody);

        world.setQuatNormalizeFast(false);
        world.setQuatNormalizeSkip(0);

        return world;
    }
}
