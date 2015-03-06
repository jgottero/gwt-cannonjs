// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.collision;

import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JavaScriptObject;

public class AABBOptions extends JavaScriptObject {
	protected AABBOptions() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Optional.
	 */
	public final native Vec3 getUpperBound() /*-{
		return this.upperBound;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setUpperBound(Vec3 upperBound) /*-{
		this.upperBound = upperBound;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native AABBOptions withUpperBound(Vec3 upperBound) /*-{
		this.upperBound = upperBound;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Vec3 getLowerBound() /*-{
		return this.lowerBound;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setLowerBound(Vec3 lowerBound) /*-{
		this.lowerBound = lowerBound;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native AABBOptions withLowerBound(Vec3 lowerBound) /*-{
		this.lowerBound = lowerBound;
		return this;
	}-*/;
	
}
