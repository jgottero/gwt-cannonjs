// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.collision;

import com.github.gwtcannonjs.client.math.Quaternion;
import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Axis aligned bounding box class.
 */
public class AABB extends JavaScriptObject {
	protected AABB() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * The lower bound of the bounding box.
	 */
	public final native Vec3 getLowerBound() /*-{
		return this.lowerBound;
	}-*/;
	
	/**
	 * The lower bound of the bounding box.
	 */
	public final native void setLowerBound(Vec3 lowerBound) /*-{
		this.lowerBound = lowerBound;
	}-*/;
	
	/**
	 * The lower bound of the bounding box.
	 */
	public final native AABB withLowerBound(Vec3 lowerBound) /*-{
		this.lowerBound = lowerBound;
		return this;
	}-*/;
	
	/**
	 * The upper bound of the bounding box.
	 */
	public final native Vec3 getUpperBound() /*-{
		return this.upperBound;
	}-*/;
	
	/**
	 * The upper bound of the bounding box.
	 */
	public final native void setUpperBound(Vec3 upperBound) /*-{
		this.upperBound = upperBound;
	}-*/;
	
	/**
	 * The upper bound of the bounding box.
	 */
	public final native AABB withUpperBound(Vec3 upperBound) /*-{
		this.upperBound = upperBound;
		return this;
	}-*/;
	
	/**
	 * Set the AABB bounds from a set of points.
	 * @param points An array of Vec3's.
	 * @param position
	 * @param quaternion
	 * @param skinSize
	 */
	public final native void setFromPoints(JsArray<Vec3> points, Vec3 position, Quaternion quaternion, double skinSize) /*-{
		this.setFromPoints(points, position, quaternion, skinSize);
	}-*/;
	
	/**
	 * Copy bounds from an AABB to this AABB
	 * @param aabb Source to copy from
	 */
	public final native void copy(AABB aabb) /*-{
		this.copy(aabb);
	}-*/;
	
	/**
	 * Extend this AABB so that it covers the given AABB too.
	 * @param aabb
	 */
	public final native void extend(AABB aabb) /*-{
		this.extend(aabb);
	}-*/;
	
	/**
	 * Returns true if the given AABB overlaps this AABB.
	 * @param aabb
	 */
	public final native boolean overlaps(AABB aabb) /*-{
		return this.overlaps(aabb);
	}-*/;
	
}
