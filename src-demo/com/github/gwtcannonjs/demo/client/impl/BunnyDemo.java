// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.math.Quaternion;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.solver.GSSolver;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class BunnyDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Bunny";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.bunnyDemo().getText();
    }

    @Override
    public void run() {
        ScriptInjector.fromString(BunnyResource.INSTANCE.source().getText()).inject();
        
        final Demo demo = CANNON.newDemo();

        demo.addScene("Bunny", new AddSceneCallback() {
            @Override
            public void execute() {
                World world = demo.getWorld();

                world.getGravity().set(0,0,-20);
                world.setBroadphase(CANNON.newNaiveBroadphase());
                ((GSSolver) world.getSolver().cast()).setIterations(20);
                world.getDefaultContactMaterial().setContactEquationStiffness(1e10);
                world.getDefaultContactMaterial().setContactEquationRelaxation(10);

                JsArray<CustomPolyhedron> bunny = getBunny();
                
                Body bunnyBody = CANNON.newBody(CANNON.newBodyOptions().withMass(1));
                for(int i=0; i<bunny.length(); i++){

                    JsArrayNumber rawVerts = bunny.get(i).getVertices();
                    JsArrayNumber rawFaces = bunny.get(i).getFaces();
                    JsArrayNumber rawOffset = bunny.get(i).getOffset();

                    JsArray<Vec3> verts = JsArray.createArray().cast();
                    JsArray<JsArrayInteger> faces = JsArray.createArray().cast();
                    Vec3 offset;

                    // Get vertices
                    for(int j=0; j<rawVerts.length(); j+=3){
                        verts.push(CANNON.newVec3( rawVerts.get(j)  ,
                                rawVerts.get(j+1),
                                rawVerts.get(j+2)));
                    }

                    // Get faces
                    for(int j=0; j<rawFaces.length(); j+=3){
                        JsArrayInteger face = JsArray.createArray().cast();
                        face.push((int) rawFaces.get(j));
                        face.push((int) rawFaces.get(j+1));
                        face.push((int) rawFaces.get(j+2));
                        faces.push(face);
                    }

                    // Get offset
                    offset = CANNON.newVec3(rawOffset.get(0),rawOffset.get(1),rawOffset.get(2));

                    // Construct polyhedron
                    Shape bunnyPart = CANNON.newConvexPolyhedron(verts,faces);

                    // Add to compound
                    bunnyBody.addShape(bunnyPart,offset);
                }

                // Create body
                bunnyBody.getQuaternion().setFromAxisAngle(CANNON.newVec3(1,0,0),-Math.PI/2);
                Quaternion z180 = CANNON.newQuaternion();
                z180.setFromAxisAngle(CANNON.newVec3(0,0,1),Math.PI);
                bunnyBody.setQuaternion(z180.mult(bunnyBody.getQuaternion(), null));
                world.addBody(bunnyBody);
                demo.addVisual(bunnyBody);

                // ground plane
                Shape groundShape = CANNON.newPlane();
                Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0));
                groundBody.addShape(groundShape);
                groundBody.getPosition().set(0,0,-5);
                world.addBody(groundBody);
                demo.addVisual(groundBody);
            }
        });

        demo.start();
    }
    
    private native JsArray<CustomPolyhedron> getBunny() /*-{
        return bunny;
    }-*/;
    
    public static class CustomPolyhedron extends JavaScriptObject {
        protected CustomPolyhedron() {}
        
        public final native JsArrayNumber getVertices() /*-{
            return this.verts;
        }-*/;
        
        public final native JsArrayNumber getFaces() /*-{
            return this.faces;
        }-*/;
        
        public final native JsArrayNumber getOffset() /*-{
            return this.offset;
        }-*/;
    }
    
    public static interface BunnyResource extends ClientBundle {
        public static final BunnyResource INSTANCE = GWT.create(BunnyResource.class);
        
        @Source("bunny.js")
        TextResource source();
    }
}
