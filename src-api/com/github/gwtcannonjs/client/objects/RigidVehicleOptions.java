// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.objects;

import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JavaScriptObject;

public class RigidVehicleOptions extends JavaScriptObject {
	protected RigidVehicleOptions() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Optional.
	 */
	public final native Body getChassisBody() /*-{
		return this.chassisBody;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setChassisBody(Body chassisBody) /*-{
		this.chassisBody = chassisBody;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native RigidVehicleOptions withChassisBody(Body chassisBody) /*-{
		this.chassisBody = chassisBody;
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
	public final native RigidVehicleOptions withFrontWheel(boolean isFrontWheel) /*-{
		this.isFrontWheel = isFrontWheel;
		return this;
	}-*/;
	
	/**
	 * Position of the wheel, locally in the chassis body. Optional.
	 */
	public final native Vec3 getPosition() /*-{
		return this.position;
	}-*/;
	
	/**
	 * Position of the wheel, locally in the chassis body. Optional.
	 */
	public final native void setPosition(Vec3 position) /*-{
		this.position = position;
	}-*/;
	
	/**
	 * Position of the wheel, locally in the chassis body. Optional.
	 */
	public final native RigidVehicleOptions withPosition(Vec3 position) /*-{
		this.position = position;
		return this;
	}-*/;
	
	/**
	 * Slide direction of the wheel along the suspension. Optional.
	 */
	public final native Vec3 getDirection() /*-{
		return this.direction;
	}-*/;
	
	/**
	 * Slide direction of the wheel along the suspension. Optional.
	 */
	public final native void setDirection(Vec3 direction) /*-{
		this.direction = direction;
	}-*/;
	
	/**
	 * Slide direction of the wheel along the suspension. Optional.
	 */
	public final native RigidVehicleOptions withDirection(Vec3 direction) /*-{
		this.direction = direction;
		return this;
	}-*/;
	
	/**
	 * Axis of rotation of the wheel, locally defined in the chassis. Optional.
	 */
	public final native Vec3 getAxis() /*-{
		return this.axis;
	}-*/;
	
	/**
	 * Axis of rotation of the wheel, locally defined in the chassis. Optional.
	 */
	public final native void setAxis(Vec3 axis) /*-{
		this.axis = axis;
	}-*/;
	
	/**
	 * Axis of rotation of the wheel, locally defined in the chassis. Optional.
	 */
	public final native RigidVehicleOptions withAxis(Vec3 axis) /*-{
		this.axis = axis;
		return this;
	}-*/;
	
	/**
	 * The wheel body. Optional.
	 */
	public final native Body getBody() /*-{
		return this.body;
	}-*/;
	
	/**
	 * The wheel body. Optional.
	 */
	public final native void setBody(Body body) /*-{
		this.body = body;
	}-*/;
	
	/**
	 * The wheel body. Optional.
	 */
	public final native RigidVehicleOptions withBody(Body body) /*-{
		this.body = body;
		return this;
	}-*/;
	
}
