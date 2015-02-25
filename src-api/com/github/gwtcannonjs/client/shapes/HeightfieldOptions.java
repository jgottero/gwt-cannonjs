package com.github.gwtcannonjs.client.shapes;

import com.google.gwt.core.client.JavaScriptObject;

public class HeightfieldOptions extends JavaScriptObject {
	protected HeightfieldOptions() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Minimum value of the data points in the data array. Will be computed automatically if not given. Optional.
	 */
	public final native double getMinValue() /*-{
		return this.minValue;
	}-*/;
	
	/**
	 * Minimum value of the data points in the data array. Will be computed automatically if not given. Optional.
	 */
	public final native void setMinValue(double minValue) /*-{
		this.minValue = minValue;
	}-*/;
	
	/**
	 * Minimum value of the data points in the data array. Will be computed automatically if not given. Optional.
	 */
	public final native HeightfieldOptions withMinValue(double minValue) /*-{
		this.minValue = minValue;
		return this;
	}-*/;
	
	/**
	 * Maximum value. Optional.
	 */
	public final native double getMaxValue() /*-{
		return this.maxValue;
	}-*/;
	
	/**
	 * Maximum value. Optional.
	 */
	public final native void setMaxValue(double maxValue) /*-{
		this.maxValue = maxValue;
	}-*/;
	
	/**
	 * Maximum value. Optional.
	 */
	public final native HeightfieldOptions withMaxValue(double maxValue) /*-{
		this.maxValue = maxValue;
		return this;
	}-*/;
	
	/**
	 * World spacing between the data points in X direction. Optional.
	 */
	public final native double getElementSize() /*-{
		return this.elementSize;
	}-*/;
	
	/**
	 * World spacing between the data points in X direction. Optional.
	 */
	public final native void setElementSize(double elementSize) /*-{
		this.elementSize = elementSize;
	}-*/;
	
	/**
	 * World spacing between the data points in X direction. Optional.
	 */
	public final native HeightfieldOptions withElementSize(double elementSize) /*-{
		this.elementSize = elementSize;
		return this;
	}-*/;
	
}
