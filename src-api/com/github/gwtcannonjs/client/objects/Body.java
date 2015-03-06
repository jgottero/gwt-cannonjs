// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.objects;

import com.github.gwtcannonjs.client.collision.AABB;
import com.github.gwtcannonjs.client.material.Material;
import com.github.gwtcannonjs.client.math.Mat3;
import com.github.gwtcannonjs.client.math.Quaternion;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.utils.EventTarget;
import com.github.gwtcannonjs.client.world.World;
import com.google.gwt.core.client.JsArray;

/**
 * Base class for all body types.
 */
public class Body extends EventTarget {
	/**
	 * A dynamic body is fully simulated. Can be moved manually by the user, but normally they move according to forces. A dynamic body can collide with all body types. A dynamic body always has finite, non-zero mass.
	 */
	public static double DYNAMIC;
	
	/**
	 * A static body does not move during simulation and behaves as if it has infinite mass. Static bodies can be moved manually by setting the position of the body. The velocity of a static body is always zero. Static bodies do not collide with other static or kinematic bodies.
	 */
	public static double STATIC;
	
	/**
	 * A kinematic body moves under simulation according to its velocity. They do not respond to forces. They can be moved manually, but normally a kinematic body is moved by setting its velocity. A kinematic body behaves as if it has infinite mass. Kinematic bodies do not collide with other static or kinematic bodies.
	 */
	public static double KINEMATIC;
	
	public static double AWAKE;
	
	public static double SLEEPY;
	
	public static double SLEEPING;
	
	protected Body() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Reference to the world the body is living in
	 */
	public final native World getWorld() /*-{
		return this.world;
	}-*/;
	
	/**
	 * Reference to the world the body is living in
	 */
	public final native void setWorld(World world) /*-{
		this.world = world;
	}-*/;
	
	/**
	 * Reference to the world the body is living in
	 */
	public final native Body withWorld(World world) /*-{
		this.world = world;
		return this;
	}-*/;
	
	/**
	 * Callback function that is used BEFORE stepping the system. Use it to apply forces, for example. Inside the function, "this" will refer to this Body object.
	 * @deprecated Use World events instead
	 */
	@Deprecated
	public final native PreStepCallback getPreStep() /*-{
		return this.preStep__callback ? this.preStep__callback : null;
	}-*/;
	
	/**
	 * Callback function that is used BEFORE stepping the system. Use it to apply forces, for example. Inside the function, "this" will refer to this Body object.
	 * @deprecated Use World events instead
	 */
	@Deprecated
	public final native void setPreStep(PreStepCallback preStep) /*-{
		this.preStep = (preStep ? function() { preStep.@com.github.gwtcannonjs.client.objects.PreStepCallback::execute()(); } : undefined);
		this.preStep__callback = preStep;
	}-*/;
	
	/**
	 * Callback function that is used BEFORE stepping the system. Use it to apply forces, for example. Inside the function, "this" will refer to this Body object.
	 * @deprecated Use World events instead
	 */
	@Deprecated
	public final native Body withPreStep(PreStepCallback preStep) /*-{
		this.preStep = (preStep ? function() { preStep.@com.github.gwtcannonjs.client.objects.PreStepCallback::execute()(); } : undefined);
		this.preStep__callback = preStep;
		return this;
	}-*/;
	
	/**
	 * Callback function that is used AFTER stepping the system. Inside the function, "this" will refer to this Body object.
	 * @deprecated Use World events instead
	 */
	@Deprecated
	public final native PostStepCallback getPostStep() /*-{
		return this.postStep__callback ? this.postStep__callback : null;
	}-*/;
	
	/**
	 * Callback function that is used AFTER stepping the system. Inside the function, "this" will refer to this Body object.
	 * @deprecated Use World events instead
	 */
	@Deprecated
	public final native void setPostStep(PostStepCallback postStep) /*-{
		this.postStep = (postStep ? function() { postStep.@com.github.gwtcannonjs.client.objects.PostStepCallback::execute()(); } : undefined);
		this.postStep__callback = postStep;
	}-*/;
	
	/**
	 * Callback function that is used AFTER stepping the system. Inside the function, "this" will refer to this Body object.
	 * @deprecated Use World events instead
	 */
	@Deprecated
	public final native Body withPostStep(PostStepCallback postStep) /*-{
		this.postStep = (postStep ? function() { postStep.@com.github.gwtcannonjs.client.objects.PostStepCallback::execute()(); } : undefined);
		this.postStep__callback = postStep;
		return this;
	}-*/;
	
	public final native double getCollisionFilterGroup() /*-{
		return this.collisionFilterGroup;
	}-*/;
	
	public final native void setCollisionFilterGroup(double collisionFilterGroup) /*-{
		this.collisionFilterGroup = collisionFilterGroup;
	}-*/;
	
	public final native Body withCollisionFilterGroup(double collisionFilterGroup) /*-{
		this.collisionFilterGroup = collisionFilterGroup;
		return this;
	}-*/;
	
	public final native double getCollisionFilterMask() /*-{
		return this.collisionFilterMask;
	}-*/;
	
	public final native void setCollisionFilterMask(double collisionFilterMask) /*-{
		this.collisionFilterMask = collisionFilterMask;
	}-*/;
	
	public final native Body withCollisionFilterMask(double collisionFilterMask) /*-{
		this.collisionFilterMask = collisionFilterMask;
		return this;
	}-*/;
	
	/**
	 * Whether to produce contact forces when in contact with other bodies. Note that contacts will be generated, but they will be disabled.
	 */
	public final native double getCollisionResponse() /*-{
		return this.collisionResponse;
	}-*/;
	
	/**
	 * Whether to produce contact forces when in contact with other bodies. Note that contacts will be generated, but they will be disabled.
	 */
	public final native void setCollisionResponse(double collisionResponse) /*-{
		this.collisionResponse = collisionResponse;
	}-*/;
	
	/**
	 * Whether to produce contact forces when in contact with other bodies. Note that contacts will be generated, but they will be disabled.
	 */
	public final native Body withCollisionResponse(double collisionResponse) /*-{
		this.collisionResponse = collisionResponse;
		return this;
	}-*/;
	
	public final native Vec3 getPosition() /*-{
		return this.position;
	}-*/;
	
	public final native void setPosition(Vec3 position) /*-{
		this.position = position;
	}-*/;
	
	public final native Body withPosition(Vec3 position) /*-{
		this.position = position;
		return this;
	}-*/;
	
	public final native Vec3 getPreviousPosition() /*-{
		return this.previousPosition;
	}-*/;
	
	public final native void setPreviousPosition(Vec3 previousPosition) /*-{
		this.previousPosition = previousPosition;
	}-*/;
	
	public final native Body withPreviousPosition(Vec3 previousPosition) /*-{
		this.previousPosition = previousPosition;
		return this;
	}-*/;
	
	/**
	 * Initial position of the body
	 */
	public final native Vec3 getInitPosition() /*-{
		return this.initPosition;
	}-*/;
	
	/**
	 * Initial position of the body
	 */
	public final native void setInitPosition(Vec3 initPosition) /*-{
		this.initPosition = initPosition;
	}-*/;
	
	/**
	 * Initial position of the body
	 */
	public final native Body withInitPosition(Vec3 initPosition) /*-{
		this.initPosition = initPosition;
		return this;
	}-*/;
	
	public final native Vec3 getVelocity() /*-{
		return this.velocity;
	}-*/;
	
	public final native void setVelocity(Vec3 velocity) /*-{
		this.velocity = velocity;
	}-*/;
	
	public final native Body withVelocity(Vec3 velocity) /*-{
		this.velocity = velocity;
		return this;
	}-*/;
	
	public final native Vec3 getInitVelocity() /*-{
		return this.initVelocity;
	}-*/;
	
	public final native void setInitVelocity(Vec3 initVelocity) /*-{
		this.initVelocity = initVelocity;
	}-*/;
	
	public final native Body withInitVelocity(Vec3 initVelocity) /*-{
		this.initVelocity = initVelocity;
		return this;
	}-*/;
	
	/**
	 * Linear force on the body
	 */
	public final native Vec3 getForce() /*-{
		return this.force;
	}-*/;
	
	/**
	 * Linear force on the body
	 */
	public final native void setForce(Vec3 force) /*-{
		this.force = force;
	}-*/;
	
	/**
	 * Linear force on the body
	 */
	public final native Body withForce(Vec3 force) /*-{
		this.force = force;
		return this;
	}-*/;
	
	public final native double getMass() /*-{
		return this.mass;
	}-*/;
	
	public final native void setMass(double mass) /*-{
		this.mass = mass;
	}-*/;
	
	public final native Body withMass(double mass) /*-{
		this.mass = mass;
		return this;
	}-*/;
	
	public final native double getInvMass() /*-{
		return this.invMass;
	}-*/;
	
	public final native void setInvMass(double invMass) /*-{
		this.invMass = invMass;
	}-*/;
	
	public final native Body withInvMass(double invMass) /*-{
		this.invMass = invMass;
		return this;
	}-*/;
	
	public final native Material getMaterial() /*-{
		return this.material;
	}-*/;
	
	public final native void setMaterial(Material material) /*-{
		this.material = material;
	}-*/;
	
	public final native Body withMaterial(Material material) /*-{
		this.material = material;
		return this;
	}-*/;
	
	public final native double getLinearDamping() /*-{
		return this.linearDamping;
	}-*/;
	
	public final native void setLinearDamping(double linearDamping) /*-{
		this.linearDamping = linearDamping;
	}-*/;
	
	public final native Body withLinearDamping(double linearDamping) /*-{
		this.linearDamping = linearDamping;
		return this;
	}-*/;
	
	/**
	 * One of: Body.DYNAMIC, Body.STATIC and Body.KINEMATIC.
	 */
	public final native double getType() /*-{
		return this.type;
	}-*/;
	
	/**
	 * One of: Body.DYNAMIC, Body.STATIC and Body.KINEMATIC.
	 */
	public final native void setType(double type) /*-{
		this.type = type;
	}-*/;
	
	/**
	 * One of: Body.DYNAMIC, Body.STATIC and Body.KINEMATIC.
	 */
	public final native Body withType(double type) /*-{
		this.type = type;
		return this;
	}-*/;
	
	/**
	 * If true, the body will automatically fall to sleep.
	 */
	public final native boolean isAllowSleep() /*-{
		return this.allowSleep;
	}-*/;
	
	/**
	 * If true, the body will automatically fall to sleep.
	 */
	public final native void setAllowSleep(boolean allowSleep) /*-{
		this.allowSleep = allowSleep;
	}-*/;
	
	/**
	 * If true, the body will automatically fall to sleep.
	 */
	public final native Body withAllowSleep(boolean allowSleep) /*-{
		this.allowSleep = allowSleep;
		return this;
	}-*/;
	
	/**
	 * Current sleep state.
	 */
	public final native double getSleepState() /*-{
		return this.sleepState;
	}-*/;
	
	/**
	 * Current sleep state.
	 */
	public final native void setSleepState(double sleepState) /*-{
		this.sleepState = sleepState;
	}-*/;
	
	/**
	 * Current sleep state.
	 */
	public final native Body withSleepState(double sleepState) /*-{
		this.sleepState = sleepState;
		return this;
	}-*/;
	
	/**
	 * If the speed (the norm of the velocity) is smaller than this value, the body is considered sleepy.
	 */
	public final native double getSleepSpeedLimit() /*-{
		return this.sleepSpeedLimit;
	}-*/;
	
	/**
	 * If the speed (the norm of the velocity) is smaller than this value, the body is considered sleepy.
	 */
	public final native void setSleepSpeedLimit(double sleepSpeedLimit) /*-{
		this.sleepSpeedLimit = sleepSpeedLimit;
	}-*/;
	
	/**
	 * If the speed (the norm of the velocity) is smaller than this value, the body is considered sleepy.
	 */
	public final native Body withSleepSpeedLimit(double sleepSpeedLimit) /*-{
		this.sleepSpeedLimit = sleepSpeedLimit;
		return this;
	}-*/;
	
	/**
	 * If the body has been sleepy for this sleepTimeLimit seconds, it is considered sleeping.
	 */
	public final native double getSleepTimeLimit() /*-{
		return this.sleepTimeLimit;
	}-*/;
	
	/**
	 * If the body has been sleepy for this sleepTimeLimit seconds, it is considered sleeping.
	 */
	public final native void setSleepTimeLimit(double sleepTimeLimit) /*-{
		this.sleepTimeLimit = sleepTimeLimit;
	}-*/;
	
	/**
	 * If the body has been sleepy for this sleepTimeLimit seconds, it is considered sleeping.
	 */
	public final native Body withSleepTimeLimit(double sleepTimeLimit) /*-{
		this.sleepTimeLimit = sleepTimeLimit;
		return this;
	}-*/;
	
	/**
	 * Rotational force on the body, around center of mass
	 */
	public final native Vec3 getTorque() /*-{
		return this.torque;
	}-*/;
	
	/**
	 * Rotational force on the body, around center of mass
	 */
	public final native void setTorque(Vec3 torque) /*-{
		this.torque = torque;
	}-*/;
	
	/**
	 * Rotational force on the body, around center of mass
	 */
	public final native Body withTorque(Vec3 torque) /*-{
		this.torque = torque;
		return this;
	}-*/;
	
	/**
	 * Orientation of the body
	 */
	public final native Quaternion getQuaternion() /*-{
		return this.quaternion;
	}-*/;
	
	/**
	 * Orientation of the body
	 */
	public final native void setQuaternion(Quaternion quaternion) /*-{
		this.quaternion = quaternion;
	}-*/;
	
	/**
	 * Orientation of the body
	 */
	public final native Body withQuaternion(Quaternion quaternion) /*-{
		this.quaternion = quaternion;
		return this;
	}-*/;
	
	public final native Quaternion getInitQuaternion() /*-{
		return this.initQuaternion;
	}-*/;
	
	public final native void setInitQuaternion(Quaternion initQuaternion) /*-{
		this.initQuaternion = initQuaternion;
	}-*/;
	
	public final native Body withInitQuaternion(Quaternion initQuaternion) /*-{
		this.initQuaternion = initQuaternion;
		return this;
	}-*/;
	
	public final native Vec3 getAngularVelocity() /*-{
		return this.angularVelocity;
	}-*/;
	
	public final native void setAngularVelocity(Vec3 angularVelocity) /*-{
		this.angularVelocity = angularVelocity;
	}-*/;
	
	public final native Body withAngularVelocity(Vec3 angularVelocity) /*-{
		this.angularVelocity = angularVelocity;
		return this;
	}-*/;
	
	public final native Vec3 getInitAngularVelocity() /*-{
		return this.initAngularVelocity;
	}-*/;
	
	public final native void setInitAngularVelocity(Vec3 initAngularVelocity) /*-{
		this.initAngularVelocity = initAngularVelocity;
	}-*/;
	
	public final native Body withInitAngularVelocity(Vec3 initAngularVelocity) /*-{
		this.initAngularVelocity = initAngularVelocity;
		return this;
	}-*/;
	
	public final native JsArray<? extends Shape> getShapes() /*-{
		return this.shapes;
	}-*/;
	
	public final native void setShapes(JsArray<? extends Shape> shapes) /*-{
		this.shapes = shapes;
	}-*/;
	
	public final native Body withShapes(JsArray<? extends Shape> shapes) /*-{
		this.shapes = shapes;
		return this;
	}-*/;
	
	public final native JsArray<Vec3> getShapeOffsets() /*-{
		return this.shapeOffsets;
	}-*/;
	
	public final native void setShapeOffsets(JsArray<Vec3> shapeOffsets) /*-{
		this.shapeOffsets = shapeOffsets;
	}-*/;
	
	public final native Body withShapeOffsets(JsArray<Vec3> shapeOffsets) /*-{
		this.shapeOffsets = shapeOffsets;
		return this;
	}-*/;
	
	public final native JsArray<Quaternion> getShapeOrientations() /*-{
		return this.shapeOrientations;
	}-*/;
	
	public final native void setShapeOrientations(JsArray<Quaternion> shapeOrientations) /*-{
		this.shapeOrientations = shapeOrientations;
	}-*/;
	
	public final native Body withShapeOrientations(JsArray<Quaternion> shapeOrientations) /*-{
		this.shapeOrientations = shapeOrientations;
		return this;
	}-*/;
	
	public final native Vec3 getInertia() /*-{
		return this.inertia;
	}-*/;
	
	public final native void setInertia(Vec3 inertia) /*-{
		this.inertia = inertia;
	}-*/;
	
	public final native Body withInertia(Vec3 inertia) /*-{
		this.inertia = inertia;
		return this;
	}-*/;
	
	public final native Vec3 getInvInertia() /*-{
		return this.invInertia;
	}-*/;
	
	public final native void setInvInertia(Vec3 invInertia) /*-{
		this.invInertia = invInertia;
	}-*/;
	
	public final native Body withInvInertia(Vec3 invInertia) /*-{
		this.invInertia = invInertia;
		return this;
	}-*/;
	
	public final native Mat3 getInvInertiaWorld() /*-{
		return this.invInertiaWorld;
	}-*/;
	
	public final native void setInvInertiaWorld(Mat3 invInertiaWorld) /*-{
		this.invInertiaWorld = invInertiaWorld;
	}-*/;
	
	public final native Body withInvInertiaWorld(Mat3 invInertiaWorld) /*-{
		this.invInertiaWorld = invInertiaWorld;
		return this;
	}-*/;
	
	public final native Vec3 getInvInertiaSolve() /*-{
		return this.invInertiaSolve;
	}-*/;
	
	public final native void setInvInertiaSolve(Vec3 invInertiaSolve) /*-{
		this.invInertiaSolve = invInertiaSolve;
	}-*/;
	
	public final native Body withInvInertiaSolve(Vec3 invInertiaSolve) /*-{
		this.invInertiaSolve = invInertiaSolve;
		return this;
	}-*/;
	
	public final native Mat3 getInvInertiaWorldSolve() /*-{
		return this.invInertiaWorldSolve;
	}-*/;
	
	public final native void setInvInertiaWorldSolve(Mat3 invInertiaWorldSolve) /*-{
		this.invInertiaWorldSolve = invInertiaWorldSolve;
	}-*/;
	
	public final native Body withInvInertiaWorldSolve(Mat3 invInertiaWorldSolve) /*-{
		this.invInertiaWorldSolve = invInertiaWorldSolve;
		return this;
	}-*/;
	
	/**
	 * Set to true if you don't want the body to rotate. Make sure to run .updateMassProperties() after changing this.
	 */
	public final native boolean isFixedRotation() /*-{
		return this.fixedRotation;
	}-*/;
	
	/**
	 * Set to true if you don't want the body to rotate. Make sure to run .updateMassProperties() after changing this.
	 */
	public final native void setFixedRotation(boolean fixedRotation) /*-{
		this.fixedRotation = fixedRotation;
	}-*/;
	
	/**
	 * Set to true if you don't want the body to rotate. Make sure to run .updateMassProperties() after changing this.
	 */
	public final native Body withFixedRotation(boolean fixedRotation) /*-{
		this.fixedRotation = fixedRotation;
		return this;
	}-*/;
	
	public final native double getAngularDamping() /*-{
		return this.angularDamping;
	}-*/;
	
	public final native void setAngularDamping(double angularDamping) /*-{
		this.angularDamping = angularDamping;
	}-*/;
	
	public final native Body withAngularDamping(double angularDamping) /*-{
		this.angularDamping = angularDamping;
		return this;
	}-*/;
	
	public final native AABB getAabb() /*-{
		return this.aabb;
	}-*/;
	
	public final native void setAabb(AABB aabb) /*-{
		this.aabb = aabb;
	}-*/;
	
	public final native Body withAabb(AABB aabb) /*-{
		this.aabb = aabb;
		return this;
	}-*/;
	
	/**
	 * Indicates if the AABB needs to be updated before use.
	 */
	public final native boolean isAabbNeedsUpdate() /*-{
		return this.aabbNeedsUpdate;
	}-*/;
	
	/**
	 * Indicates if the AABB needs to be updated before use.
	 */
	public final native void setAabbNeedsUpdate(boolean aabbNeedsUpdate) /*-{
		this.aabbNeedsUpdate = aabbNeedsUpdate;
	}-*/;
	
	/**
	 * Indicates if the AABB needs to be updated before use.
	 */
	public final native Body withAabbNeedsUpdate(boolean aabbNeedsUpdate) /*-{
		this.aabbNeedsUpdate = aabbNeedsUpdate;
		return this;
	}-*/;
	
	/**
	 * Wake the body up.
	 */
	public final native void wakeUp() /*-{
		this.wakeUp();
	}-*/;
	
	/**
	 * Force body sleep
	 */
	public final native void sleep() /*-{
		this.sleep();
	}-*/;
	
	/**
	 * Called every timestep to update internal sleep timer and change sleep state if needed.
	 * @param time The world time in seconds
	 */
	public final native void sleepTick(double time) /*-{
		this.sleepTick(time);
	}-*/;
	
	/**
	 * If the body is sleeping, it should be immovable / have infinite mass during solve. We solve it by having a separate "solve mass".
	 */
	public final native void updateSolveMassProperties() /*-{
		this.updateSolveMassProperties();
	}-*/;
	
	/**
	 * Convert a world point to local body frame.
	 * @param worldPoint
	 * @param result
	 */
	public final native Vec3 pointToLocalFrame(Vec3 worldPoint, Vec3 result) /*-{
		return this.pointToLocalFrame(worldPoint, result);
	}-*/;
	
	/**
	 * Convert a local body point to world frame.
	 * @param localPoint
	 * @param result
	 */
	public final native Vec3 pointToWorldFrame(Vec3 localPoint, Vec3 result) /*-{
		return this.pointToWorldFrame(localPoint, result);
	}-*/;
	
	/**
	 * Convert a local body point to world frame.
	 * @param localVector
	 * @param result
	 */
	public final native Vec3 vectorToWorldFrame(Vec3 localVector, Vec3 result) /*-{
		return this.vectorToWorldFrame(localVector, result);
	}-*/;
	
	/**
	 * Add a shape to the body with a local offset and orientation.
	 * @param shape
	 * @param offset
	 * @param quaternion
	 * @return The body object, for chainability.
	 */
	public final native Body addShape(Shape shape, Vec3 offset, Quaternion quaternion) /*-{
		return this.addShape(shape, offset, quaternion);
	}-*/;
	
	/**
	 * Update the bounding radius of the body. Should be done if any of the shapes are changed.
	 */
	public final native void updateBoundingRadius() /*-{
		this.updateBoundingRadius();
	}-*/;
	
	/**
	 * Updates the .aabb
	 */
	public final native void computeAABB() /*-{
		this.computeAABB();
	}-*/;
	
	/**
	 * Update .inertiaWorld and .invInertiaWorld
	 */
	public final native void updateInertiaWorld() /*-{
		this.updateInertiaWorld();
	}-*/;
	
	/**
	 * Apply force to a world point. This could for example be a point on the Body surface. Applying force this way will add to Body.force and Body.torque.
	 * @param force The amount of force to add.
	 * @param worldPoint A world point to apply the force on.
	 */
	public final native void applyForce(Vec3 force, Vec3 worldPoint) /*-{
		this.applyForce(force, worldPoint);
	}-*/;
	
	/**
	 * Apply impulse to a world point. This could for example be a point on the Body surface. An impulse is a force added to a body during a short period of time (impulse = force * time). Impulses will be added to Body.velocity and Body.angularVelocity.
	 * @param impulse The amount of impulse to add.
	 * @param worldPoint A world point to apply the force on.
	 */
	public final native void applyImpulse(Vec3 impulse, Vec3 worldPoint) /*-{
		this.applyImpulse(impulse, worldPoint);
	}-*/;
	
	/**
	 * Should be called whenever you change the body mass.
	 */
	public final native void updateMassProperties() /*-{
		this.updateMassProperties();
	}-*/;
	
	/**
	 * Get world velocity of a point in the body.
	 * @param worldPoint
	 * @param result
	 * @return The result vector.
	 */
	public final native Vec3 getVelocityAtWorldPoint(Vec3 worldPoint, Vec3 result) /*-{
		return this.getVelocityAtWorldPoint(worldPoint, result);
	}-*/;
	
	/**
	 * Add a shape to the body with a local offset and orientation.
	 * @param shape
	 * @return The body object, for chainability.
	 */
	public final native Body addShape(Shape shape) /*-{
		return this.addShape(shape);
	}-*/;
	
	/**
	 * Add a shape to the body with a local offset and orientation.
	 * @param shape
	 * @param offset
	 * @return The body object, for chainability.
	 */
	public final native Body addShape(Shape shape, Vec3 offset) /*-{
		return this.addShape(shape, offset);
	}-*/;
	
	private static native void initializeConstants() /*-{
		@com.github.gwtcannonjs.client.objects.Body::DYNAMIC = $wnd.CANNON.Body.DYNAMIC;
		@com.github.gwtcannonjs.client.objects.Body::STATIC = $wnd.CANNON.Body.STATIC;
		@com.github.gwtcannonjs.client.objects.Body::KINEMATIC = $wnd.CANNON.Body.KINEMATIC;
		@com.github.gwtcannonjs.client.objects.Body::AWAKE = $wnd.CANNON.Body.AWAKE;
		@com.github.gwtcannonjs.client.objects.Body::SLEEPY = $wnd.CANNON.Body.SLEEPY;
		@com.github.gwtcannonjs.client.objects.Body::SLEEPING = $wnd.CANNON.Body.SLEEPING;
	}-*/;
	
	static {
		initializeConstants();
	}
}
