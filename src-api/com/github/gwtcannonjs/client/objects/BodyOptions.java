// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.objects;

import com.github.gwtcannonjs.client.material.Material;
import com.github.gwtcannonjs.client.math.Quaternion;
import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JavaScriptObject;

public class BodyOptions extends JavaScriptObject {
	protected BodyOptions() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Optional.
	 */
	public final native Vec3 getPosition() /*-{
		return this.position;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setPosition(Vec3 position) /*-{
		this.position = position;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native BodyOptions withPosition(Vec3 position) /*-{
		this.position = position;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Vec3 getVelocity() /*-{
		return this.velocity;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setVelocity(Vec3 velocity) /*-{
		this.velocity = velocity;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native BodyOptions withVelocity(Vec3 velocity) /*-{
		this.velocity = velocity;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Vec3 getAngularVelocity() /*-{
		return this.angularVelocity;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setAngularVelocity(Vec3 angularVelocity) /*-{
		this.angularVelocity = angularVelocity;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native BodyOptions withAngularVelocity(Vec3 angularVelocity) /*-{
		this.angularVelocity = angularVelocity;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Quaternion getQuaternion() /*-{
		return this.quaternion;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setQuaternion(Quaternion quaternion) /*-{
		this.quaternion = quaternion;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native BodyOptions withQuaternion(Quaternion quaternion) /*-{
		this.quaternion = quaternion;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getMass() /*-{
		return this.mass;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setMass(double mass) /*-{
		this.mass = mass;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native BodyOptions withMass(double mass) /*-{
		this.mass = mass;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getType() /*-{
		return this.type;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setType(double type) /*-{
		this.type = type;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native BodyOptions withType(double type) /*-{
		this.type = type;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native double getLinearDamping() /*-{
		return this.linearDamping;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setLinearDamping(double linearDamping) /*-{
		this.linearDamping = linearDamping;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native BodyOptions withLinearDamping(double linearDamping) /*-{
		this.linearDamping = linearDamping;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native Material getMaterial() /*-{
		return this.material;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setMaterial(Material material) /*-{
		this.material = material;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native BodyOptions withMaterial(Material material) /*-{
		this.material = material;
		return this;
	}-*/;
	
}
