// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.collision;

import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * A line in 3D space that intersects bodies and return points.
 */
public class Ray extends JavaScriptObject {
	protected Ray() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native Vec3 getFrom() /*-{
		return this.from;
	}-*/;
	
	public final native void setFrom(Vec3 from) /*-{
		this.from = from;
	}-*/;
	
	public final native Ray withFrom(Vec3 from) /*-{
		this.from = from;
		return this;
	}-*/;
	
	public final native Vec3 getTo() /*-{
		return this.to;
	}-*/;
	
	public final native void setTo(Vec3 to) /*-{
		this.to = to;
	}-*/;
	
	public final native Ray withTo(Vec3 to) /*-{
		this.to = to;
		return this;
	}-*/;
	
	/**
	 * The precision of the ray. Used when checking parallelity etc.
	 */
	public final native double getPrecision() /*-{
		return this.precision;
	}-*/;
	
	/**
	 * The precision of the ray. Used when checking parallelity etc.
	 */
	public final native void setPrecision(double precision) /*-{
		this.precision = precision;
	}-*/;
	
	/**
	 * The precision of the ray. Used when checking parallelity etc.
	 */
	public final native Ray withPrecision(double precision) /*-{
		this.precision = precision;
		return this;
	}-*/;
	
	/**
	 * Set to true if you want the Ray to take .collisionResponse flags into account on bodies and shapes.
	 */
	public final native boolean isCheckCollisionResponse() /*-{
		return this.checkCollisionResponse;
	}-*/;
	
	/**
	 * Set to true if you want the Ray to take .collisionResponse flags into account on bodies and shapes.
	 */
	public final native void setCheckCollisionResponse(boolean checkCollisionResponse) /*-{
		this.checkCollisionResponse = checkCollisionResponse;
	}-*/;
	
	/**
	 * Set to true if you want the Ray to take .collisionResponse flags into account on bodies and shapes.
	 */
	public final native Ray withCheckCollisionResponse(boolean checkCollisionResponse) /*-{
		this.checkCollisionResponse = checkCollisionResponse;
		return this;
	}-*/;
	
	/**
	 * @param bodies An array of Body objects.
	 * @param result
	 */
	public final native void intersectBodies(JsArray<Body> bodies, RaycastResult result) /*-{
		this.intersectBodies(bodies, result);
	}-*/;
	
	/**
	 * Get the AABB of the ray.
	 * @param aabb
	 */
	public final native void getAABB(AABB aabb) /*-{
		this.getAABB(aabb);
	}-*/;
	
}
