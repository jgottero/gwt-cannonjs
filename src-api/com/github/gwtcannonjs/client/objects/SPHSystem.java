// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.objects;

import com.github.gwtcannonjs.client.shapes.Particle;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Smoothed-particle hydrodynamics system
 */
public class SPHSystem extends JavaScriptObject {
	protected SPHSystem() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Density of the system (kg/m3).
	 */
	public final native double getDensity() /*-{
		return this.density;
	}-*/;
	
	/**
	 * Density of the system (kg/m3).
	 */
	public final native void setDensity(double density) /*-{
		this.density = density;
	}-*/;
	
	/**
	 * Density of the system (kg/m3).
	 */
	public final native SPHSystem withDensity(double density) /*-{
		this.density = density;
		return this;
	}-*/;
	
	/**
	 * Distance below which two particles are considered to be neighbors.
	 * It should be adjusted so there are about 15-20 neighbor particles within this radius.
	 */
	public final native double getSmoothingRadius() /*-{
		return this.smoothingRadius;
	}-*/;
	
	/**
	 * Distance below which two particles are considered to be neighbors.
	 * It should be adjusted so there are about 15-20 neighbor particles within this radius.
	 */
	public final native void setSmoothingRadius(double smoothingRadius) /*-{
		this.smoothingRadius = smoothingRadius;
	}-*/;
	
	/**
	 * Distance below which two particles are considered to be neighbors.
	 * It should be adjusted so there are about 15-20 neighbor particles within this radius.
	 */
	public final native SPHSystem withSmoothingRadius(double smoothingRadius) /*-{
		this.smoothingRadius = smoothingRadius;
		return this;
	}-*/;
	
	/**
	 * Viscosity of the system.
	 */
	public final native double getViscosity() /*-{
		return this.viscosity;
	}-*/;
	
	/**
	 * Viscosity of the system.
	 */
	public final native void setViscosity(double viscosity) /*-{
		this.viscosity = viscosity;
	}-*/;
	
	/**
	 * Viscosity of the system.
	 */
	public final native SPHSystem withViscosity(double viscosity) /*-{
		this.viscosity = viscosity;
		return this;
	}-*/;
	
	/**
	 * Add a particle to the system.
	 * @param particle
	 */
	public final native void add(Body particle) /*-{
		this.add(particle);
	}-*/;
	
	/**
	 * Remove a particle from the system.
	 * @param particle
	 */
	public final native void remove(Body particle) /*-{
		this.remove(particle);
	}-*/;
	
	/**
	 * Get neighbors within smoothing volume, save in the array neighbors
	 * @param particle
	 * @param neighbors
	 */
	public final native void getNeighbors(Body particle, JsArray<Particle> neighbors) /*-{
		this.getNeighbors(particle, neighbors);
	}-*/;
	
}
