package com.github.gwtcannonjs.client.objects;

import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A spring, connecting two bodies.
 */
public class Spring extends JavaScriptObject {
	protected Spring() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Rest length of the spring.
	 */
	public final native double getRestLength() /*-{
		return this.restLength;
	}-*/;
	
	/**
	 * Rest length of the spring.
	 */
	public final native void setRestLength(double restLength) /*-{
		this.restLength = restLength;
	}-*/;
	
	/**
	 * Rest length of the spring.
	 */
	public final native Spring withRestLength(double restLength) /*-{
		this.restLength = restLength;
		return this;
	}-*/;
	
	/**
	 * Stiffness of the spring.
	 */
	public final native double getStiffness() /*-{
		return this.stiffness;
	}-*/;
	
	/**
	 * Stiffness of the spring.
	 */
	public final native void setStiffness(double stiffness) /*-{
		this.stiffness = stiffness;
	}-*/;
	
	/**
	 * Stiffness of the spring.
	 */
	public final native Spring withStiffness(double stiffness) /*-{
		this.stiffness = stiffness;
		return this;
	}-*/;
	
	/**
	 * Damping of the spring.
	 */
	public final native double getDamping() /*-{
		return this.damping;
	}-*/;
	
	/**
	 * Damping of the spring.
	 */
	public final native void setDamping(double damping) /*-{
		this.damping = damping;
	}-*/;
	
	/**
	 * Damping of the spring.
	 */
	public final native Spring withDamping(double damping) /*-{
		this.damping = damping;
		return this;
	}-*/;
	
	/**
	 * First connected body.
	 */
	public final native Body getBodyA() /*-{
		return this.bodyA;
	}-*/;
	
	/**
	 * First connected body.
	 */
	public final native void setBodyA(Body bodyA) /*-{
		this.bodyA = bodyA;
	}-*/;
	
	/**
	 * First connected body.
	 */
	public final native Spring withBodyA(Body bodyA) /*-{
		this.bodyA = bodyA;
		return this;
	}-*/;
	
	/**
	 * Second connected body.
	 */
	public final native Body getBodyB() /*-{
		return this.bodyB;
	}-*/;
	
	/**
	 * Second connected body.
	 */
	public final native void setBodyB(Body bodyB) /*-{
		this.bodyB = bodyB;
	}-*/;
	
	/**
	 * Second connected body.
	 */
	public final native Spring withBodyB(Body bodyB) /*-{
		this.bodyB = bodyB;
		return this;
	}-*/;
	
	/**
	 * Anchor for bodyA in local bodyA coordinates.
	 */
	public final native Vec3 getLocalAnchorA() /*-{
		return this.localAnchorA;
	}-*/;
	
	/**
	 * Anchor for bodyA in local bodyA coordinates.
	 */
	public final native void setLocalAnchorA(Vec3 localAnchorA) /*-{
		this.localAnchorA = localAnchorA;
	}-*/;
	
	/**
	 * Anchor for bodyA in local bodyA coordinates.
	 */
	public final native Spring withLocalAnchorA(Vec3 localAnchorA) /*-{
		this.localAnchorA = localAnchorA;
		return this;
	}-*/;
	
	/**
	 * Anchor for bodyB in local bodyB coordinates.
	 */
	public final native Vec3 getLocalAnchorB() /*-{
		return this.localAnchorB;
	}-*/;
	
	/**
	 * Anchor for bodyB in local bodyB coordinates.
	 */
	public final native void setLocalAnchorB(Vec3 localAnchorB) /*-{
		this.localAnchorB = localAnchorB;
	}-*/;
	
	/**
	 * Anchor for bodyB in local bodyB coordinates.
	 */
	public final native Spring withLocalAnchorB(Vec3 localAnchorB) /*-{
		this.localAnchorB = localAnchorB;
		return this;
	}-*/;
	
	/**
	 * Set the anchor point on body A, using world coordinates.
	 * @param worldAnchorA
	 */
	public final native void setWorldAnchorA(Vec3 worldAnchorA) /*-{
		this.setWorldAnchorA(worldAnchorA);
	}-*/;
	
	/**
	 * Set the anchor point on body B, using world coordinates.
	 * @param worldAnchorB
	 */
	public final native void setWorldAnchorB(Vec3 worldAnchorB) /*-{
		this.setWorldAnchorB(worldAnchorB);
	}-*/;
	
	/**
	 * Get the anchor point on body A, in world coordinates.
	 * @param result The vector to store the result in.
	 */
	public final native void getWorldAnchorA(Vec3 result) /*-{
		this.getWorldAnchorA(result);
	}-*/;
	
	/**
	 * Get the anchor point on body B, in world coordinates.
	 * @param result The vector to store the result in.
	 */
	public final native void getWorldAnchorB(Vec3 result) /*-{
		this.getWorldAnchorB(result);
	}-*/;
	
	/**
	 * Apply the spring force to the connected bodies.
	 */
	public final native void applyForce() /*-{
		this.applyForce();
	}-*/;
	
}
