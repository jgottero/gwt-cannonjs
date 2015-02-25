package com.github.gwtcannonjs.client.shapes;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * Heightfield shape class. Height data is given as an array. These data points are spread out evenly with a given distance.
 */
public class Heightfield extends Shape {
	protected Heightfield() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * An array of numbers, or height values, that are spread out along the x axis.
	 */
	public final native JsArray<JsArrayNumber> getData() /*-{
		return this.data;
	}-*/;
	
	/**
	 * An array of numbers, or height values, that are spread out along the x axis.
	 */
	public final native void setData(JsArray<JsArrayNumber> data) /*-{
		this.data = data;
	}-*/;
	
	/**
	 * An array of numbers, or height values, that are spread out along the x axis.
	 */
	public final native Heightfield withData(JsArray<JsArrayNumber> data) /*-{
		this.data = data;
		return this;
	}-*/;
	
	/**
	 * Max value of the data
	 */
	public final native double getMaxValue() /*-{
		return this.maxValue;
	}-*/;
	
	/**
	 * Max value of the data
	 */
	public final native void setMaxValue(double maxValue) /*-{
		this.maxValue = maxValue;
	}-*/;
	
	/**
	 * Max value of the data
	 */
	public final native Heightfield withMaxValue(double maxValue) /*-{
		this.maxValue = maxValue;
		return this;
	}-*/;
	
	/**
	 * Max value of the data
	 */
	public final native double getMinValue() /*-{
		return this.minValue;
	}-*/;
	
	/**
	 * Max value of the data
	 */
	public final native void setMinValue(double minValue) /*-{
		this.minValue = minValue;
	}-*/;
	
	/**
	 * Max value of the data
	 */
	public final native Heightfield withMinValue(double minValue) /*-{
		this.minValue = minValue;
		return this;
	}-*/;
	
	/**
	 * The width of each element
	 */
	public final native double getElementSize() /*-{
		return this.elementSize;
	}-*/;
	
	/**
	 * The width of each element
	 */
	public final native void setElementSize(double elementSize) /*-{
		this.elementSize = elementSize;
	}-*/;
	
	/**
	 * The width of each element
	 */
	public final native Heightfield withElementSize(double elementSize) /*-{
		this.elementSize = elementSize;
		return this;
	}-*/;
	
	/**
	 * Call whenever you change the data array.
	 */
	public final native void update() /*-{
		this.update();
	}-*/;
	
	/**
	 * Update the .minValue property
	 */
	public final native void updateMinValue() /*-{
		this.updateMinValue();
	}-*/;
	
	/**
	 * Update the .maxValue property
	 */
	public final native void updateMaxValue() /*-{
		this.updateMaxValue();
	}-*/;
	
	/**
	 * Set the height value at an index. Don't forget to update maxValue and minValue after you're done.
	 * @param xi
	 * @param yi
	 * @param value
	 */
	public final native void setHeightValueAtIndex(int xi, int yi, double value) /*-{
		this.setHeightValueAtIndex(xi, yi, value);
	}-*/;
	
	/**
	 * Get max/min in a rectangle in the matrix data
	 * @param iMinX
	 * @param iMinY
	 * @param iMaxX
	 * @param iMaxY
	 * @param result An array to store the results in. Optional.
	 * @return The result array, if it was passed in. Minimum will be at position 0 and max at 1.
	 */
	public final native JsArrayNumber getRectMinMax(int iMinX, int iMinY, int iMaxX, int iMaxY, JsArrayNumber result) /*-{
		return this.getRectMinMax(iMinX, iMinY, iMaxX, iMaxY, result);
	}-*/;
	
	/**
	 * Get the index of a local position on the heightfield. The indexes indicate the rectangles, so if your terrain is made of N x N height data points, you will have rectangle indexes ranging from 0 to N-1.
	 * @param x
	 * @param y
	 * @param result Two-element array
	 * @param clamp If the position should be clamped to the heightfield edge.
	 */
	public final native boolean getIndexOfPosition(double x, double y, JsArrayInteger result, boolean clamp) /*-{
		return this.getIndexOfPosition(x, y, result, clamp);
	}-*/;
	
	/**
	 * Get a triangle in the terrain in the form of a triangular convex shape.
	 * @param i
	 * @param j
	 * @param getUpperTriangle
	 */
	public final native void getConvexTrianglePillar(int i, int j, boolean getUpperTriangle) /*-{
		this.getConvexTrianglePillar(i, j, getUpperTriangle);
	}-*/;
	
}
