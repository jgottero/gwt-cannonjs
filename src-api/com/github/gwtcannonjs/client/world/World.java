package com.github.gwtcannonjs.client.world;

import com.github.gwtcannonjs.client.collision.ArrayCollisionMatrix;
import com.github.gwtcannonjs.client.collision.Broadphase;
import com.github.gwtcannonjs.client.collision.RaycastResult;
import com.github.gwtcannonjs.client.constraints.Constraint;
import com.github.gwtcannonjs.client.equations.ContactEquation;
import com.github.gwtcannonjs.client.material.ContactMaterial;
import com.github.gwtcannonjs.client.material.Material;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.objects.SPHSystem;
import com.github.gwtcannonjs.client.solver.Solver;
import com.github.gwtcannonjs.client.utils.EventTarget;
import com.github.gwtcannonjs.client.utils.TupleDictionary;
import com.google.gwt.core.client.JsArray;

/**
 * The physics world
 */
public class World extends EventTarget {
	protected World() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Last used timestep. Is set to -1 if not available.
	 */
	public final native double getDt() /*-{
		return this.dt;
	}-*/;
	
	/**
	 * Last used timestep. Is set to -1 if not available.
	 */
	public final native void setDt(double dt) /*-{
		this.dt = dt;
	}-*/;
	
	/**
	 * Last used timestep. Is set to -1 if not available.
	 */
	public final native World withDt(double dt) /*-{
		this.dt = dt;
		return this;
	}-*/;
	
	/**
	 * Makes bodies go to sleep when they've been inactive
	 */
	public final native boolean isAllowSleep() /*-{
		return this.allowSleep;
	}-*/;
	
	/**
	 * Makes bodies go to sleep when they've been inactive
	 */
	public final native void setAllowSleep(boolean allowSleep) /*-{
		this.allowSleep = allowSleep;
	}-*/;
	
	/**
	 * Makes bodies go to sleep when they've been inactive
	 */
	public final native World withAllowSleep(boolean allowSleep) /*-{
		this.allowSleep = allowSleep;
		return this;
	}-*/;
	
	/**
	 * All the current contacts (instances of ContactEquation) in the world.
	 */
	public final native JsArray<ContactEquation> getContacts() /*-{
		return this.contacts;
	}-*/;
	
	/**
	 * All the current contacts (instances of ContactEquation) in the world.
	 */
	public final native void setContacts(JsArray<ContactEquation> contacts) /*-{
		this.contacts = contacts;
	}-*/;
	
	/**
	 * All the current contacts (instances of ContactEquation) in the world.
	 */
	public final native World withContacts(JsArray<ContactEquation> contacts) /*-{
		this.contacts = contacts;
		return this;
	}-*/;
	
	/**
	 * How often to normalize quaternions. Set to 0 for every step, 1 for every second etc.. A larger value increases performance. If bodies tend to explode, set to a smaller value (zero to be sure nothing can go wrong).
	 */
	public final native double getQuatNormalizeSkip() /*-{
		return this.quatNormalizeSkip;
	}-*/;
	
	/**
	 * How often to normalize quaternions. Set to 0 for every step, 1 for every second etc.. A larger value increases performance. If bodies tend to explode, set to a smaller value (zero to be sure nothing can go wrong).
	 */
	public final native void setQuatNormalizeSkip(double quatNormalizeSkip) /*-{
		this.quatNormalizeSkip = quatNormalizeSkip;
	}-*/;
	
	/**
	 * How often to normalize quaternions. Set to 0 for every step, 1 for every second etc.. A larger value increases performance. If bodies tend to explode, set to a smaller value (zero to be sure nothing can go wrong).
	 */
	public final native World withQuatNormalizeSkip(double quatNormalizeSkip) /*-{
		this.quatNormalizeSkip = quatNormalizeSkip;
		return this;
	}-*/;
	
	/**
	 * Set to true to use fast quaternion normalization. It is often enough accurate to use. If bodies tend to explode, set to false.
	 * @see Quaternion.normalizeFast
	 */
	public final native boolean isQuatNormalizeFast() /*-{
		return this.quatNormalizeFast;
	}-*/;
	
	/**
	 * Set to true to use fast quaternion normalization. It is often enough accurate to use. If bodies tend to explode, set to false.
	 * @see Quaternion.normalizeFast
	 */
	public final native void setQuatNormalizeFast(boolean quatNormalizeFast) /*-{
		this.quatNormalizeFast = quatNormalizeFast;
	}-*/;
	
	/**
	 * Set to true to use fast quaternion normalization. It is often enough accurate to use. If bodies tend to explode, set to false.
	 * @see Quaternion.normalizeFast
	 */
	public final native World withQuatNormalizeFast(boolean quatNormalizeFast) /*-{
		this.quatNormalizeFast = quatNormalizeFast;
		return this;
	}-*/;
	
	/**
	 * The wall-clock time since simulation start
	 */
	public final native double getTime() /*-{
		return this.time;
	}-*/;
	
	/**
	 * The wall-clock time since simulation start
	 */
	public final native void setTime(double time) /*-{
		this.time = time;
	}-*/;
	
	/**
	 * The wall-clock time since simulation start
	 */
	public final native World withTime(double time) /*-{
		this.time = time;
		return this;
	}-*/;
	
	/**
	 * Number of timesteps taken since start
	 */
	public final native double getStepnumber() /*-{
		return this.stepnumber;
	}-*/;
	
	/**
	 * Number of timesteps taken since start
	 */
	public final native void setStepnumber(double stepnumber) /*-{
		this.stepnumber = stepnumber;
	}-*/;
	
	/**
	 * Number of timesteps taken since start
	 */
	public final native World withStepnumber(double stepnumber) /*-{
		this.stepnumber = stepnumber;
		return this;
	}-*/;
	
	public final native Vec3 getGravity() /*-{
		return this.gravity;
	}-*/;
	
	public final native void setGravity(Vec3 gravity) /*-{
		this.gravity = gravity;
	}-*/;
	
	public final native World withGravity(Vec3 gravity) /*-{
		this.gravity = gravity;
		return this;
	}-*/;
	
	public final native Broadphase getBroadphase() /*-{
		return this.broadphase;
	}-*/;
	
	public final native void setBroadphase(Broadphase broadphase) /*-{
		this.broadphase = broadphase;
	}-*/;
	
	public final native World withBroadphase(Broadphase broadphase) /*-{
		this.broadphase = broadphase;
		return this;
	}-*/;
	
	public final native JsArray<Body> getBodies() /*-{
		return this.bodies;
	}-*/;
	
	public final native void setBodies(JsArray<Body> bodies) /*-{
		this.bodies = bodies;
	}-*/;
	
	public final native World withBodies(JsArray<Body> bodies) /*-{
		this.bodies = bodies;
		return this;
	}-*/;
	
	public final native Solver getSolver() /*-{
		return this.solver;
	}-*/;
	
	public final native void setSolver(Solver solver) /*-{
		this.solver = solver;
	}-*/;
	
	public final native World withSolver(Solver solver) /*-{
		this.solver = solver;
		return this;
	}-*/;
	
	public final native JsArray<? extends Constraint> getConstraints() /*-{
		return this.constraints;
	}-*/;
	
	public final native void setConstraints(JsArray<? extends Constraint> constraints) /*-{
		this.constraints = constraints;
	}-*/;
	
	public final native World withConstraints(JsArray<? extends Constraint> constraints) /*-{
		this.constraints = constraints;
		return this;
	}-*/;
	
	public final native Narrowphase getNarrowphase() /*-{
		return this.narrowphase;
	}-*/;
	
	public final native void setNarrowphase(Narrowphase narrowphase) /*-{
		this.narrowphase = narrowphase;
	}-*/;
	
	public final native World withNarrowphase(Narrowphase narrowphase) /*-{
		this.narrowphase = narrowphase;
		return this;
	}-*/;
	
	public final native ArrayCollisionMatrix getCollisionMatrix() /*-{
		return this.collisionMatrix;
	}-*/;
	
	public final native void setCollisionMatrix(ArrayCollisionMatrix collisionMatrix) /*-{
		this.collisionMatrix = collisionMatrix;
	}-*/;
	
	public final native World withCollisionMatrix(ArrayCollisionMatrix collisionMatrix) /*-{
		this.collisionMatrix = collisionMatrix;
		return this;
	}-*/;
	
	/**
	 * CollisionMatrix from the previous step.
	 */
	public final native ArrayCollisionMatrix getCollisionMatrixPrevious() /*-{
		return this.collisionMatrixPrevious;
	}-*/;
	
	/**
	 * CollisionMatrix from the previous step.
	 */
	public final native void setCollisionMatrixPrevious(ArrayCollisionMatrix collisionMatrixPrevious) /*-{
		this.collisionMatrixPrevious = collisionMatrixPrevious;
	}-*/;
	
	/**
	 * CollisionMatrix from the previous step.
	 */
	public final native World withCollisionMatrixPrevious(ArrayCollisionMatrix collisionMatrixPrevious) /*-{
		this.collisionMatrixPrevious = collisionMatrixPrevious;
		return this;
	}-*/;
	
	/**
	 * All added materials
	 */
	public final native JsArray<Material> getMaterials() /*-{
		return this.materials;
	}-*/;
	
	/**
	 * All added materials
	 */
	public final native void setMaterials(JsArray<Material> materials) /*-{
		this.materials = materials;
	}-*/;
	
	/**
	 * All added materials
	 */
	public final native World withMaterials(JsArray<Material> materials) /*-{
		this.materials = materials;
		return this;
	}-*/;
	
	public final native JsArray<ContactMaterial> getContactmaterials() /*-{
		return this.contactmaterials;
	}-*/;
	
	public final native void setContactmaterials(JsArray<ContactMaterial> contactmaterials) /*-{
		this.contactmaterials = contactmaterials;
	}-*/;
	
	public final native World withContactmaterials(JsArray<ContactMaterial> contactmaterials) /*-{
		this.contactmaterials = contactmaterials;
		return this;
	}-*/;
	
	/**
	 * Used to look up a ContactMaterial given two instances of Material.
	 */
	public final native TupleDictionary getContactMaterialTable() /*-{
		return this.contactMaterialTable;
	}-*/;
	
	/**
	 * Used to look up a ContactMaterial given two instances of Material.
	 */
	public final native void setContactMaterialTable(TupleDictionary contactMaterialTable) /*-{
		this.contactMaterialTable = contactMaterialTable;
	}-*/;
	
	/**
	 * Used to look up a ContactMaterial given two instances of Material.
	 */
	public final native World withContactMaterialTable(TupleDictionary contactMaterialTable) /*-{
		this.contactMaterialTable = contactMaterialTable;
		return this;
	}-*/;
	
	/**
	 * This contact material is used if no suitable contactmaterial is found for a contact.
	 */
	public final native ContactMaterial getDefaultContactMaterial() /*-{
		return this.defaultContactMaterial;
	}-*/;
	
	/**
	 * This contact material is used if no suitable contactmaterial is found for a contact.
	 */
	public final native void setDefaultContactMaterial(ContactMaterial defaultContactMaterial) /*-{
		this.defaultContactMaterial = defaultContactMaterial;
	}-*/;
	
	/**
	 * This contact material is used if no suitable contactmaterial is found for a contact.
	 */
	public final native World withDefaultContactMaterial(ContactMaterial defaultContactMaterial) /*-{
		this.defaultContactMaterial = defaultContactMaterial;
		return this;
	}-*/;
	
	public final native boolean isDoProfiling() /*-{
		return this.doProfiling;
	}-*/;
	
	public final native void setDoProfiling(boolean doProfiling) /*-{
		this.doProfiling = doProfiling;
	}-*/;
	
	public final native World withDoProfiling(boolean doProfiling) /*-{
		this.doProfiling = doProfiling;
		return this;
	}-*/;
	
	public final native Profile getProfile() /*-{
		return this.profile;
	}-*/;
	
	public final native void setProfile(Profile profile) /*-{
		this.profile = profile;
	}-*/;
	
	public final native World withProfile(Profile profile) /*-{
		this.profile = profile;
		return this;
	}-*/;
	
	public final native JsArray<SPHSystem> getSubsystems() /*-{
		return this.subsystems;
	}-*/;
	
	public final native void setSubsystems(JsArray<SPHSystem> subsystems) /*-{
		this.subsystems = subsystems;
	}-*/;
	
	public final native World withSubsystems(JsArray<SPHSystem> subsystems) /*-{
		this.subsystems = subsystems;
		return this;
	}-*/;
	
	/**
	 * Get the contact material between materials m1 and m2
	 * @param m1
	 * @param m2
	 * @return The contact material if it was found.
	 */
	public final native ContactMaterial getContactMaterial(Material m1, Material m2) /*-{
		return this.getContactMaterial(m1, m2);
	}-*/;
	
	/**
	 * Get number of objects in the world.
	 */
	@Deprecated
	public final native double numObjects() /*-{
		return this.numObjects();
	}-*/;
	
	/**
	 * Store old collision state info
	 */
	public final native void collisionMatrixTick() /*-{
		this.collisionMatrixTick();
	}-*/;
	
	/**
	 * Add a rigid body to the simulation.
	 * @param body
	 * @deprecated Use .addBody instead
	 */
	@Deprecated
	public final native void add(Body body) /*-{
		this.add(body);
	}-*/;
	
	/**
	 * Add a constraint to the simulation.
	 * @param c
	 */
	public final native void addConstraint(Constraint c) /*-{
		this.addConstraint(c);
	}-*/;
	
	/**
	 * Removes a constraint
	 * @param c
	 */
	public final native void removeConstraint(Constraint c) /*-{
		this.removeConstraint(c);
	}-*/;
	
	/**
	 * Raycast test
	 * @param from
	 * @param to
	 * @param result
	 */
	public final native void rayTest(Vec3 from, Vec3 to, RaycastResult result) /*-{
		this.rayTest(from, to, result);
	}-*/;
	
	/**
	 * Remove a rigid body from the simulation.
	 * @param body
	 */
	public final native void remove(Body body) /*-{
		this.remove(body);
	}-*/;
	
	/**
	 * Adds a material to the World.
	 * @param m
	 */
	public final native void addMaterial(Material m) /*-{
		this.addMaterial(m);
	}-*/;
	
	/**
	 * Adds a contact material to the World
	 * @param cmat
	 */
	public final native void addContactMaterial(ContactMaterial cmat) /*-{
		this.addContactMaterial(cmat);
	}-*/;
	
	/**
	 * Step the physics world forward in time.
	 * There are two modes. The simple mode is fixed timestepping without interpolation. In this case you only use the first argument. The second case uses interpolation. In that you also provide the time since the function was last used, as well as the maximum fixed timesteps to take.
	 * @param dt The fixed time step size to use.
	 * @param timeSinceLastCalled The time elapsed since the function was last called. Optional.
	 * @param maxSubSteps Maximum number of fixed steps to take per function call. Optional.
	 * @see http://bulletphysics.org/mediawiki-1.5.8/index.php/Stepping_The_World
	 */
	public final native void step(double dt, double timeSinceLastCalled, double maxSubSteps) /*-{
		this.step(dt, timeSinceLastCalled, maxSubSteps);
	}-*/;
	
	/**
	 * Step the simulation
	 * @param dt
	 */
	public final native void step(double dt) /*-{
		this.step(dt);
	}-*/;
	
	/**
	 * Add a rigid body to the simulation.
	 * @param body
	 */
	public final native void addBody(Body body) /*-{
		this.addBody(body);
	}-*/;
	
}
