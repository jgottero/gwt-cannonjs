// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.constraints;

import com.github.gwtcannonjs.client.equations.Equation;
import com.github.gwtcannonjs.client.objects.Body;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Constraint base class
 */
public class Constraint extends JavaScriptObject {
	protected Constraint() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Equations to be solved in this constraint
	 */
	public final native JsArray<? extends Equation> getEquations() /*-{
		return this.equations;
	}-*/;
	
	/**
	 * Equations to be solved in this constraint
	 */
	public final native void setEquations(JsArray<? extends Equation> equations) /*-{
		this.equations = equations;
	}-*/;
	
	/**
	 * Equations to be solved in this constraint
	 */
	public final native Constraint withEquations(JsArray<? extends Equation> equations) /*-{
		this.equations = equations;
		return this;
	}-*/;
	
	public final native Body getBodyA() /*-{
		return this.bodyA;
	}-*/;
	
	public final native void setBodyA(Body bodyA) /*-{
		this.bodyA = bodyA;
	}-*/;
	
	public final native Constraint withBodyA(Body bodyA) /*-{
		this.bodyA = bodyA;
		return this;
	}-*/;
	
	public final native Body getBodyB() /*-{
		return this.bodyB;
	}-*/;
	
	public final native void setBodyB(Body bodyB) /*-{
		this.bodyB = bodyB;
	}-*/;
	
	public final native Constraint withBodyB(Body bodyB) /*-{
		this.bodyB = bodyB;
		return this;
	}-*/;
	
	public final native double getId() /*-{
		return this.id;
	}-*/;
	
	public final native void setId(double id) /*-{
		this.id = id;
	}-*/;
	
	public final native Constraint withId(double id) /*-{
		this.id = id;
		return this;
	}-*/;
	
	/**
	 * Set to true if you want the bodies to collide when they are connected.
	 */
	public final native boolean isCollideConnected() /*-{
		return this.collideConnected;
	}-*/;
	
	/**
	 * Set to true if you want the bodies to collide when they are connected.
	 */
	public final native void setCollideConnected(boolean collideConnected) /*-{
		this.collideConnected = collideConnected;
	}-*/;
	
	/**
	 * Set to true if you want the bodies to collide when they are connected.
	 */
	public final native Constraint withCollideConnected(boolean collideConnected) /*-{
		this.collideConnected = collideConnected;
		return this;
	}-*/;
	
	public final native void update() /*-{
		this.update();
	}-*/;
	
}
