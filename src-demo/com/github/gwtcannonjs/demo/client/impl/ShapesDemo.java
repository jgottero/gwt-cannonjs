// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.math.Quaternion;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.ConvexPolyhedron;
import com.github.gwtcannonjs.client.shapes.Cylinder;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.solver.GSSolver;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;

public class ShapesDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Shapes";
    }
    
    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.shapesDemo().getText();
    }
    
    @Override
    public void run() {
        final Demo demo = CANNON.newDemo();
        final double mass = 1, size = 1;

        demo.addScene("all shapes", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
    
                // Sphere shape
                Shape sphereShape = CANNON.newSphere(size);
                Body sphereBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                sphereBody.addShape(sphereShape);
                sphereBody.getPosition().set(size*2,size*2,size+1);
                world.addBody(sphereBody);
                demo.addVisual(sphereBody);
    
    
                // Cylinder shape
                Shape cylinderShape = CANNON.newCylinder(size,size,2*size,10);
                Body cylinderBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                cylinderBody.addShape(cylinderShape);
                cylinderBody.getPosition().set(-size*2,size*2,size+1);
                world.addBody(cylinderBody);
                demo.addVisual(cylinderBody);
    
                // Cylinder shape 2
                Cylinder cylinderShape2 = CANNON.newCylinder(size,size,2*size,10);
                Quaternion q = CANNON.newQuaternion();
                q.setFromAxisAngle(CANNON.newVec3(1,0,0),Math.PI / 2);
                cylinderShape2.transformAllPoints(CANNON.newVec3(),q);
                Body cylinderBody2 = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                cylinderBody2.addShape(cylinderShape2);
                cylinderBody2.getPosition().set(-size*2,size*2,4*size+1);
                world.addBody(cylinderBody2);
                demo.addVisual(cylinderBody2);
    
    
                // Box shape
                Shape boxShape = CANNON.newBox(CANNON.newVec3(size,size,size));
                Body boxBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                boxBody.addShape(boxShape);
                boxBody.getPosition().set(-size*2,-size*2,size+1);
                world.addBody(boxBody);
                demo.addVisual(boxBody);
    
    
    
    
                // Particle - not a shape but still here to show how to use it.
                Body particle = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                particle.addShape(CANNON.newParticle());
                particle.getPosition().set(-size*2,size*4,size+1);
                world.addBody(particle);
                demo.addVisual(particle);
    
    
    
    
                // Compound
                Body compoundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                double s = size;
                Shape shape = CANNON.newBox(CANNON.newVec3(0.5*s,0.5*s,0.5*s));
                compoundBody.addShape(shape, CANNON.newVec3( 0, 0, s));
                compoundBody.addShape(shape, CANNON.newVec3( 0, 0, 0));
                compoundBody.addShape(shape, CANNON.newVec3( 0, 0,-s));
                compoundBody.addShape(shape, CANNON.newVec3(-s, 0,-s));
                compoundBody.getPosition().set(-size*4,size*4,size+1);
                world.addBody(compoundBody);
                demo.addVisual(compoundBody);
    
    
                // ConvexPolyhedron tetra shape
                ConvexPolyhedron polyhedronShape = createTetra();
                
                Body polyhedronBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
                polyhedronBody.addShape(polyhedronShape);
                polyhedronBody.getPosition().set(size*2,-size*2,size+1);
                world.addBody(polyhedronBody);
                demo.addVisual(polyhedronBody);
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

    private World setupWorld(Demo demo){
        World world = demo.getWorld();
        world.getGravity().set(0,0,-30);
        world.setBroadphase(CANNON.newNaiveBroadphase());
        ((GSSolver) world.getSolver().cast()).setIterations(17);

        world.getDefaultContactMaterial().setContactEquationStiffness(1e6);
        world.getDefaultContactMaterial().setContactEquationRelaxation(3);

        // ground plane
        Shape groundShape = CANNON.newPlane();
        Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
        groundBody.addShape(groundShape);
        groundBody.getPosition().set(-10,0,0);
        world.addBody(groundBody);
        demo.addVisual(groundBody);
        return world;
    }
}
