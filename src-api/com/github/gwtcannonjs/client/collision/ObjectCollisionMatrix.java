// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.collision;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Records what objects are colliding with each other
 */
public class ObjectCollisionMatrix extends JavaScriptObject {
	protected ObjectCollisionMatrix() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * The matrix storage
	 */
	public final native JavaScriptObject getMatrix() /*-{
		return this.matrix;
	}-*/;
	
	/**
	 * The matrix storage
	 */
	public final native void setMatrix(JavaScriptObject matrix) /*-{
		this.matrix = matrix;
	}-*/;
	
	/**
	 * The matrix storage
	 */
	public final native ObjectCollisionMatrix withMatrix(JavaScriptObject matrix) /*-{
		this.matrix = matrix;
		return this;
	}-*/;
	
	/**
	 * @param i
	 * @param j
	 */
	public final native double get(double i, double j) /*-{
		return this.get(i, j);
	}-*/;
	
	/**
	 * @param i
	 * @param j
	 * @param value
	 */
	public final native void set(double i, double j, double value) /*-{
		this.set(i, j, value);
	}-*/;
	
	/**
	 * Empty the matrix
	 */
	public final native void reset() /*-{
		this.reset();
	}-*/;
	
	/**
	 * Set max number of objects
	 * @param n
	 */
	public final native void setNumObjects(double n) /*-{
		this.setNumObjects(n);
	}-*/;
	
}
