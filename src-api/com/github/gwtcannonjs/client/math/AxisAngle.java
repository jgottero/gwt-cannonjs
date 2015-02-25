package com.github.gwtcannonjs.client.math;

import com.google.gwt.core.client.JavaScriptObject;

public class AxisAngle extends JavaScriptObject {
	protected AxisAngle() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native Vec3 getAxis() /*-{
		return this[0];
	}-*/;
	
	public final native void setAxis(Vec3 axis) /*-{
		this[0] = axis;
	}-*/;
	
	public final native AxisAngle withAxis(Vec3 axis) /*-{
		this[0] = axis;
		return this;
	}-*/;
	
	public final native double getAngle() /*-{
		return this[1];
	}-*/;
	
	public final native void setAngle(double angle) /*-{
		this[1] = angle;
	}-*/;
	
	public final native AxisAngle withAngle(double angle) /*-{
		this[1] = angle;
		return this;
	}-*/;
	
}
