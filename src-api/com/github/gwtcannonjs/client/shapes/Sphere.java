package com.github.gwtcannonjs.client.shapes;

/**
 * Spherical shape
 */
public class Sphere extends Shape {
	protected Sphere() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native double getRadius() /*-{
		return this.radius;
	}-*/;
	
	public final native void setRadius(double radius) /*-{
		this.radius = radius;
	}-*/;
	
	public final native Sphere withRadius(double radius) /*-{
		this.radius = radius;
		return this;
	}-*/;
	
}
