package com.github.gwtcannonjs.client.constraints;

import com.google.gwt.core.client.JavaScriptObject;

public class ConstraintOptions extends JavaScriptObject {
	protected ConstraintOptions() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Optional.
	 */
	public final native boolean isCollideConnected() /*-{
		return this.collideConnected;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setCollideConnected(boolean collideConnected) /*-{
		this.collideConnected = collideConnected;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native ConstraintOptions withCollideConnected(boolean collideConnected) /*-{
		this.collideConnected = collideConnected;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native boolean isWakeUpBodies() /*-{
		return this.wakeUpBodies;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setWakeUpBodies(boolean wakeUpBodies) /*-{
		this.wakeUpBodies = wakeUpBodies;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native ConstraintOptions withWakeUpBodies(boolean wakeUpBodies) /*-{
		this.wakeUpBodies = wakeUpBodies;
		return this;
	}-*/;
	
}
