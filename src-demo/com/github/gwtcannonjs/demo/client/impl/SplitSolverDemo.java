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

public class SplitSolverDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Split solver";
    }
    
    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.splitSolverDemo().getText();
    }
    
    @Override
    public void run() {
        /**
         * This demonstrates why it can be good to use the SplitSolver.
         * If you have put a nonzero tolerance on a solver, it will in stop iterating when
         * the total error is small, in other words: when the system is solved "good enough".
         * When simulating larger systems with more equations, the error will add up,
         * and the solver will need more iterations/work to reach the "good enough" level.
         *
         * The SplitSolver splits the system into independent parts, and runs a subsolver
         * on each part. The total error in a subsystem will many times be smaller than in
         * the large system, so we can many times cut down on the total number of iterations we do.
         *
         * Another interesting fact is that we *could* run the subsystems in separate threads and
         * speed up the computing even more. However, CANNON runs in one thread for now.
         *
         * The first scene uses the split solver and the second one does not. Turn on the
         * profiling plot and enjoy!
         */

        final Demo demo = CANNON.newDemo();
        final double size = 0.5;

        final Shape shape = CANNON.newBox(CANNON.newVec3(size*0.5,size*0.5,size*0.5));
        demo.addScene("with split", new AddSceneCallback() {
            @Override
            public void execute() {
                createScene(demo,shape,true,size);
            }
        });
        demo.addScene("without split", new AddSceneCallback() {
            @Override
            public void execute() {
                createScene(demo,shape,false,size);
            }
        });

        demo.start();
    }
    
    private void  createScene(Demo demo, Shape shape, boolean split, double size){

        // Create world
        World world = demo.getWorld();
        world.getGravity().set(0,0,-10);
        world.setBroadphase(CANNON.newNaiveBroadphase());

        GSSolver solver = CANNON.newGSSolver();
        solver.setIterations(50);
        world.getDefaultContactMaterial().setContactEquationStiffness(1e7);
        world.getDefaultContactMaterial().setContactEquationRelaxation(5);
        solver.setTolerance(0.0001);
        if(split)
            world.setSolver(CANNON.newSplitSolver(solver));
        else
            world.setSolver(solver);

        // ground plane
        Shape groundShape = CANNON.newPlane();
        Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
        groundBody.addShape(groundShape);
        world.addBody(groundBody);
        demo.addVisual(groundBody);

        // Shape on plane
        int N = 5;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Body shapeBody = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
                shapeBody.addShape(shape);
                shapeBody.getPosition().set( (i-N*0.5)*size*2*1.1,
                        (j-N*0.5)*size*2*1.1,
                        size*1.05);
                world.addBody(shapeBody);
                demo.addVisual(shapeBody);
            }
        }


        Body shapeBody = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
        shapeBody.addShape(shape);
        shapeBody.getPosition().set( size,size,
                size*5);
        world.addBody(shapeBody);
        demo.addVisual(shapeBody);
    }
}
