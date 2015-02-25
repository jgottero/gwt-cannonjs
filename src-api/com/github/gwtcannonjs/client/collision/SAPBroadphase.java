package com.github.gwtcannonjs.client.collision;

import com.github.gwtcannonjs.client.objects.Body;
import com.google.gwt.core.client.JsArray;

/**
 * Sweep and prune broadphase along one axis.
 */
public class SAPBroadphase extends Broadphase {
	protected SAPBroadphase() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * List of bodies currently in the broadphase.
	 */
	public final native JsArray<Body> getAxisList() /*-{
		return this.axisList;
	}-*/;
	
	/**
	 * List of bodies currently in the broadphase.
	 */
	public final native void setAxisList(JsArray<Body> axisList) /*-{
		this.axisList = axisList;
	}-*/;
	
	/**
	 * List of bodies currently in the broadphase.
	 */
	public final native SAPBroadphase withAxisList(JsArray<Body> axisList) /*-{
		this.axisList = axisList;
		return this;
	}-*/;
	
	/**
	 * Axis to sort the bodies along. Set to 0 for x axis, and 1 for y axis. For best performance, choose an axis that the bodies are spread out more on.
	 */
	public final native double getAxisIndex() /*-{
		return this.axisIndex;
	}-*/;
	
	/**
	 * Axis to sort the bodies along. Set to 0 for x axis, and 1 for y axis. For best performance, choose an axis that the bodies are spread out more on.
	 */
	public final native void setAxisIndex(double axisIndex) /*-{
		this.axisIndex = axisIndex;
	}-*/;
	
	/**
	 * Axis to sort the bodies along. Set to 0 for x axis, and 1 for y axis. For best performance, choose an axis that the bodies are spread out more on.
	 */
	public final native SAPBroadphase withAxisIndex(double axisIndex) /*-{
		this.axisIndex = axisIndex;
		return this;
	}-*/;
	
	/**
	 * @param a
	 */
	public static final native JsArray<Body> insertionSortX(JsArray<Body> a) /*-{
		return this.insertionSortX(a);
	}-*/;
	
	/**
	 * @param a
	 */
	public static final native JsArray<Body> insertionSortY(JsArray<Body> a) /*-{
		return this.insertionSortY(a);
	}-*/;
	
	/**
	 * @param a
	 */
	public static final native JsArray<Body> insertionSortZ(JsArray<Body> a) /*-{
		return this.insertionSortZ(a);
	}-*/;
	
	/**
	 * Check if the bounds of two bodies overlap, along the given SAP axis.
	 * @param bi
	 * @param bj
	 * @param axisIndex
	 */
	public static final native boolean checkBounds(Body bi, Body bj, double axisIndex) /*-{
		return this.checkBounds(bi, bj, axisIndex);
	}-*/;
	
	/**
	 * Computes the variance of the body positions and estimates the best
	 * axis to use. Will automatically set property .axisIndex.
	 */
	public final native void autoDetectAxis() /*-{
		this.autoDetectAxis();
	}-*/;
	
}
