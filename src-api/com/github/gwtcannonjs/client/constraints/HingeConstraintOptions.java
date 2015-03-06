// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.constraints;

import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JavaScriptObject;

public class HingeConstraintOptions extends JavaScriptObject {
	protected HingeConstraintOptions() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * A point defined locally in bodyA. This defines the offset of axisA. Optional.
	 */
	public final native Vec3 getPivotA() /*-{
		return this.pivotA;
	}-*/;
	
	/**
	 * A point defined locally in bodyA. This defines the offset of axisA. Optional.
	 */
	public final native void setPivotA(Vec3 pivotA) /*-{
		this.pivotA = pivotA;
	}-*/;
	
	/**
	 * A point defined locally in bodyA. This defines the offset of axisA. Optional.
	 */
	public final native HingeConstraintOptions withPivotA(Vec3 pivotA) /*-{
		this.pivotA = pivotA;
		return this;
	}-*/;
	
	/**
	 * an axis that bodyA can rotate around. Optional.
	 */
	public final native Vec3 getAxisA() /*-{
		return this.axisA;
	}-*/;
	
	/**
	 * an axis that bodyA can rotate around. Optional.
	 */
	public final native void setAxisA(Vec3 axisA) /*-{
		this.axisA = axisA;
	}-*/;
	
	/**
	 * an axis that bodyA can rotate around. Optional.
	 */
	public final native HingeConstraintOptions withAxisA(Vec3 axisA) /*-{
		this.axisA = axisA;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Vec3 getPivotB() /*-{
		return this.pivotB;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setPivotB(Vec3 pivotB) /*-{
		this.pivotB = pivotB;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native HingeConstraintOptions withPivotB(Vec3 pivotB) /*-{
		this.pivotB = pivotB;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Vec3 getAxisB() /*-{
		return this.axisB;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setAxisB(Vec3 axisB) /*-{
		this.axisB = axisB;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native HingeConstraintOptions withAxisB(Vec3 axisB) /*-{
		this.axisB = axisB;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getMaxForce() /*-{
		return this.maxForce;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setMaxForce(double maxForce) /*-{
		this.maxForce = maxForce;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native HingeConstraintOptions withMaxForce(double maxForce) /*-{
		this.maxForce = maxForce;
		return this;
	}-*/;
	
}
