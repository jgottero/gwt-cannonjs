package com.github.gwtcannonjs.client.shapes;

import com.github.gwtcannonjs.client.math.Quaternion;
import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JsArray;

/**
 * A 3d box shape.
 */
public class Box extends Shape {
	protected Box() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native Vec3 getHalfExtents() /*-{
		return this.halfExtents;
	}-*/;
	
	public final native void setHalfExtents(Vec3 halfExtents) /*-{
		this.halfExtents = halfExtents;
	}-*/;
	
	public final native Box withHalfExtents(Vec3 halfExtents) /*-{
		this.halfExtents = halfExtents;
		return this;
	}-*/;
	
	/**
	 * Used by the contact generator to make contacts with other convex polyhedra for example
	 */
	public final native ConvexPolyhedron getConvexPolyhedronRepresentation() /*-{
		return this.convexPolyhedronRepresentation;
	}-*/;
	
	/**
	 * Used by the contact generator to make contacts with other convex polyhedra for example
	 */
	public final native void setConvexPolyhedronRepresentation(ConvexPolyhedron convexPolyhedronRepresentation) /*-{
		this.convexPolyhedronRepresentation = convexPolyhedronRepresentation;
	}-*/;
	
	/**
	 * Used by the contact generator to make contacts with other convex polyhedra for example
	 */
	public final native Box withConvexPolyhedronRepresentation(ConvexPolyhedron convexPolyhedronRepresentation) /*-{
		this.convexPolyhedronRepresentation = convexPolyhedronRepresentation;
		return this;
	}-*/;
	
	/**
	 * Updates the local convex polyhedron representation used for some collisions.
	 */
	public final native void updateConvexPolyhedronRepresentation() /*-{
		this.updateConvexPolyhedronRepresentation();
	}-*/;
	
	/**
	 * @param mass
	 * @param target
	 */
	public final native Vec3 calculateLocalInertia(double mass, Vec3 target) /*-{
		return this.calculateLocalInertia(mass, target);
	}-*/;
	
	/**
	 * Get the box 6 side normals
	 * @param sixTargetVectors An array of 6 vectors.
	 * @param quat Orientation to apply to the normal vectors. If not provided, the vectors will be in respect to the local frame.
	 */
	public final native JsArray<Vec3> getSideNormals(JsArray<Vec3> sixTargetVectors, Quaternion quat) /*-{
		return this.getSideNormals(sixTargetVectors, quat);
	}-*/;
	
}
