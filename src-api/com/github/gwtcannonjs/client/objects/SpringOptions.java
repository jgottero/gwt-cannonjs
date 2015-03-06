// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.objects;

import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JavaScriptObject;

public class SpringOptions extends JavaScriptObject {
	protected SpringOptions() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * A number > 0. Default: 1. Optional.
	 */
	public final native double getRestLength() /*-{
		return this.restLength;
	}-*/;
	
	/**
	 * A number > 0. Default: 1. Optional.
	 */
	public final native void setRestLength(double restLength) /*-{
		this.restLength = restLength;
	}-*/;
	
	/**
	 * A number > 0. Default: 1. Optional.
	 */
	public final native SpringOptions withRestLength(double restLength) /*-{
		this.restLength = restLength;
		return this;
	}-*/;
	
	/**
	 * A number >= 0. Default: 100. Optional.
	 */
	public final native double getStiffness() /*-{
		return this.stiffness;
	}-*/;
	
	/**
	 * A number >= 0. Default: 100. Optional.
	 */
	public final native void setStiffness(double stiffness) /*-{
		this.stiffness = stiffness;
	}-*/;
	
	/**
	 * A number >= 0. Default: 100. Optional.
	 */
	public final native SpringOptions withStiffness(double stiffness) /*-{
		this.stiffness = stiffness;
		return this;
	}-*/;
	
	/**
	 * A number >= 0. Default: 1. Optional.
	 */
	public final native double getDamping() /*-{
		return this.damping;
	}-*/;
	
	/**
	 * A number >= 0. Default: 1. Optional.
	 */
	public final native void setDamping(double damping) /*-{
		this.damping = damping;
	}-*/;
	
	/**
	 * A number >= 0. Default: 1. Optional.
	 */
	public final native SpringOptions withDamping(double damping) /*-{
		this.damping = damping;
		return this;
	}-*/;
	
	/**
	 * Where to hook the spring to body A, in world coordinates. Optional.
	 */
	public final native Vec3 getWorldAnchorA() /*-{
		return this.worldAnchorA;
	}-*/;
	
	/**
	 * Where to hook the spring to body A, in world coordinates. Optional.
	 */
	public final native void setWorldAnchorA(Vec3 worldAnchorA) /*-{
		this.worldAnchorA = worldAnchorA;
	}-*/;
	
	/**
	 * Where to hook the spring to body A, in world coordinates. Optional.
	 */
	public final native SpringOptions withWorldAnchorA(Vec3 worldAnchorA) /*-{
		this.worldAnchorA = worldAnchorA;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Vec3 getWorldAnchorB() /*-{
		return this.worldAnchorB;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setWorldAnchorB(Vec3 worldAnchorB) /*-{
		this.worldAnchorB = worldAnchorB;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native SpringOptions withWorldAnchorB(Vec3 worldAnchorB) /*-{
		this.worldAnchorB = worldAnchorB;
		return this;
	}-*/;
	
	/**
	 * Where to hook the spring to body A, in local body coordinates. Optional.
	 */
	public final native Vec3 getLocalAnchorA() /*-{
		return this.localAnchorA;
	}-*/;
	
	/**
	 * Where to hook the spring to body A, in local body coordinates. Optional.
	 */
	public final native void setLocalAnchorA(Vec3 localAnchorA) /*-{
		this.localAnchorA = localAnchorA;
	}-*/;
	
	/**
	 * Where to hook the spring to body A, in local body coordinates. Optional.
	 */
	public final native SpringOptions withLocalAnchorA(Vec3 localAnchorA) /*-{
		this.localAnchorA = localAnchorA;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Vec3 getLocalAnchorB() /*-{
		return this.localAnchorB;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setLocalAnchorB(Vec3 localAnchorB) /*-{
		this.localAnchorB = localAnchorB;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native SpringOptions withLocalAnchorB(Vec3 localAnchorB) /*-{
		this.localAnchorB = localAnchorB;
		return this;
	}-*/;
	
}
