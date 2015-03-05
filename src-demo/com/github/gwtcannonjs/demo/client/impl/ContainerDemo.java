package com.github.gwtcannonjs.demo.client.impl;

import com.github.gwtcannonjs.client.CANNON;
import com.github.gwtcannonjs.client.demo.AddSceneCallback;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.material.ContactMaterial;
import com.github.gwtcannonjs.client.material.Material;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Plane;
import com.github.gwtcannonjs.client.shapes.Sphere;
import com.github.gwtcannonjs.client.solver.GSSolver;
import com.github.gwtcannonjs.client.world.World;
import com.github.gwtcannonjs.demo.client.DemoInstance;

public class ContainerDemo implements DemoInstance {
    @Override
    public String getName() {
        return "Container";
    }

    @Override
    public String getSourceCode() {
        return SourceCodeBundle.INSTANCE.containerDemo().getText();
    }
    
    @Override
	public void run() {
		final Demo demo = CANNON.newDemo();
		final int nx=4, ny=4;
		
		// Test scalability - add scenes for different number of spheres
		demo.addScene((nx*ny*4)+ " spheres", new AddSceneCallback() { public void execute() { createContainer(demo,nx,ny,4); }});
		demo.addScene((nx*ny*8)+ " spheres", new AddSceneCallback() { public void execute() { createContainer(demo,nx,ny,8); }});
		demo.addScene((nx*ny*15)+" spheres", new AddSceneCallback() { public void execute() { createContainer(demo,nx,ny,15); }});
		demo.addScene((nx*ny*20)+" spheres", new AddSceneCallback() { public void execute() { createContainer(demo,nx,ny,20); }});
		demo.addScene((nx*ny*25)+" spheres", new AddSceneCallback() { public void execute() { createContainer(demo,nx,ny,25); }});
		demo.addScene((nx*ny*30)+" spheres", new AddSceneCallback() { public void execute() { createContainer(demo,nx,ny,30); }});
		
		demo.start();
	}
	
	public static void createContainer(Demo demo, int nx, int ny,int nz){
		// Create world
		World world = demo.getWorld();
		world.setBroadphase(CANNON.newSAPBroadphase(world)); // Buggy?

		// Tweak contact properties.
		world.getDefaultContactMaterial().setContactEquationStiffness(1e11); // Contact stiffness - use to make softer/harder contacts
		world.getDefaultContactMaterial().setContactEquationRelaxation(2); // Stabilization time in number of timesteps

		// Max solver iterations: Use more for better force propagation, but keep in mind that it's not very computationally cheap!
		((GSSolver) world.getSolver().cast()).setIterations(10);

		world.getGravity().set(0,0,-30);

		// Since we have many bodies and they don't move very much, we can use the less accurate quaternion normalization
		world.setQuatNormalizeFast(true);
		world.setQuatNormalizeSkip(8); // ...and we do not have to normalize every step.

		// Materials
		Material stone = CANNON.newMaterial("stone");
		ContactMaterial stone_stone = CANNON.newContactMaterial(stone, stone, CANNON.newContactMaterialOptions().
			withFriction(0.3).
			withRestitution(0.2)
		);
		world.addContactMaterial(stone_stone);

		// ground plane
		Plane groundShape = CANNON.newPlane();
		Body groundBody = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(stone));
		groundBody.addShape(groundShape);
		world.addBody(groundBody);
		demo.addVisual(groundBody);

		// plane -x
		Plane planeShapeXmin = CANNON.newPlane();
		Body planeXmin = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(stone));
		planeXmin.addShape(planeShapeXmin);
		planeXmin.getQuaternion().setFromAxisAngle(CANNON.newVec3(0,1,0),Math.PI/2);
		planeXmin.getPosition().set(-5,0,0);
		world.addBody(planeXmin);

		// Plane +x
		Plane planeShapeXmax = CANNON.newPlane();
		Body planeXmax = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(stone));
		planeXmax.addShape(planeShapeXmax);
		planeXmax.getQuaternion().setFromAxisAngle(CANNON.newVec3(0,1,0),-Math.PI/2);
		planeXmax.getPosition().set(5,0,0);
		world.addBody(planeXmax);

		// Plane -y
		Plane planeShapeYmin = CANNON.newPlane();
		Body planeYmin = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(stone));
		planeYmin.addShape(planeShapeYmin);
		planeYmin.getQuaternion().setFromAxisAngle(CANNON.newVec3(1,0,0),-Math.PI/2);
		planeYmin.getPosition().set(0,-5,0);
		world.addBody(planeYmin);

		// Plane +y
		Plane planeShapeYmax = CANNON.newPlane();
		Body planeYmax = CANNON.newBody(CANNON.newBodyOptions().withMass(0).withMaterial(stone));
		planeYmax.addShape(planeShapeYmax);
		planeYmax.getQuaternion().setFromAxisAngle(CANNON.newVec3(1,0,0),Math.PI/2);
		planeYmax.getPosition().set(0,5,0);
		world.addBody(planeYmax);

		// Create spheres
		double rand = 0.1;
		int h = 0;
		Sphere sphereShape = CANNON.newSphere(1); // Sharing shape saves memory
		world.setAllowSleep(true);
		for(int i=0; i<nx; i++){
			for(int j=0; j<ny; j++){
				for(int k=0; k<nz; k++){
					Body sphereBody = CANNON.newBody(CANNON.newBodyOptions().withMass(5).withMaterial(stone));
					sphereBody.addShape(sphereShape);
					sphereBody.getPosition().set(
							i*2-nx*0.5 + (Math.random()-0.5)*rand,
							j*2-ny*0.5 + (Math.random()-0.5)*rand,
							1+k*2.1+h+(i+j)*0.0
							);
					sphereBody.setAllowSleep(true);
					sphereBody.setSleepSpeedLimit(1);
					sphereBody.setSleepTimeLimit(5);

					world.addBody(sphereBody);
					demo.addVisual(sphereBody);
				}
			}
		}
	}
}
