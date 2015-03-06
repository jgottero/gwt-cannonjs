// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.equations;

/**
 * Rotational motor constraint. Works to keep the relative angular velocity of the bodies to a given value
 */
public class RotationalMotorEquation extends Equation {
	protected RotationalMotorEquation() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Motor velocity
	 */
	public final native double getTargetVelocity() /*-{
		return this.targetVelocity;
	}-*/;
	
	/**
	 * Motor velocity
	 */
	public final native void setTargetVelocity(double targetVelocity) /*-{
		this.targetVelocity = targetVelocity;
	}-*/;
	
	/**
	 * Motor velocity
	 */
	public final native RotationalMotorEquation withTargetVelocity(double targetVelocity) /*-{
		this.targetVelocity = targetVelocity;
		return this;
	}-*/;
	
}
