package com.github.gwtcannonjs.client.math;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * 3-dimensional vector
 */
public class Vec3 extends JavaScriptObject {
	protected Vec3() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native double getX() /*-{
		return this.x;
	}-*/;
	
	public final native void setX(double x) /*-{
		this.x = x;
	}-*/;
	
	public final native Vec3 withX(double x) /*-{
		this.x = x;
		return this;
	}-*/;
	
	public final native double getY() /*-{
		return this.y;
	}-*/;
	
	public final native void setY(double y) /*-{
		this.y = y;
	}-*/;
	
	public final native Vec3 withY(double y) /*-{
		this.y = y;
		return this;
	}-*/;
	
	public final native double getZ() /*-{
		return this.z;
	}-*/;
	
	public final native void setZ(double z) /*-{
		this.z = z;
	}-*/;
	
	public final native Vec3 withZ(double z) /*-{
		this.z = z;
		return this;
	}-*/;
	
	/**
	 * Vector cross product
	 * @param v
	 * @param target Optional. Target to save in.
	 */
	public final native Vec3 cross(Vec3 v, Vec3 target) /*-{
		return this.cross(v, target);
	}-*/;
	
	/**
	 * Set the vectors' 3 elements
	 * @param x
	 * @param y
	 * @param z
	 */
	public final native Vec3 set(double x, double y, double z) /*-{
		return this.set(x, y, z);
	}-*/;
	
	/**
	 * Set all components of the vector to zero.
	 */
	public final native void setZero() /*-{
		this.setZero();
	}-*/;
	
	/**
	 * Vector addition
	 * @param v
	 * @param target Optional.
	 */
	public final native Vec3 vadd(Vec3 v, Vec3 target) /*-{
		return this.vadd(v, target);
	}-*/;
	
	/**
	 * Vector subtraction
	 * @param v
	 * @param target Optional. Target to save in.
	 */
	public final native Vec3 vsub(Vec3 v, Vec3 target) /*-{
		return this.vsub(v, target);
	}-*/;
	
	/**
	 * Get the cross product matrix a_cross from a vector, such that a x b = a_cross * b = c
	 * @see http://www8.cs.umu.se/kurser/TDBD24/VT06/lectures/Lecture6.pdf
	 */
	public final native Mat3 crossmat() /*-{
		return this.crossmat();
	}-*/;
	
	/**
	 * Normalize the vector. Note that this changes the values in the vector.
	 * @return Returns the norm of the vector
	 */
	public final native double normalize() /*-{
		return this.normalize();
	}-*/;
	
	/**
	 * Get the version of this vector that is of length 1.
	 * @param target Optional target to save in
	 * @return Returns the unit vector
	 */
	public final native Vec3 unit(Vec3 target) /*-{
		return this.unit(target);
	}-*/;
	
	/**
	 * Get the 2-norm (length) of the vector
	 */
	public final native double norm() /*-{
		return this.norm();
	}-*/;
	
	/**
	 * Get the squared length of the vector
	 */
	public final native double norm2() /*-{
		return this.norm2();
	}-*/;
	
	/**
	 * Get distance from this point to another point
	 * @param p
	 */
	public final native double distanceTo(Vec3 p) /*-{
		return this.distanceTo(p);
	}-*/;
	
	/**
	 * Multiply the vector with a scalar
	 * @param scalar
	 * @param target
	 * @deprecated Use .scale instead
	 */
	@Deprecated
	public final native Vec3 mult(double scalar, Vec3 target) /*-{
		return this.mult(scalar, target);
	}-*/;
	
	/**
	 * Multiply the vector with a scalar.
	 * @param scalar
	 * @param target
	 */
	public final native Vec3 scale(double scalar, Vec3 target) /*-{
		return this.scale(scalar, target);
	}-*/;
	
	/**
	 * Calculate dot product
	 * @param v
	 */
	public final native double dot(Vec3 v) /*-{
		return this.dot(v);
	}-*/;
	
	public final native boolean isZero() /*-{
		return this.isZero();
	}-*/;
	
	/**
	 * Make the vector point in the opposite direction.
	 * @param target Optional target to save in
	 */
	public final native Vec3 negate(Vec3 target) /*-{
		return this.negate(target);
	}-*/;
	
	/**
	 * Compute two artificial tangents to the vector
	 * @param t1 Vector object to save the first tangent in
	 * @param t2 Vector object to save the second tangent in
	 */
	public final native void tangents(Vec3 t1, Vec3 t2) /*-{
		this.tangents(t1, t2);
	}-*/;
	
	/**
	 * Converts to a more readable format
	 */
	public final native String toString_() /*-{
		return this.toString();
	}-*/;
	
	/**
	 * Converts to an array
	 */
	public final native JsArray<Vec3> toArray() /*-{
		return this.toArray();
	}-*/;
	
	/**
	 * Copies value of source to this vector.
	 * @param source
	 * @return this
	 */
	public final native Vec3 copy(Vec3 source) /*-{
		return this.copy(source);
	}-*/;
	
	/**
	 * Do a linear interpolation between two vectors
	 * @param v
	 * @param t A number between 0 and 1. 0 will make this function return u, and 1 will make it return v. Numbers in between will generate a vector in between them.
	 * @param target
	 */
	public final native void lerp(Vec3 v, double t, Vec3 target) /*-{
		this.lerp(v, t, target);
	}-*/;
	
	/**
	 * Check if a vector equals is almost equal to another one.
	 * @param v
	 * @param precision
	 */
	public final native boolean almostEquals(Vec3 v, double precision) /*-{
		return this.almostEquals(v, precision);
	}-*/;
	
	/**
	 * Check if a vector is almost zero
	 * @param precision
	 */
	public final native void almostZero(double precision) /*-{
		this.almostZero(precision);
	}-*/;
	
	/**
	 * Check if the vector is anti-parallel to another vector.
	 * @param v
	 * @param precision Set to zero for exact comparisons
	 */
	public final native boolean isAntiparallelTo(Vec3 v, double precision) /*-{
		return this.isAntiparallelTo(v, precision);
	}-*/;
	
	/**
	 * Clone the vector
	 */
	public final native Vec3 clone_() /*-{
		return this.clone();
	}-*/;
	
}
