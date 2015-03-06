// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.constraints;

/**
 * Hinge constraint. Tries to keep the local body axes equal.
 */
public class HingeConstraint extends Constraint {
	protected HingeConstraint() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Motor velocity.
	 */
	public final native double getMotorTargetVelocity() /*-{
		return this.motorTargetVelocity;
	}-*/;
	
	/**
	 * Motor velocity.
	 */
	public final native void setMotorTargetVelocity(double motorTargetVelocity) /*-{
		this.motorTargetVelocity = motorTargetVelocity;
	}-*/;
	
	/**
	 * Motor velocity.
	 */
	public final native HingeConstraint withMotorTargetVelocity(double motorTargetVelocity) /*-{
		this.motorTargetVelocity = motorTargetVelocity;
		return this;
	}-*/;
	
	public final native void enableMotor() /*-{
		this.enableMotor();
	}-*/;
	
	public final native void disableMotor() /*-{
		this.disableMotor();
	}-*/;
	
}
