/* The MIT License (MIT)
 * 
 * Copyright (c) 2015 Jérémie Gottero
 */

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

public class StacksDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Stacks";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.stacksDemo().getText();
    }

    @Override
    public void run() {
        /**
         * For debugging different kinds of stacks
         */
        final Demo demo = CANNON.newDemo();
        final double size = 2, mass=5;

        // Spheres
        demo.addScene("sphere/sphere", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                // Sphere 1
                Shape sphereShape = CANNON.newSphere(size);
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(sphereShape);
                b1.getPosition().set(0,0,3*size);
                world.addBody(b1);
                demo.addVisual(b1);

                // Sphere 2
                Body b2 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b2.addShape(sphereShape);
                b2.getPosition().set(0,0,1*size);
                world.addBody(b2);
                demo.addVisual(b2);
            }
        });

        // Sphere/plane
        demo.addScene("sphere/plane", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                // Sphere 1
                Shape sphereShape = CANNON.newSphere(size);
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(sphereShape);
                b1.getPosition().set(0, 0, 3*size);
                world.addBody(b1);
                demo.addVisual(b1);
            }
        });

        // Sphere / box side
        demo.addScene("sphere/box", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                Shape boxShape = CANNON.newBox(CANNON.newVec3(size,size,size));
                Shape sphereShape = CANNON.newSphere(size);

                // Box
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(boxShape);
                b1.getPosition().set(0,0,1*size);
                world.addBody(b1);
                demo.addVisual(b1);

                // Sphere
                Body b2 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b2.addShape(sphereShape);
                b2.getPosition().set(0,0,3*size);
                world.addBody(b2);
                demo.addVisual(b2);
            }
        });

        demo.addScene("sphere/compound", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                // Sphere
                Shape sphereShape = CANNON.newSphere(size*0.5);
                Body b = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b.addShape(sphereShape);
                b.getPosition().set(-size, 0, 6*size);
                world.addBody(b);
                demo.addVisual(b);

                Body compoundBody = createCompound(mass, size);
                compoundBody.getPosition().set(0,0,size*3);
                world.addBody(compoundBody);
                demo.addVisual(compoundBody);
            }
        });

        demo.addScene("sphere/convex", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                // Sphere
                Shape sphereShape = CANNON.newSphere(size*0.5);
                Body b = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b.addShape(sphereShape);
                b.getPosition().set(0,0,6*size);
                world.addBody(b);
                demo.addVisual(b);

                Shape shape = createTetra();//createBoxPolyhedron(size);
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(shape);
                b1.getPosition().set(0,0,1*size);
                world.addBody(b1);
                demo.addVisual(b1);
            }
        });

        demo.addScene("sphere/particle", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                // Sphere
                Shape sphereShape = CANNON.newSphere(size*0.5);
                Body b = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b.addShape(sphereShape);
                b.getPosition().set(0,0,size);
                world.addBody(b);
                demo.addVisual(b);

                // Particle
                Body p = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
                p.addShape(CANNON.newParticle());
                p.getPosition().set(0.02,0,3*size);

                world.addBody(p);
                demo.addVisual(p);
            }
        });

        demo.addScene("plane/box", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                Shape boxShape = CANNON.newBox(CANNON.newVec3(size,size,size));
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(boxShape);
                b1.getPosition().set(0,0,1*size);
                world.addBody(b1);
                demo.addVisual(b1);
            }
        });

        demo.addScene("plane/compound", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                Body b1 = createCompound(5, size);
                b1.getPosition().set(0,0,4*size);
                world.addBody(b1);
                demo.addVisual(b1);
            }
        });

        demo.addScene("plane/convex", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                Shape shape = createTetra();
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(shape);
                b1.getPosition().set(0,0,1*size);
                world.addBody(b1);
                demo.addVisual(b1);
            }
        });

        demo.addScene("plane/particle", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);
                // Particle
                Body p = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
                p.addShape(CANNON.newParticle());
                p.getPosition().set(0.02,0,3*size);
                world.addBody(p);
                demo.addVisual(p);
            }
        });

        // Boxes
        demo.addScene("box/box", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                // Box 1
                Shape boxShape = CANNON.newBox(CANNON.newVec3(size*0.5,size*0.5,size*0.5));
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(boxShape);
                b1.getPosition().set(0,0,1*size);
                world.addBody(b1);
                demo.addVisual(b1);

                // Box 2
                Body b2 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b2.addShape(boxShape);
                b2.getPosition().set(size*0.5,0,3*size);
                world.addBody(b2);
                demo.addVisual(b2);
            }
        });

        demo.addScene("box/compound", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                Body b2 = createCompound(5, size);
                b2.getPosition().set(size*0.5,0,2*size);
                world.addBody(b2);
                demo.addVisual(b2);

                Shape boxShape = CANNON.newBox(CANNON.newVec3(size*0.5,size*0.5,size*0.5));
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(boxShape);
                b1.getPosition().set(0,0,7*size);
                world.addBody(b1);
                demo.addVisual(b1);
            }
        });

        demo.addScene("box/convex", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                Shape shape = createTetra();
                Body b2 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b2.addShape(shape);
                b2.getPosition().set(0,0,5*size);
                world.addBody(b2);
                demo.addVisual(b2);

                Shape boxShape = CANNON.newBox(CANNON.newVec3(size*0.5,size*0.5,size*0.5));
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(boxShape);
                b1.getPosition().set(0,0,2*size);
                world.addBody(b1);
                demo.addVisual(b1);
            }
        });

        demo.addScene("box/particle", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                Shape boxShape = CANNON.newBox(CANNON.newVec3(size*0.5,size*0.5,size*0.5));
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(boxShape);
                b1.getPosition().set(0,0,1*size);
                world.addBody(b1);
                demo.addVisual(b1);

                // Particle
                Body p = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
                p.addShape(CANNON.newParticle());
                p.getPosition().set(0,0,3*size);
                world.addBody(p);
                demo.addVisual(p);
            }
        });

        demo.addScene("compound/compound", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                Body b2 = createCompound(5, size);
                b2.getPosition().set(size*0.5,0,6*size);
                world.addBody(b2);
                demo.addVisual(b2);

                b2 = createCompound(5, size);
                b2.getPosition().set(size*0.5,0,2*size);
                world.addBody(b2);
                demo.addVisual(b2);
            }
        });

        demo.addScene("compound/convex", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                Shape tetraShape = createTetra();

                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(tetraShape);
                b1.getPosition().set(0,0,3*size);
                world.addBody(b1);
                demo.addVisual(b1);

                // Box 2
                Shape boxShape = CANNON.newBox(CANNON.newVec3(size*0.5,size*0.5,size*0.5));
                Body b2 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b2.addShape(boxShape);
                b2.getPosition().set(0,0,1*size);
                world.addBody(b2);
                demo.addVisual(b2);
            }
        });

        demo.addScene("compound/particle", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                Body t = createCompound(5, size);
                t.getPosition().set(0,0,4*size);

                // Particle
                Body p = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
                p.addShape(CANNON.newParticle());
                p.getPosition().set(0,0,7*size);
                world.addBody(t);
                demo.addVisual(t);
                world.addBody(p);
                demo.addVisual(p);
            }
        });

        // ConvexPolyhedron and box
        demo.addScene("convex/convex", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                Shape tetraShape = createTetra();
                Body b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(tetraShape);
                b1.getPosition().set(0.1,0.1,5*size);
                world.addBody(b1);
                demo.addVisual(b1);

                tetraShape = createTetra();
                b1 = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                b1.addShape(tetraShape);
                b1.getPosition().set(0,0,3*size);
                world.addBody(b1);
                demo.addVisual(b1);
            }
        });

        // ConvexPolyhedron and particle
        demo.addScene("convex/particle", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = setupWorld(demo);

                Shape tetraShape = createBoxPolyhedron(size);
                Body t = CANNON.newBody(CANNON.newBodyOptions().withMass(5));
                t.addShape(tetraShape);
                t.getPosition().set(0,0,1*size);
                t.getQuaternion().setFromAxisAngle(CANNON.newVec3(1,0,0),Math.PI/2);

                // Particle
                Body p = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
                p.addShape(CANNON.newParticle());
                p.getPosition().set(0,0,3*size);

                world.addBody(t);
                demo.addVisual(t);
                world.addBody(p);
                demo.addVisual(p);
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

    private Body createCompound(double mass, double size){
        Body compoundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(mass));
        double s = size;
        Shape shape = CANNON.newBox(CANNON.newVec3(0.5*s,0.5*s,0.5*s));
        compoundBody.addShape(shape, CANNON.newVec3( 0, 0, s));
        compoundBody.addShape(shape, CANNON.newVec3( 0, 0, 0));
        compoundBody.addShape(shape, CANNON.newVec3( 0, 0,-s));
        compoundBody.addShape(shape, CANNON.newVec3(-s, 0,-s));
        return compoundBody;
    }

    private World setupWorld(Demo demo){
        World world = demo.getWorld();
        world.getGravity().set(0,0,-10);
        world.setBroadphase(CANNON.newNaiveBroadphase());
        ((GSSolver) world.getSolver().cast()).setIterations(20);

        world.getDefaultContactMaterial().setContactEquationStiffness(1e7);
        world.getDefaultContactMaterial().setContactEquationRelaxation(5);

        // ground plane
        Shape groundShape = CANNON.newPlane();
        Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
        groundBody.addShape(groundShape);
        groundBody.getPosition().set(0,0,-1);
        //groundBody.quaternion.setFromAxisAngle(CANNON.newVec3(0,1,0),0.2);
        world.addBody(groundBody);
        demo.addVisual(groundBody);
        return world;
    }
}
