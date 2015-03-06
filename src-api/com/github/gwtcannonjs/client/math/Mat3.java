// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.math;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * A 3x3 matrix.
 */
public class Mat3 extends JavaScriptObject {
	protected Mat3() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * A vector of length 9, containing all matrix elements
	 */
	public final native JsArrayNumber getElements() /*-{
		return this.elements;
	}-*/;
	
	/**
	 * A vector of length 9, containing all matrix elements
	 */
	public final native void setElements(JsArrayNumber elements) /*-{
		this.elements = elements;
	}-*/;
	
	/**
	 * A vector of length 9, containing all matrix elements
	 */
	public final native Mat3 withElements(JsArrayNumber elements) /*-{
		this.elements = elements;
		return this;
	}-*/;
	
	/**
	 * Sets the matrix to identity
	 */
	public final native void identity() /*-{
		this.identity();
	}-*/;
	
	/**
	 * Set all elements to zero
	 */
	public final native void setZero() /*-{
		this.setZero();
	}-*/;
	
	/**
	 * Sets the matrix diagonal elements from a Vec3
	 * @param vec3
	 */
	public final native void setTrace(Vec3 vec3) /*-{
		this.setTrace(vec3);
	}-*/;
	
	/**
	 * Gets the matrix diagonal elements
	 */
	public final native Vec3 getTrace() /*-{
		return this.getTrace();
	}-*/;
	
	/**
	 * Matrix-Vector multiplication
	 * @param v The vector to multiply with
	 * @param target Optional, target to save the result in.
	 */
	public final native void vmult(Vec3 v, Vec3 target) /*-{
		this.vmult(v, target);
	}-*/;
	
	/**
	 * Matrix-scalar multiplication
	 * @param s
	 */
	public final native void smult(double s) /*-{
		this.smult(s);
	}-*/;
	
	/**
	 * Matrix multiplication
	 * @param m Matrix to multiply with from left side.
	 * @return The result.
	 */
	public final native Mat3 mmult(Mat3 m) /*-{
		return this.mmult(m);
	}-*/;
	
	/**
	 * Scale each column of the matrix
	 * @param v
	 * @return The result.
	 */
	public final native Mat3 scale(Vec3 v) /*-{
		return this.scale(v);
	}-*/;
	
	/**
	 * Solve Ax=b
	 * @param b The right hand side
	 * @param target Optional. Target vector to save in.
	 * @return The solution x
	 */
	public final native Vec3 solve(Vec3 b, Vec3 target) /*-{
		return this.solve(b, target);
	}-*/;
	
	/**
	 * Get an element in the matrix by index. Index starts at 0, not 1!!!
	 * @param row
	 * @param column
	 * @param value Optional. If provided, the matrix element will be set to this value.
	 */
	public final native double e(double row, double column, double value) /*-{
		return this.e(row, column, value);
	}-*/;
	
	/**
	 * Copy another matrix into this matrix object.
	 * @param source
	 * @return this
	 */
	public final native Mat3 copy(Mat3 source) /*-{
		return this.copy(source);
	}-*/;
	
	/**
	 * Returns a string representation of the matrix.
	 */
	public final native String toString_() /*-{
		return this.toString();
	}-*/;
	
	/**
	 * reverse the matrix
	 * @param target Optional. Target matrix to save in.
	 * @return The solution x
	 */
	public final native Mat3 reverse(Mat3 target) /*-{
		return this.reverse(target);
	}-*/;
	
	/**
	 * Set the matrix from a quaterion
	 * @param q
	 */
	public final native void setRotationFromQuaternion(Quaternion q) /*-{
		this.setRotationFromQuaternion(q);
	}-*/;
	
	/**
	 * Transpose the matrix
	 * @param target Where to store the result.
	 * @return The target Mat3, or a new Mat3 if target was omitted.
	 */
	public final native Mat3 transpose(Mat3 target) /*-{
		return this.transpose(target);
	}-*/;
	
}
