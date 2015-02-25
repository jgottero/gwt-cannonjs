package com.github.gwtcannonjs.client.collision;

import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.world.World;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Base class for broadphase implementations
 */
public class Broadphase extends JavaScriptObject {
	protected Broadphase() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * The world to search for collisions in.
	 */
	public final native World getWorld() /*-{
		return this.world;
	}-*/;
	
	/**
	 * The world to search for collisions in.
	 */
	public final native Broadphase withWorld(World world) /*-{
		this.world = world;
		return this;
	}-*/;
	
	/**
	 * If set to true, the broadphase uses bounding boxes for intersection test, else it uses bounding spheres.
	 */
	public final native boolean isUseBoundingBoxes() /*-{
		return this.useBoundingBoxes;
	}-*/;
	
	/**
	 * If set to true, the broadphase uses bounding boxes for intersection test, else it uses bounding spheres.
	 */
	public final native void setUseBoundingBoxes(boolean useBoundingBoxes) /*-{
		this.useBoundingBoxes = useBoundingBoxes;
	}-*/;
	
	/**
	 * If set to true, the broadphase uses bounding boxes for intersection test, else it uses bounding spheres.
	 */
	public final native Broadphase withUseBoundingBoxes(boolean useBoundingBoxes) /*-{
		this.useBoundingBoxes = useBoundingBoxes;
		return this;
	}-*/;
	
	/**
	 * Set to true if the objects in the world moved.
	 */
	public final native boolean isDirty() /*-{
		return this.dirty;
	}-*/;
	
	/**
	 * Set to true if the objects in the world moved.
	 */
	public final native void setDirty(boolean dirty) /*-{
		this.dirty = dirty;
	}-*/;
	
	/**
	 * Set to true if the objects in the world moved.
	 */
	public final native Broadphase withDirty(boolean dirty) /*-{
		this.dirty = dirty;
		return this;
	}-*/;
	
	/**
	 * Get the collision pairs from the world
	 * @param world The world to search in
	 * @param p1 Empty array to be filled with body objects
	 * @param p2 Empty array to be filled with body objects
	 */
	public final native void collisionPairs(World world, JsArray<Body> p1, JsArray<Body> p2) /*-{
		this.collisionPairs(world, p1, p2);
	}-*/;
	
	/**
	 * Check if a body pair needs to be intersection tested at all.
	 * @param bodyA
	 * @param bodyB
	 */
	public final native boolean needBroadphaseCollision(Body bodyA, Body bodyB) /*-{
		return this.needBroadphaseCollision(bodyA, bodyB);
	}-*/;
	
	/**
	 * Check if the bounding volumes of two bodies intersect.
	 * @param bodyA
	 * @param bodyB
	 * @param pairs1
	 * @param pairs2
	 */
	public final native void intersectionTest(Body bodyA, Body bodyB, JsArray<Body> pairs1, JsArray<Body> pairs2) /*-{
		this.intersectionTest(bodyA, bodyB, pairs1, pairs2);
	}-*/;
	
	/**
	 * Check if the bounding spheres of two bodies are intersecting.
	 * @param bodyA
	 * @param bodyB
	 * @param pairs1 bodyA is appended to this array if intersection
	 * @param pairs2 bodyB is appended to this array if intersection
	 */
	public final native void doBoundingSphereBroadphase(Body bodyA, Body bodyB, JsArray<Body> pairs1, JsArray<Body> pairs2) /*-{
		this.doBoundingSphereBroadphase(bodyA, bodyB, pairs1, pairs2);
	}-*/;
	
	/**
	 * Check if the bounding boxes of two bodies are intersecting.
	 * @param bodyA
	 * @param bodyB
	 * @param pairs1
	 * @param pairs2
	 */
	public final native void doBoundingBoxBroadphase(Body bodyA, Body bodyB, JsArray<Body> pairs1, JsArray<Body> pairs2) /*-{
		this.doBoundingBoxBroadphase(bodyA, bodyB, pairs1, pairs2);
	}-*/;
	
	/**
	 * Removes duplicate pairs from the pair arrays.
	 * @param pairs1
	 * @param pairs2
	 */
	public final native void makePairsUnique(JsArray<Body> pairs1, JsArray<Body> pairs2) /*-{
		this.makePairsUnique(pairs1, pairs2);
	}-*/;
	
	/**
	 * To be implemented by subcasses
	 * @param world
	 */
	public final native void setWorld(World world) /*-{
		this.setWorld(world);
	}-*/;
	
	/**
	 * Check if the bounding spheres of two bodies overlap.
	 * @param bodyA
	 * @param bodyB
	 */
	public final native boolean boundingSphereCheck(Body bodyA, Body bodyB) /*-{
		return this.boundingSphereCheck(bodyA, bodyB);
	}-*/;
	
	/**
	 * Returns all the bodies within the AABB.
	 * @param world
	 * @param aabb
	 * @param result An array to store resulting bodies in.
	 */
	public final native JsArray<Body> aabbQuery(World world, AABB aabb, JsArray<Body> result) /*-{
		return this.aabbQuery(world, aabb, result);
	}-*/;
	
}
