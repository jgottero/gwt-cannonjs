// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.equations;

import com.github.gwtcannonjs.client.math.Vec3;

/**
 * Contact/non-penetration constraint equation
 */
public class ContactEquation extends Equation {
	protected ContactEquation() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native double getRestitution() /*-{
		return this.restitution;
	}-*/;
	
	public final native void setRestitution(double restitution) /*-{
		this.restitution = restitution;
	}-*/;
	
	public final native ContactEquation withRestitution(double restitution) /*-{
		this.restitution = restitution;
		return this;
	}-*/;
	
	/**
	 * World-oriented vector that goes from the center of bi to the contact point.
	 */
	public final native Vec3 getRi() /*-{
		return this.ri;
	}-*/;
	
	/**
	 * World-oriented vector that goes from the center of bi to the contact point.
	 */
	public final native void setRi(Vec3 ri) /*-{
		this.ri = ri;
	}-*/;
	
	/**
	 * World-oriented vector that goes from the center of bi to the contact point.
	 */
	public final native ContactEquation withRi(Vec3 ri) /*-{
		this.ri = ri;
		return this;
	}-*/;
	
	/**
	 * World-oriented vector that starts in body j position and goes to the contact point.
	 */
	public final native Vec3 getRj() /*-{
		return this.rj;
	}-*/;
	
	/**
	 * World-oriented vector that starts in body j position and goes to the contact point.
	 */
	public final native void setRj(Vec3 rj) /*-{
		this.rj = rj;
	}-*/;
	
	/**
	 * World-oriented vector that starts in body j position and goes to the contact point.
	 */
	public final native ContactEquation withRj(Vec3 rj) /*-{
		this.rj = rj;
		return this;
	}-*/;
	
	/**
	 * Contact normal, pointing out of body i.
	 */
	public final native Vec3 getNi() /*-{
		return this.ni;
	}-*/;
	
	/**
	 * Contact normal, pointing out of body i.
	 */
	public final native void setNi(Vec3 ni) /*-{
		this.ni = ni;
	}-*/;
	
	/**
	 * Contact normal, pointing out of body i.
	 */
	public final native ContactEquation withNi(Vec3 ni) /*-{
		this.ni = ni;
		return this;
	}-*/;
	
}
