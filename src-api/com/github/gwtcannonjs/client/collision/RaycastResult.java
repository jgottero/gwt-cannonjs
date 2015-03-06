// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.collision;

import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Storage for Ray casting data.
 */
public class RaycastResult extends JavaScriptObject {
	protected RaycastResult() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native Vec3 getRayFromWorld() /*-{
		return this.rayFromWorld;
	}-*/;
	
	public final native void setRayFromWorld(Vec3 rayFromWorld) /*-{
		this.rayFromWorld = rayFromWorld;
	}-*/;
	
	public final native RaycastResult withRayFromWorld(Vec3 rayFromWorld) /*-{
		this.rayFromWorld = rayFromWorld;
		return this;
	}-*/;
	
	public final native Vec3 getRayToWorld() /*-{
		return this.rayToWorld;
	}-*/;
	
	public final native void setRayToWorld(Vec3 rayToWorld) /*-{
		this.rayToWorld = rayToWorld;
	}-*/;
	
	public final native RaycastResult withRayToWorld(Vec3 rayToWorld) /*-{
		this.rayToWorld = rayToWorld;
		return this;
	}-*/;
	
	public final native Vec3 getHitNormalWorld() /*-{
		return this.hitNormalWorld;
	}-*/;
	
	public final native void setHitNormalWorld(Vec3 hitNormalWorld) /*-{
		this.hitNormalWorld = hitNormalWorld;
	}-*/;
	
	public final native RaycastResult withHitNormalWorld(Vec3 hitNormalWorld) /*-{
		this.hitNormalWorld = hitNormalWorld;
		return this;
	}-*/;
	
	public final native Vec3 getHitPointWorld() /*-{
		return this.hitPointWorld;
	}-*/;
	
	public final native void setHitPointWorld(Vec3 hitPointWorld) /*-{
		this.hitPointWorld = hitPointWorld;
	}-*/;
	
	public final native RaycastResult withHitPointWorld(Vec3 hitPointWorld) /*-{
		this.hitPointWorld = hitPointWorld;
		return this;
	}-*/;
	
	public final native boolean isHasHit() /*-{
		return this.hasHit;
	}-*/;
	
	public final native void setHasHit(boolean hasHit) /*-{
		this.hasHit = hasHit;
	}-*/;
	
	public final native RaycastResult withHasHit(boolean hasHit) /*-{
		this.hasHit = hasHit;
		return this;
	}-*/;
	
	/**
	 * The hit shape, or null.
	 */
	public final native Shape getShape() /*-{
		return this.shape;
	}-*/;
	
	/**
	 * The hit shape, or null.
	 */
	public final native void setShape(Shape shape) /*-{
		this.shape = shape;
	}-*/;
	
	/**
	 * The hit shape, or null.
	 */
	public final native RaycastResult withShape(Shape shape) /*-{
		this.shape = shape;
		return this;
	}-*/;
	
	/**
	 * The hit body, or null.
	 */
	public final native Body getBody() /*-{
		return this.body;
	}-*/;
	
	/**
	 * The hit body, or null.
	 */
	public final native void setBody(Body body) /*-{
		this.body = body;
	}-*/;
	
	/**
	 * The hit body, or null.
	 */
	public final native RaycastResult withBody(Body body) /*-{
		this.body = body;
		return this;
	}-*/;
	
	/**
	 * Distance to the hit. Will be set to -1 if there was no hit.
	 */
	public final native double getDistance() /*-{
		return this.distance;
	}-*/;
	
	/**
	 * Distance to the hit. Will be set to -1 if there was no hit.
	 */
	public final native void setDistance(double distance) /*-{
		this.distance = distance;
	}-*/;
	
	/**
	 * Distance to the hit. Will be set to -1 if there was no hit.
	 */
	public final native RaycastResult withDistance(double distance) /*-{
		this.distance = distance;
		return this;
	}-*/;
	
	/**
	 * Reset all result data.
	 */
	public final native void reset() /*-{
		this.reset();
	}-*/;
	
	/**
	 * @param rayFromWorld
	 * @param rayToWorld
	 * @param hitNormalWorld
	 * @param hitPointWorld
	 * @param shape
	 * @param body
	 * @param distance
	 */
	public final native void set(Vec3 rayFromWorld, Vec3 rayToWorld, Vec3 hitNormalWorld, Vec3 hitPointWorld, Shape shape, Body body, double distance) /*-{
		this.set(rayFromWorld, rayToWorld, hitNormalWorld, hitPointWorld, shape, body, distance);
	}-*/;
	
}
