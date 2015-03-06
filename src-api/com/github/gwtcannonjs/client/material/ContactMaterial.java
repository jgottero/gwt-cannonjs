// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.material;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Defines what happens when two materials meet.
 */
public class ContactMaterial extends JavaScriptObject {
	protected ContactMaterial() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Identifier of this material
	 */
	public final native double getId() /*-{
		return this.id;
	}-*/;
	
	/**
	 * Identifier of this material
	 */
	public final native void setId(double id) /*-{
		this.id = id;
	}-*/;
	
	/**
	 * Identifier of this material
	 */
	public final native ContactMaterial withId(double id) /*-{
		this.id = id;
		return this;
	}-*/;
	
	/**
	 * Participating materials
	 */
	public final native JsArray<Material> getMaterials() /*-{
		return this.materials;
	}-*/;
	
	/**
	 * Participating materials
	 */
	public final native void setMaterials(JsArray<Material> materials) /*-{
		this.materials = materials;
	}-*/;
	
	/**
	 * Participating materials
	 */
	public final native ContactMaterial withMaterials(JsArray<Material> materials) /*-{
		this.materials = materials;
		return this;
	}-*/;
	
	/**
	 * Friction coefficient
	 */
	public final native double getFriction() /*-{
		return this.friction;
	}-*/;
	
	/**
	 * Friction coefficient
	 */
	public final native void setFriction(double friction) /*-{
		this.friction = friction;
	}-*/;
	
	/**
	 * Friction coefficient
	 */
	public final native ContactMaterial withFriction(double friction) /*-{
		this.friction = friction;
		return this;
	}-*/;
	
	/**
	 * Restitution coefficient
	 */
	public final native double getRestitution() /*-{
		return this.restitution;
	}-*/;
	
	/**
	 * Restitution coefficient
	 */
	public final native void setRestitution(double restitution) /*-{
		this.restitution = restitution;
	}-*/;
	
	/**
	 * Restitution coefficient
	 */
	public final native ContactMaterial withRestitution(double restitution) /*-{
		this.restitution = restitution;
		return this;
	}-*/;
	
	/**
	 * Stiffness of the produced contact equations
	 */
	public final native double getContactEquationStiffness() /*-{
		return this.contactEquationStiffness;
	}-*/;
	
	/**
	 * Stiffness of the produced contact equations
	 */
	public final native void setContactEquationStiffness(double contactEquationStiffness) /*-{
		this.contactEquationStiffness = contactEquationStiffness;
	}-*/;
	
	/**
	 * Stiffness of the produced contact equations
	 */
	public final native ContactMaterial withContactEquationStiffness(double contactEquationStiffness) /*-{
		this.contactEquationStiffness = contactEquationStiffness;
		return this;
	}-*/;
	
	/**
	 * Relaxation time of the produced contact equations
	 */
	public final native double getContactEquationRelaxation() /*-{
		return this.contactEquationRelaxation;
	}-*/;
	
	/**
	 * Relaxation time of the produced contact equations
	 */
	public final native void setContactEquationRelaxation(double contactEquationRelaxation) /*-{
		this.contactEquationRelaxation = contactEquationRelaxation;
	}-*/;
	
	/**
	 * Relaxation time of the produced contact equations
	 */
	public final native ContactMaterial withContactEquationRelaxation(double contactEquationRelaxation) /*-{
		this.contactEquationRelaxation = contactEquationRelaxation;
		return this;
	}-*/;
	
	/**
	 * Stiffness of the produced friction equations
	 */
	public final native double getFrictionEquationStiffness() /*-{
		return this.frictionEquationStiffness;
	}-*/;
	
	/**
	 * Stiffness of the produced friction equations
	 */
	public final native void setFrictionEquationStiffness(double frictionEquationStiffness) /*-{
		this.frictionEquationStiffness = frictionEquationStiffness;
	}-*/;
	
	/**
	 * Stiffness of the produced friction equations
	 */
	public final native ContactMaterial withFrictionEquationStiffness(double frictionEquationStiffness) /*-{
		this.frictionEquationStiffness = frictionEquationStiffness;
		return this;
	}-*/;
	
	/**
	 * Relaxation time of the produced friction equations
	 */
	public final native double getFrictionEquationRelaxation() /*-{
		return this.frictionEquationRelaxation;
	}-*/;
	
	/**
	 * Relaxation time of the produced friction equations
	 */
	public final native void setFrictionEquationRelaxation(double frictionEquationRelaxation) /*-{
		this.frictionEquationRelaxation = frictionEquationRelaxation;
	}-*/;
	
	/**
	 * Relaxation time of the produced friction equations
	 */
	public final native ContactMaterial withFrictionEquationRelaxation(double frictionEquationRelaxation) /*-{
		this.frictionEquationRelaxation = frictionEquationRelaxation;
		return this;
	}-*/;
	
}
