package com.github.gwtcannonjs.client.utils;

import com.google.gwt.core.client.JavaScriptObject;

public class TupleDictionary extends JavaScriptObject {
	protected TupleDictionary() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * The data storage
	 */
	public final native JavaScriptObject getData() /*-{
		return this.data;
	}-*/;
	
	/**
	 * The data storage
	 */
	public final native void setData(JavaScriptObject data) /*-{
		this.data = data;
	}-*/;
	
	/**
	 * The data storage
	 */
	public final native TupleDictionary withData(JavaScriptObject data) /*-{
		this.data = data;
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
	
	public final native void reset() /*-{
		this.reset();
	}-*/;
	
}
