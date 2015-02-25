package com.github.gwtcannonjs.client.collision;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * Collision "matrix". It's actually a triangular-shaped array of whether two bodies are touching this step, for reference next step
 */
public class ArrayCollisionMatrix extends JavaScriptObject {
	protected ArrayCollisionMatrix() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * The matrix storage
	 */
	public final native JsArrayNumber getMatrix() /*-{
		return this.matrix;
	}-*/;
	
	/**
	 * The matrix storage
	 */
	public final native void setMatrix(JsArrayNumber matrix) /*-{
		this.matrix = matrix;
	}-*/;
	
	/**
	 * The matrix storage
	 */
	public final native ArrayCollisionMatrix withMatrix(JsArrayNumber matrix) /*-{
		this.matrix = matrix;
		return this;
	}-*/;
	
	/**
	 * Get an element
	 * @param i
	 * @param j
	 */
	public final native double get(double i, double j) /*-{
		return this.get(i, j);
	}-*/;
	
	/**
	 * Set an element
	 * @param i
	 * @param j
	 * @param value
	 */
	public final native void set(double i, double j, double value) /*-{
		this.set(i, j, value);
	}-*/;
	
	/**
	 * Sets all elements to zero
	 */
	public final native void reset() /*-{
		this.reset();
	}-*/;
	
	/**
	 * Sets the max number of objects
	 * @param n
	 */
	public final native void setNumObjects(double n) /*-{
		this.setNumObjects(n);
	}-*/;
	
}
