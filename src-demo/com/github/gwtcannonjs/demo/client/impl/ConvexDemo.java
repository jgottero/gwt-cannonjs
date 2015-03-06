// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Box;
import com.github.gwtcannonjs.client.shapes.ConvexPolyhedron;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.solver.GSSolver;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;

public class ConvexDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Convex";
    }
    
    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.convexDemo().getText();
    }
    
    @Override
    public void run() {
        /**
         * Experiment for testing ConvexPolyhedrons.
         */
        final Demo demo = CANNON.newDemo();

        // Various shapes
        demo.addScene("various", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                // ConvexPolyhedron box shape
                double size = 0.5;
                ConvexPolyhedron convexShape = createBoxPolyhedron(size);
                double mass = 10;
                Body boxbody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                boxbody.addShape(convexShape);
                boxbody.getPosition().set(1,0,size+1);
                world.addBody(boxbody);
                demo.addVisual(boxbody);

                // ConvexPolyhedron tetra shape
                ConvexPolyhedron tetraShape = createTetra();
                Body tetraBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                tetraBody.addShape(tetraShape);
                tetraBody.getPosition().set(5,-3,size+1);
                world.addBody(tetraBody);
                demo.addVisual(tetraBody);

                // ConvexPolyhedron cylinder shape
                double num = 20;
                double L = 2, R = 0.5;
                Shape cylinderShape = CANNON.newCylinder(R,R,L,num);
                Body cylinderBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                cylinderBody.addShape(cylinderShape);
                cylinderBody.getPosition().set(0,0,size*4+1);
                cylinderBody.getQuaternion().setFromAxisAngle(CANNON.newVec3(0,1,0),Math.PI/3);
                world.addBody(cylinderBody);
                demo.addVisual(cylinderBody);
            }
        });


        // Box on box tilting over
        demo.addScene("convex on convex", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                // ConvexPolyhedron box shape
                double size = 2;
                ConvexPolyhedron convexShape = createBoxPolyhedron(size);
                double mass = 10;
                Body boxbody1 = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                boxbody1.addShape(convexShape);
                Body boxbody2 = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                boxbody2.addShape(convexShape);
                boxbody1.getPosition().set(0,0,size+1);
                boxbody2.getPosition().set(1.5,0,4*size+1);
                world.addBody(boxbody1);
                world.addBody(boxbody2);
                demo.addVisual(boxbody1);
                demo.addVisual(boxbody2);
            }
        });

        // Pile of boxes
        demo.addScene("convex wall", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                // ConvexPolyhedron box shape
                double size = 1;
                ConvexPolyhedron convexShape = createBoxPolyhedron(size);
                double mass = 10;
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        Body boxbody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                        boxbody.addShape(convexShape);
                        boxbody.getPosition().set(2*size*i+0.01,0,2*size*j + size*1.2);
                        world.addBody(boxbody);
                        demo.addVisual(boxbody);
                    }
                }
            }
        });

        demo.start();
    }

    private ConvexPolyhedron createTetra(){
        JsArray<Vec3> verts = JsArray.createArray().cast();
        verts.push(CANNON.newVec3(0,0,0));
        verts.push(CANNON.newVec3(2,0,0));
        verts.push(CANNON.newVec3(0,2,0));
        verts.push(CANNON.newVec3(0,0,2));
        double offset = -0.35;
        for(int i=0; i<verts.length(); i++){
            Vec3 v = verts.get(i);
            v.setX(v.getX() + offset);
            v.setY(v.getY() + offset);
            v.setZ(v.getZ() + offset);
        }
        JsArray<JsArrayInteger> faces = JsArray.createArray().cast();
        JsArrayInteger face = JsArray.createArray().cast();
        face.push(0); face.push(3); face.push(2); faces.push(face); // -x
        face = JsArray.createArray().cast();
        face.push(0); face.push(1); face.push(3); faces.push(face); // -y
        face = JsArray.createArray().cast();
        face.push(0); face.push(2); face.push(1); faces.push(face); // -z
        face = JsArray.createArray().cast();
        face.push(1); face.push(2); face.push(3); faces.push(face); // +xyz

        return CANNON.newConvexPolyhedron(verts, faces);
    }

    private ConvexPolyhedron createBoxPolyhedron(double size){
        Box box = CANNON.newBox(CANNON.newVec3(size,size,size));
        return box.getConvexPolyhedronRepresentation();
    }

    private World setupWorld(Demo demo){
        World world = demo.getWorld();
        world.getGravity().set(0,0,-30);
        world.setBroadphase(CANNON.newNaiveBroadphase());
        ((GSSolver) world.getSolver().cast()).setIterations(10);

        world.getDefaultContactMaterial().setContactEquationStiffness(5e6);
        world.getDefaultContactMaterial().setContactEquationRelaxation(3);

        // ground plane
        Vec3 n = CANNON.newVec3(0,0,1);
        n.normalize();
        Shape groundShape = CANNON.newPlane();
        Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
        groundBody.addShape(groundShape);
        groundBody.getPosition().set(-10,0,0);
        world.addBody(groundBody);
        demo.addVisual(groundBody);

        return world;
    }
}
