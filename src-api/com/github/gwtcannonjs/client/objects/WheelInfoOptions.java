package com.github.gwtcannonjs.client.objects;

import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JavaScriptObject;

public class WheelInfoOptions extends JavaScriptObject {
	protected WheelInfoOptions() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Optional.
	 */
	public final native Vec3 getChassisConnectionPointLocal() /*-{
		return this.chassisConnectionPointLocal;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setChassisConnectionPointLocal(Vec3 chassisConnectionPointLocal) /*-{
		this.chassisConnectionPointLocal = chassisConnectionPointLocal;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withChassisConnectionPointLocal(Vec3 chassisConnectionPointLocal) /*-{
		this.chassisConnectionPointLocal = chassisConnectionPointLocal;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Vec3 getChassisConnectionPointWorld() /*-{
		return this.chassisConnectionPointWorld;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setChassisConnectionPointWorld(Vec3 chassisConnectionPointWorld) /*-{
		this.chassisConnectionPointWorld = chassisConnectionPointWorld;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withChassisConnectionPointWorld(Vec3 chassisConnectionPointWorld) /*-{
		this.chassisConnectionPointWorld = chassisConnectionPointWorld;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Vec3 getDirectionLocal() /*-{
		return this.directionLocal;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setDirectionLocal(Vec3 directionLocal) /*-{
		this.directionLocal = directionLocal;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withDirectionLocal(Vec3 directionLocal) /*-{
		this.directionLocal = directionLocal;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Vec3 getDirectionWorld() /*-{
		return this.directionWorld;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setDirectionWorld(Vec3 directionWorld) /*-{
		this.directionWorld = directionWorld;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withDirectionWorld(Vec3 directionWorld) /*-{
		this.directionWorld = directionWorld;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Vec3 getAxleLocal() /*-{
		return this.axleLocal;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setAxleLocal(Vec3 axleLocal) /*-{
		this.axleLocal = axleLocal;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withAxleLocal(Vec3 axleLocal) /*-{
		this.axleLocal = axleLocal;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Vec3 getAxleWorld() /*-{
		return this.axleWorld;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setAxleWorld(Vec3 axleWorld) /*-{
		this.axleWorld = axleWorld;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withAxleWorld(Vec3 axleWorld) /*-{
		this.axleWorld = axleWorld;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getSuspensionRestLength() /*-{
		return this.suspensionRestLength;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setSuspensionRestLength(double suspensionRestLength) /*-{
		this.suspensionRestLength = suspensionRestLength;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withSuspensionRestLength(double suspensionRestLength) /*-{
		this.suspensionRestLength = suspensionRestLength;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getSuspensionMaxLength() /*-{
		return this.suspensionMaxLength;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setSuspensionMaxLength(double suspensionMaxLength) /*-{
		this.suspensionMaxLength = suspensionMaxLength;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withSuspensionMaxLength(double suspensionMaxLength) /*-{
		this.suspensionMaxLength = suspensionMaxLength;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getRadius() /*-{
		return this.radius;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setRadius(double radius) /*-{
		this.radius = radius;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withRadius(double radius) /*-{
		this.radius = radius;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getSuspensionStiffness() /*-{
		return this.suspensionStiffness;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setSuspensionStiffness(double suspensionStiffness) /*-{
		this.suspensionStiffness = suspensionStiffness;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withSuspensionStiffness(double suspensionStiffness) /*-{
		this.suspensionStiffness = suspensionStiffness;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getDampingCompression() /*-{
		return this.dampingCompression;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setDampingCompression(double dampingCompression) /*-{
		this.dampingCompression = dampingCompression;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withDampingCompression(double dampingCompression) /*-{
		this.dampingCompression = dampingCompression;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getDampingRelaxation() /*-{
		return this.dampingRelaxation;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setDampingRelaxation(double dampingRelaxation) /*-{
		this.dampingRelaxation = dampingRelaxation;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withDampingRelaxation(double dampingRelaxation) /*-{
		this.dampingRelaxation = dampingRelaxation;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getFrictionSlip() /*-{
		return this.frictionSlip;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setFrictionSlip(double frictionSlip) /*-{
		this.frictionSlip = frictionSlip;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withFrictionSlip(double frictionSlip) /*-{
		this.frictionSlip = frictionSlip;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getSteering() /*-{
		return this.steering;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setSteering(double steering) /*-{
		this.steering = steering;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withSteering(double steering) /*-{
		this.steering = steering;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getRotation() /*-{
		return this.rotation;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setRotation(double rotation) /*-{
		this.rotation = rotation;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withRotation(double rotation) /*-{
		this.rotation = rotation;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getDeltaRotation() /*-{
		return this.deltaRotation;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setDeltaRotation(double deltaRotation) /*-{
		this.deltaRotation = deltaRotation;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withDeltaRotation(double deltaRotation) /*-{
		this.deltaRotation = deltaRotation;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getRollInfluence() /*-{
		return this.rollInfluence;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setRollInfluence(double rollInfluence) /*-{
		this.rollInfluence = rollInfluence;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withRollInfluence(double rollInfluence) /*-{
		this.rollInfluence = rollInfluence;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getMaxSuspensionForce() /*-{
		return this.maxSuspensionForce;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setMaxSuspensionForce(double maxSuspensionForce) /*-{
		this.maxSuspensionForce = maxSuspensionForce;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withMaxSuspensionForce(double maxSuspensionForce) /*-{
		this.maxSuspensionForce = maxSuspensionForce;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native boolean isFrontWheel() /*-{
		return this.isFrontWheel;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setFrontWheel(boolean isFrontWheel) /*-{
		this.isFrontWheel = isFrontWheel;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withFrontWheel(boolean isFrontWheel) /*-{
		this.isFrontWheel = isFrontWheel;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getClippedInvContactDotSuspension() /*-{
		return this.clippedInvContactDotSuspension;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setClippedInvContactDotSuspension(double clippedInvContactDotSuspension) /*-{
		this.clippedInvContactDotSuspension = clippedInvContactDotSuspension;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withClippedInvContactDotSuspension(double clippedInvContactDotSuspension) /*-{
		this.clippedInvContactDotSuspension = clippedInvContactDotSuspension;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getSuspensionRelativeVelocity() /*-{
		return this.suspensionRelativeVelocity;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setSuspensionRelativeVelocity(double suspensionRelativeVelocity) /*-{
		this.suspensionRelativeVelocity = suspensionRelativeVelocity;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withSuspensionRelativeVelocity(double suspensionRelativeVelocity) /*-{
		this.suspensionRelativeVelocity = suspensionRelativeVelocity;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getSuspensionForce() /*-{
		return this.suspensionForce;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setSuspensionForce(double suspensionForce) /*-{
		this.suspensionForce = suspensionForce;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withSuspensionForce(double suspensionForce) /*-{
		this.suspensionForce = suspensionForce;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getSkidInfo() /*-{
		return this.skidInfo;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setSkidInfo(double skidInfo) /*-{
		this.skidInfo = skidInfo;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withSkidInfo(double skidInfo) /*-{
		this.skidInfo = skidInfo;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getSuspensionLength() /*-{
		return this.suspensionLength;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setSuspensionLength(double suspensionLength) /*-{
		this.suspensionLength = suspensionLength;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withSuspensionLength(double suspensionLength) /*-{
		this.suspensionLength = suspensionLength;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getMaxSuspensionTravel() /*-{
		return this.maxSuspensionTravel;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setMaxSuspensionTravel(double maxSuspensionTravel) /*-{
		this.maxSuspensionTravel = maxSuspensionTravel;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withMaxSuspensionTravel(double maxSuspensionTravel) /*-{
		this.maxSuspensionTravel = maxSuspensionTravel;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native boolean isUseCustomSlidingRotationalSpeed() /*-{
		return this.useCustomSlidingRotationalSpeed;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setUseCustomSlidingRotationalSpeed(boolean useCustomSlidingRotationalSpeed) /*-{
		this.useCustomSlidingRotationalSpeed = useCustomSlidingRotationalSpeed;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withUseCustomSlidingRotationalSpeed(boolean useCustomSlidingRotationalSpeed) /*-{
		this.useCustomSlidingRotationalSpeed = useCustomSlidingRotationalSpeed;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getCustomSlidingRotationalSpeed() /*-{
		return this.customSlidingRotationalSpeed;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setCustomSlidingRotationalSpeed(double customSlidingRotationalSpeed) /*-{
		this.customSlidingRotationalSpeed = customSlidingRotationalSpeed;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native WheelInfoOptions withCustomSlidingRotationalSpeed(double customSlidingRotationalSpeed) /*-{
		this.customSlidingRotationalSpeed = customSlidingRotationalSpeed;
		return this;
	}-*/;
	
}
