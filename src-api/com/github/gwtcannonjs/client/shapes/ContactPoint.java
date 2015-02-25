package com.github.gwtcannonjs.client.shapes;

import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JavaScriptObject;

public class ContactPoint extends JavaScriptObject {
	protected ContactPoint() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native Vec3 getPoint() /*-{
		return this.point;
	}-*/;
	
	public final native void setPoint(Vec3 point) /*-{
		this.point = point;
	}-*/;
	
	public final native ContactPoint withPoint(Vec3 point) /*-{
		this.point = point;
		return this;
	}-*/;
	
	public final native Vec3 getNormal() /*-{
		return this.normal;
	}-*/;
	
	public final native void setNormal(Vec3 normal) /*-{
		this.normal = normal;
	}-*/;
	
	public final native ContactPoint withNormal(Vec3 normal) /*-{
		this.normal = normal;
		return this;
	}-*/;
	
	public final native double getDepth() /*-{
		return this.depth;
	}-*/;
	
	public final native void setDepth(double depth) /*-{
		this.depth = depth;
	}-*/;
	
	public final native ContactPoint withDepth(double depth) /*-{
		this.depth = depth;
		return this;
	}-*/;
	
}
