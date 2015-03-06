// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.material;

import com.google.gwt.core.client.JavaScriptObject;

public class ContactMaterialOptions extends JavaScriptObject {
	protected ContactMaterialOptions() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Optional.
	 */
	public final native double getFriction() /*-{
		return this.friction;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setFriction(double friction) /*-{
		this.friction = friction;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native ContactMaterialOptions withFriction(double friction) /*-{
		this.friction = friction;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getRestitution() /*-{
		return this.restitution;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setRestitution(double restitution) /*-{
		this.restitution = restitution;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native ContactMaterialOptions withRestitution(double restitution) /*-{
		this.restitution = restitution;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getContactEquationStiffness() /*-{
		return this.contactEquationStiffness;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setContactEquationStiffness(double contactEquationStiffness) /*-{
		this.contactEquationStiffness = contactEquationStiffness;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native ContactMaterialOptions withContactEquationStiffness(double contactEquationStiffness) /*-{
		this.contactEquationStiffness = contactEquationStiffness;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getContactEquationRelaxation() /*-{
		return this.contactEquationRelaxation;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setContactEquationRelaxation(double contactEquationRelaxation) /*-{
		this.contactEquationRelaxation = contactEquationRelaxation;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native ContactMaterialOptions withContactEquationRelaxation(double contactEquationRelaxation) /*-{
		this.contactEquationRelaxation = contactEquationRelaxation;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getFrictionEquationStiffness() /*-{
		return this.frictionEquationStiffness;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setFrictionEquationStiffness(double frictionEquationStiffness) /*-{
		this.frictionEquationStiffness = frictionEquationStiffness;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native ContactMaterialOptions withFrictionEquationStiffness(double frictionEquationStiffness) /*-{
		this.frictionEquationStiffness = frictionEquationStiffness;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getFrictionEquationRelaxation() /*-{
		return this.frictionEquationRelaxation;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setFrictionEquationRelaxation(double frictionEquationRelaxation) /*-{
		this.frictionEquationRelaxation = frictionEquationRelaxation;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native ContactMaterialOptions withFrictionEquationRelaxation(double frictionEquationRelaxation) /*-{
		this.frictionEquationRelaxation = frictionEquationRelaxation;
		return this;
	}-*/;
	
}
