// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.utils;

import com.google.gwt.core.client.JavaScriptObject;

public class Event extends JavaScriptObject {
	protected Event() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native String getType() /*-{
		return this.type;
	}-*/;
	
	public final native void setType(String type) /*-{
		this.type = type;
	}-*/;
	
	public final native Event withType(String type) /*-{
		this.type = type;
		return this;
	}-*/;
	
}
