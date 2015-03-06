// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.math;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Quaternion describes a rotation in 3D space. The Quaternion is mathematically defined as Q = x*i + y*j + z*k + w, where (i,j,k) are imaginary basis vectors. (x,y,z) can be seen as a vector related to the axis of rotation, while the real multiplier, w, is related to the amount of rotation.
 * @see http://en.wikipedia.org/wiki/Quaternion
 */
public class Quaternion extends JavaScriptObject {
	protected Quaternion() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native double getX() /*-{
		return this.x;
	}-*/;
	
	public final native void setX(double x) /*-{
		this.x = x;
	}-*/;
	
	public final native Quaternion withX(double x) /*-{
		this.x = x;
		return this;
	}-*/;
	
	public final native double getY() /*-{
		return this.y;
	}-*/;
	
	public final native void setY(double y) /*-{
		this.y = y;
	}-*/;
	
	public final native Quaternion withY(double y) /*-{
		this.y = y;
		return this;
	}-*/;
	
	public final native double getZ() /*-{
		return this.z;
	}-*/;
	
	public final native void setZ(double z) /*-{
		this.z = z;
	}-*/;
	
	public final native Quaternion withZ(double z) /*-{
		this.z = z;
		return this;
	}-*/;
	
	/**
	 * The multiplier of the real quaternion basis vector.
	 */
	public final native double getW() /*-{
		return this.w;
	}-*/;
	
	/**
	 * The multiplier of the real quaternion basis vector.
	 */
	public final native void setW(double w) /*-{
		this.w = w;
	}-*/;
	
	/**
	 * The multiplier of the real quaternion basis vector.
	 */
	public final native Quaternion withW(double w) /*-{
		this.w = w;
		return this;
	}-*/;
	
	/**
	 * Set the value of the quaternion.
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 */
	public final native void set(double x, double y, double z, double w) /*-{
		this.set(x, y, z, w);
	}-*/;
	
	/**
	 * Convert to a readable format
	 */
	public final native String toString_() /*-{
		return this.toString();
	}-*/;
	
	/**
	 * Convert to an Array
	 */
	public final native Double toArray() /*-{
		return this.toArray();
	}-*/;
	
	/**
	 * Set the quaternion components given an axis and an angle.
	 * @param axis
	 * @param angle in radians
	 */
	public final native void setFromAxisAngle(Vec3 axis, double angle) /*-{
		this.setFromAxisAngle(axis, angle);
	}-*/;
	
	/**
	 * Converts the quaternion to axis/angle representation.
	 * @param targetAxis Optional. A vector object to reuse for storing the axis.
	 * @return An array, first elemnt is the axis and the second is the angle in radians.
	 */
	public final native AxisAngle toAxisAngle(Vec3 targetAxis) /*-{
		return this.toAxisAngle(targetAxis);
	}-*/;
	
	/**
	 * Set the quaternion value given two vectors. The resulting rotation will be the needed rotation to rotate u to v.
	 * @param u
	 * @param v
	 */
	public final native void setFromVectors(Vec3 u, Vec3 v) /*-{
		this.setFromVectors(u, v);
	}-*/;
	
	/**
	 * Quaternion multiplication
	 * @param q
	 * @param target Optional.
	 */
	public final native Quaternion mult(Quaternion q, Quaternion target) /*-{
		return this.mult(q, target);
	}-*/;
	
	/**
	 * Get the inverse quaternion rotation.
	 * @param target
	 */
	public final native Quaternion inverse(Quaternion target) /*-{
		return this.inverse(target);
	}-*/;
	
	/**
	 * Get the quaternion conjugate
	 * @param target
	 */
	public final native Quaternion conjugate(Quaternion target) /*-{
		return this.conjugate(target);
	}-*/;
	
	/**
	 * Normalize the quaternion. Note that this changes the values of the quaternion.
	 */
	public final native void normalize() /*-{
		this.normalize();
	}-*/;
	
	/**
	 * Approximation of quaternion normalization. Works best when quat is already almost-normalized.
	 * @see http://jsperf.com/fast-quaternion-normalization
	 */
	public final native void normalizeFast() /*-{
		this.normalizeFast();
	}-*/;
	
	/**
	 * Multiply the quaternion by a vector
	 * @param v
	 * @param target Optional
	 */
	public final native Vec3 vmult(Vec3 v, Vec3 target) /*-{
		return this.vmult(v, target);
	}-*/;
	
	/**
	 * Copies value of source to this quaternion.
	 * @param source
	 * @return this
	 */
	public final native Quaternion copy(Quaternion source) /*-{
		return this.copy(source);
	}-*/;
	
	/**
	 * Convert the quaternion to euler angle representation. Order: YZX, as this page describes: http://www.euclideanspace.com/maths/standards/index.htm
	 * @param target
	 * @param order Three-character string e.g. "YZX", which also is default.
	 */
	public final native void toEuler(Vec3 target, String order) /*-{
		this.toEuler(target, order);
	}-*/;
	
	/**
	 * See http://www.mathworks.com/matlabcentral/fileexchange/20696-function-to-convert-between-dcm-euler-angles-quaternions-and-euler-vectors/content/SpinCalc.m
	 * @param x
	 * @param y
	 * @param z
	 * @param order The order to apply angles: 'XYZ' or 'YXZ' or any other combination
	 */
	public final native void setFromEuler(double x, double y, double z, String order) /*-{
		this.setFromEuler(x, y, z, order);
	}-*/;
	
}
