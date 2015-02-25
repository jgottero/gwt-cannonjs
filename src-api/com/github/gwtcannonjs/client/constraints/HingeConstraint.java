package com.github.gwtcannonjs.client.constraints;

/**
 * Hinge constraint. Tries to keep the local body axes equal.
 */
public class HingeConstraint extends Constraint {
	protected HingeConstraint() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native void enableMotor() /*-{
		this.enableMotor();
	}-*/;
	
	public final native void disableMotor() /*-{
		this.disableMotor();
	}-*/;
	
}
