package com.github.gwtcannonjs.client.shapes;

import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Base class for shapes
 */
public class Shape extends JavaScriptObject {
	public static int SPHERE;
	
	public static int PLANE;
	
	public static int BOX;
	
	public static int COMPOUND;
	
	public static int CONVEXPOLYHEDRON;
	
	public static int HEIGHTFIELD;
	
	public static int PARTICLE;
	
	public static int CYLINDER;
	
	protected Shape() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * The type of this shape. Must be set to an int > 0 by subclasses.
	 * @see Shape.types
	 */
	public final native double getType() /*-{
		return this.type;
	}-*/;
	
	/**
	 * The type of this shape. Must be set to an int > 0 by subclasses.
	 * @see Shape.types
	 */
	public final native void setType(double type) /*-{
		this.type = type;
	}-*/;
	
	/**
	 * The type of this shape. Must be set to an int > 0 by subclasses.
	 * @see Shape.types
	 */
	public final native Shape withType(double type) /*-{
		this.type = type;
		return this;
	}-*/;
	
	/**
	 * The local bounding sphere radius of this shape.
	 */
	public final native double getBoundingSphereRadius() /*-{
		return this.boundingSphereRadius;
	}-*/;
	
	/**
	 * The local bounding sphere radius of this shape.
	 */
	public final native void setBoundingSphereRadius(double boundingSphereRadius) /*-{
		this.boundingSphereRadius = boundingSphereRadius;
	}-*/;
	
	/**
	 * The local bounding sphere radius of this shape.
	 */
	public final native Shape withBoundingSphereRadius(double boundingSphereRadius) /*-{
		this.boundingSphereRadius = boundingSphereRadius;
		return this;
	}-*/;
	
	/**
	 * Whether to produce contact forces when in contact with other bodies. Note that contacts will be generated, but they will be disabled.
	 */
	public final native boolean isCollisionResponse() /*-{
		return this.collisionResponse;
	}-*/;
	
	/**
	 * Whether to produce contact forces when in contact with other bodies. Note that contacts will be generated, but they will be disabled.
	 */
	public final native void setCollisionResponse(boolean collisionResponse) /*-{
		this.collisionResponse = collisionResponse;
	}-*/;
	
	/**
	 * Whether to produce contact forces when in contact with other bodies. Note that contacts will be generated, but they will be disabled.
	 */
	public final native Shape withCollisionResponse(boolean collisionResponse) /*-{
		this.collisionResponse = collisionResponse;
		return this;
	}-*/;
	
	/**
	 * Computes the bounding sphere radius. The result is stored in the property .boundingSphereRadius
	 */
	public final native double updateBoundingSphereRadius() /*-{
		return this.updateBoundingSphereRadius();
	}-*/;
	
	/**
	 * Get the volume of this shape
	 */
	public final native double volume() /*-{
		return this.volume();
	}-*/;
	
	/**
	 * Calculates the inertia in the local frame for this shape.
	 * @see http://en.wikipedia.org/wiki/List_of_moments_of_inertia
	 */
	public final native Vec3 calculateLocalInertia() /*-{
		return this.calculateLocalInertia();
	}-*/;
	
	private static native void initializeConstants() /*-{
		@com.github.gwtcannonjs.client.shapes.Shape::SPHERE = $wnd.CANNON.Shape.SPHERE;
		@com.github.gwtcannonjs.client.shapes.Shape::PLANE = $wnd.CANNON.Shape.PLANE;
		@com.github.gwtcannonjs.client.shapes.Shape::BOX = $wnd.CANNON.Shape.BOX;
		@com.github.gwtcannonjs.client.shapes.Shape::COMPOUND = $wnd.CANNON.Shape.COMPOUND;
		@com.github.gwtcannonjs.client.shapes.Shape::CONVEXPOLYHEDRON = $wnd.CANNON.Shape.CONVEXPOLYHEDRON;
		@com.github.gwtcannonjs.client.shapes.Shape::HEIGHTFIELD = $wnd.CANNON.Shape.HEIGHTFIELD;
		@com.github.gwtcannonjs.client.shapes.Shape::PARTICLE = $wnd.CANNON.Shape.PARTICLE;
		@com.github.gwtcannonjs.client.shapes.Shape::CYLINDER = $wnd.CANNON.Shape.CYLINDER;
	}-*/;
	
	static {
		initializeConstants();
	}
}
