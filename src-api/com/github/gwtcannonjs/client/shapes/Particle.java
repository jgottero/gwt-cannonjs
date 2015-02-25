package com.github.gwtcannonjs.client.shapes;

import com.github.gwtcannonjs.client.math.Vec3;

/**
 * Particle shape.
 */
public class Particle extends Shape {
	protected Particle() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * @param mass
	 * @param target
	 */
	public final native Vec3 calculateLocalInertia(double mass, Vec3 target) /*-{
		return this.calculateLocalInertia(mass, target);
	}-*/;
	
}
