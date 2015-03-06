// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.objects;

import com.github.gwtcannonjs.client.collision.RaycastResult;
import com.github.gwtcannonjs.client.math.Transform;
import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JavaScriptObject;

public class WheelInfo extends JavaScriptObject {
	protected WheelInfo() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Max travel distance of the suspension, in meters.
	 */
	public final native double getMaxSuspensionTravel() /*-{
		return this.maxSuspensionTravel;
	}-*/;
	
	/**
	 * Max travel distance of the suspension, in meters.
	 */
	public final native void setMaxSuspensionTravel(double maxSuspensionTravel) /*-{
		this.maxSuspensionTravel = maxSuspensionTravel;
	}-*/;
	
	/**
	 * Max travel distance of the suspension, in meters.
	 */
	public final native WheelInfo withMaxSuspensionTravel(double maxSuspensionTravel) /*-{
		this.maxSuspensionTravel = maxSuspensionTravel;
		return this;
	}-*/;
	
	/**
	 * Speed to apply to the wheel rotation when the wheel is sliding.
	 */
	public final native double getCustomSlidingRotationalSpeed() /*-{
		return this.customSlidingRotationalSpeed;
	}-*/;
	
	/**
	 * Speed to apply to the wheel rotation when the wheel is sliding.
	 */
	public final native void setCustomSlidingRotationalSpeed(double customSlidingRotationalSpeed) /*-{
		this.customSlidingRotationalSpeed = customSlidingRotationalSpeed;
	}-*/;
	
	/**
	 * Speed to apply to the wheel rotation when the wheel is sliding.
	 */
	public final native WheelInfo withCustomSlidingRotationalSpeed(double customSlidingRotationalSpeed) /*-{
		this.customSlidingRotationalSpeed = customSlidingRotationalSpeed;
		return this;
	}-*/;
	
	/**
	 * If the customSlidingRotationalSpeed should be used.
	 */
	public final native boolean isUseCustomSlidingRotationalSpeed() /*-{
		return this.useCustomSlidingRotationalSpeed;
	}-*/;
	
	/**
	 * If the customSlidingRotationalSpeed should be used.
	 */
	public final native void setUseCustomSlidingRotationalSpeed(boolean useCustomSlidingRotationalSpeed) /*-{
		this.useCustomSlidingRotationalSpeed = useCustomSlidingRotationalSpeed;
	}-*/;
	
	/**
	 * If the customSlidingRotationalSpeed should be used.
	 */
	public final native WheelInfo withUseCustomSlidingRotationalSpeed(boolean useCustomSlidingRotationalSpeed) /*-{
		this.useCustomSlidingRotationalSpeed = useCustomSlidingRotationalSpeed;
		return this;
	}-*/;
	
	public final native boolean isSliding() /*-{
		return this.sliding;
	}-*/;
	
	public final native void setSliding(boolean sliding) /*-{
		this.sliding = sliding;
	}-*/;
	
	public final native WheelInfo withSliding(boolean sliding) /*-{
		this.sliding = sliding;
		return this;
	}-*/;
	
	/**
	 * Connection point, defined locally in the chassis body frame.
	 */
	public final native Vec3 getChassisConnectionPointLocal() /*-{
		return this.chassisConnectionPointLocal;
	}-*/;
	
	/**
	 * Connection point, defined locally in the chassis body frame.
	 */
	public final native void setChassisConnectionPointLocal(Vec3 chassisConnectionPointLocal) /*-{
		this.chassisConnectionPointLocal = chassisConnectionPointLocal;
	}-*/;
	
	/**
	 * Connection point, defined locally in the chassis body frame.
	 */
	public final native WheelInfo withChassisConnectionPointLocal(Vec3 chassisConnectionPointLocal) /*-{
		this.chassisConnectionPointLocal = chassisConnectionPointLocal;
		return this;
	}-*/;
	
	public final native Vec3 getChassisConnectionPointWorld() /*-{
		return this.chassisConnectionPointWorld;
	}-*/;
	
	public final native void setChassisConnectionPointWorld(Vec3 chassisConnectionPointWorld) /*-{
		this.chassisConnectionPointWorld = chassisConnectionPointWorld;
	}-*/;
	
	public final native WheelInfo withChassisConnectionPointWorld(Vec3 chassisConnectionPointWorld) /*-{
		this.chassisConnectionPointWorld = chassisConnectionPointWorld;
		return this;
	}-*/;
	
	public final native Vec3 getDirectionLocal() /*-{
		return this.directionLocal;
	}-*/;
	
	public final native void setDirectionLocal(Vec3 directionLocal) /*-{
		this.directionLocal = directionLocal;
	}-*/;
	
	public final native WheelInfo withDirectionLocal(Vec3 directionLocal) /*-{
		this.directionLocal = directionLocal;
		return this;
	}-*/;
	
	public final native Vec3 getDirectionWorld() /*-{
		return this.directionWorld;
	}-*/;
	
	public final native void setDirectionWorld(Vec3 directionWorld) /*-{
		this.directionWorld = directionWorld;
	}-*/;
	
	public final native WheelInfo withDirectionWorld(Vec3 directionWorld) /*-{
		this.directionWorld = directionWorld;
		return this;
	}-*/;
	
	public final native Vec3 getAxleLocal() /*-{
		return this.axleLocal;
	}-*/;
	
	public final native void setAxleLocal(Vec3 axleLocal) /*-{
		this.axleLocal = axleLocal;
	}-*/;
	
	public final native WheelInfo withAxleLocal(Vec3 axleLocal) /*-{
		this.axleLocal = axleLocal;
		return this;
	}-*/;
	
	public final native Vec3 getAxleWorld() /*-{
		return this.axleWorld;
	}-*/;
	
	public final native void setAxleWorld(Vec3 axleWorld) /*-{
		this.axleWorld = axleWorld;
	}-*/;
	
	public final native WheelInfo withAxleWorld(Vec3 axleWorld) /*-{
		this.axleWorld = axleWorld;
		return this;
	}-*/;
	
	public final native double getSuspensionRestLength() /*-{
		return this.suspensionRestLength;
	}-*/;
	
	public final native void setSuspensionRestLength(double suspensionRestLength) /*-{
		this.suspensionRestLength = suspensionRestLength;
	}-*/;
	
	public final native WheelInfo withSuspensionRestLength(double suspensionRestLength) /*-{
		this.suspensionRestLength = suspensionRestLength;
		return this;
	}-*/;
	
	public final native double getSuspensionMaxLength() /*-{
		return this.suspensionMaxLength;
	}-*/;
	
	public final native void setSuspensionMaxLength(double suspensionMaxLength) /*-{
		this.suspensionMaxLength = suspensionMaxLength;
	}-*/;
	
	public final native WheelInfo withSuspensionMaxLength(double suspensionMaxLength) /*-{
		this.suspensionMaxLength = suspensionMaxLength;
		return this;
	}-*/;
	
	public final native double getRadius() /*-{
		return this.radius;
	}-*/;
	
	public final native void setRadius(double radius) /*-{
		this.radius = radius;
	}-*/;
	
	public final native WheelInfo withRadius(double radius) /*-{
		this.radius = radius;
		return this;
	}-*/;
	
	public final native double getSuspensionStiffness() /*-{
		return this.suspensionStiffness;
	}-*/;
	
	public final native void setSuspensionStiffness(double suspensionStiffness) /*-{
		this.suspensionStiffness = suspensionStiffness;
	}-*/;
	
	public final native WheelInfo withSuspensionStiffness(double suspensionStiffness) /*-{
		this.suspensionStiffness = suspensionStiffness;
		return this;
	}-*/;
	
	public final native double getDampingCompression() /*-{
		return this.dampingCompression;
	}-*/;
	
	public final native void setDampingCompression(double dampingCompression) /*-{
		this.dampingCompression = dampingCompression;
	}-*/;
	
	public final native WheelInfo withDampingCompression(double dampingCompression) /*-{
		this.dampingCompression = dampingCompression;
		return this;
	}-*/;
	
	public final native double getDampingRelaxation() /*-{
		return this.dampingRelaxation;
	}-*/;
	
	public final native void setDampingRelaxation(double dampingRelaxation) /*-{
		this.dampingRelaxation = dampingRelaxation;
	}-*/;
	
	public final native WheelInfo withDampingRelaxation(double dampingRelaxation) /*-{
		this.dampingRelaxation = dampingRelaxation;
		return this;
	}-*/;
	
	public final native double getFrictionSlip() /*-{
		return this.frictionSlip;
	}-*/;
	
	public final native void setFrictionSlip(double frictionSlip) /*-{
		this.frictionSlip = frictionSlip;
	}-*/;
	
	public final native WheelInfo withFrictionSlip(double frictionSlip) /*-{
		this.frictionSlip = frictionSlip;
		return this;
	}-*/;
	
	public final native double getSteering() /*-{
		return this.steering;
	}-*/;
	
	public final native void setSteering(double steering) /*-{
		this.steering = steering;
	}-*/;
	
	public final native WheelInfo withSteering(double steering) /*-{
		this.steering = steering;
		return this;
	}-*/;
	
	/**
	 * Rotation value, in radians.
	 */
	public final native double getRotation() /*-{
		return this.rotation;
	}-*/;
	
	/**
	 * Rotation value, in radians.
	 */
	public final native void setRotation(double rotation) /*-{
		this.rotation = rotation;
	}-*/;
	
	/**
	 * Rotation value, in radians.
	 */
	public final native WheelInfo withRotation(double rotation) /*-{
		this.rotation = rotation;
		return this;
	}-*/;
	
	public final native double getDeltaRotation() /*-{
		return this.deltaRotation;
	}-*/;
	
	public final native void setDeltaRotation(double deltaRotation) /*-{
		this.deltaRotation = deltaRotation;
	}-*/;
	
	public final native WheelInfo withDeltaRotation(double deltaRotation) /*-{
		this.deltaRotation = deltaRotation;
		return this;
	}-*/;
	
	public final native double getRollInfluence() /*-{
		return this.rollInfluence;
	}-*/;
	
	public final native void setRollInfluence(double rollInfluence) /*-{
		this.rollInfluence = rollInfluence;
	}-*/;
	
	public final native WheelInfo withRollInfluence(double rollInfluence) /*-{
		this.rollInfluence = rollInfluence;
		return this;
	}-*/;
	
	public final native double getMaxSuspensionForce() /*-{
		return this.maxSuspensionForce;
	}-*/;
	
	public final native void setMaxSuspensionForce(double maxSuspensionForce) /*-{
		this.maxSuspensionForce = maxSuspensionForce;
	}-*/;
	
	public final native WheelInfo withMaxSuspensionForce(double maxSuspensionForce) /*-{
		this.maxSuspensionForce = maxSuspensionForce;
		return this;
	}-*/;
	
	public final native double getEngineForce() /*-{
		return this.engineForce;
	}-*/;
	
	public final native void setEngineForce(double engineForce) /*-{
		this.engineForce = engineForce;
	}-*/;
	
	public final native WheelInfo withEngineForce(double engineForce) /*-{
		this.engineForce = engineForce;
		return this;
	}-*/;
	
	public final native double getBrake() /*-{
		return this.brake;
	}-*/;
	
	public final native void setBrake(double brake) /*-{
		this.brake = brake;
	}-*/;
	
	public final native WheelInfo withBrake(double brake) /*-{
		this.brake = brake;
		return this;
	}-*/;
	
	public final native boolean isFrontWheel() /*-{
		return this.isFrontWheel;
	}-*/;
	
	public final native void setFrontWheel(boolean isFrontWheel) /*-{
		this.isFrontWheel = isFrontWheel;
	}-*/;
	
	public final native WheelInfo withFrontWheel(boolean isFrontWheel) /*-{
		this.isFrontWheel = isFrontWheel;
		return this;
	}-*/;
	
	public final native double getClippedInvContactDotSuspension() /*-{
		return this.clippedInvContactDotSuspension;
	}-*/;
	
	public final native void setClippedInvContactDotSuspension(double clippedInvContactDotSuspension) /*-{
		this.clippedInvContactDotSuspension = clippedInvContactDotSuspension;
	}-*/;
	
	public final native WheelInfo withClippedInvContactDotSuspension(double clippedInvContactDotSuspension) /*-{
		this.clippedInvContactDotSuspension = clippedInvContactDotSuspension;
		return this;
	}-*/;
	
	public final native double getSuspensionRelativeVelocity() /*-{
		return this.suspensionRelativeVelocity;
	}-*/;
	
	public final native void setSuspensionRelativeVelocity(double suspensionRelativeVelocity) /*-{
		this.suspensionRelativeVelocity = suspensionRelativeVelocity;
	}-*/;
	
	public final native WheelInfo withSuspensionRelativeVelocity(double suspensionRelativeVelocity) /*-{
		this.suspensionRelativeVelocity = suspensionRelativeVelocity;
		return this;
	}-*/;
	
	public final native double getSuspensionForce() /*-{
		return this.suspensionForce;
	}-*/;
	
	public final native void setSuspensionForce(double suspensionForce) /*-{
		this.suspensionForce = suspensionForce;
	}-*/;
	
	public final native WheelInfo withSuspensionForce(double suspensionForce) /*-{
		this.suspensionForce = suspensionForce;
		return this;
	}-*/;
	
	public final native double getSkidInfo() /*-{
		return this.skidInfo;
	}-*/;
	
	public final native void setSkidInfo(double skidInfo) /*-{
		this.skidInfo = skidInfo;
	}-*/;
	
	public final native WheelInfo withSkidInfo(double skidInfo) /*-{
		this.skidInfo = skidInfo;
		return this;
	}-*/;
	
	public final native double getSuspensionLength() /*-{
		return this.suspensionLength;
	}-*/;
	
	public final native void setSuspensionLength(double suspensionLength) /*-{
		this.suspensionLength = suspensionLength;
	}-*/;
	
	public final native WheelInfo withSuspensionLength(double suspensionLength) /*-{
		this.suspensionLength = suspensionLength;
		return this;
	}-*/;
	
	public final native double getSideImpulse() /*-{
		return this.sideImpulse;
	}-*/;
	
	public final native void setSideImpulse(double sideImpulse) /*-{
		this.sideImpulse = sideImpulse;
	}-*/;
	
	public final native WheelInfo withSideImpulse(double sideImpulse) /*-{
		this.sideImpulse = sideImpulse;
		return this;
	}-*/;
	
	public final native double getForwardImpulse() /*-{
		return this.forwardImpulse;
	}-*/;
	
	public final native void setForwardImpulse(double forwardImpulse) /*-{
		this.forwardImpulse = forwardImpulse;
	}-*/;
	
	public final native WheelInfo withForwardImpulse(double forwardImpulse) /*-{
		this.forwardImpulse = forwardImpulse;
		return this;
	}-*/;
	
	/**
	 * The result from raycasting
	 */
	public final native RaycastResult getRaycastResult() /*-{
		return this.raycastResult;
	}-*/;
	
	/**
	 * The result from raycasting
	 */
	public final native void setRaycastResult(RaycastResult raycastResult) /*-{
		this.raycastResult = raycastResult;
	}-*/;
	
	/**
	 * The result from raycasting
	 */
	public final native WheelInfo withRaycastResult(RaycastResult raycastResult) /*-{
		this.raycastResult = raycastResult;
		return this;
	}-*/;
	
	/**
	 * Wheel world transform
	 */
	public final native Transform getWorldTransform() /*-{
		return this.worldTransform;
	}-*/;
	
	/**
	 * Wheel world transform
	 */
	public final native void setWorldTransform(Transform worldTransform) /*-{
		this.worldTransform = worldTransform;
	}-*/;
	
	/**
	 * Wheel world transform
	 */
	public final native WheelInfo withWorldTransform(Transform worldTransform) /*-{
		this.worldTransform = worldTransform;
		return this;
	}-*/;
	
	public final native boolean isInContact() /*-{
		return this.isInContact;
	}-*/;
	
	public final native void setInContact(boolean isInContact) /*-{
		this.isInContact = isInContact;
	}-*/;
	
	public final native WheelInfo withInContact(boolean isInContact) /*-{
		this.isInContact = isInContact;
		return this;
	}-*/;
	
}
