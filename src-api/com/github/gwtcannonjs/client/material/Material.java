// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.material;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Defines a physics material.
 */
public class Material extends JavaScriptObject {
	protected Material() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	public final native void setName(String name) /*-{
		this.name = name;
	}-*/;
	
	public final native Material withName(String name) /*-{
		this.name = name;
		return this;
	}-*/;
	
	/**
	 * material id.
	 */
	public final native double getId() /*-{
		return this.id;
	}-*/;
	
	/**
	 * material id.
	 */
	public final native void setId(double id) /*-{
		this.id = id;
	}-*/;
	
	/**
	 * material id.
	 */
	public final native Material withId(double id) /*-{
		this.id = id;
		return this;
	}-*/;
	
}
