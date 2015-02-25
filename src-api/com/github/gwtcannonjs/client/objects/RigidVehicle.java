package com.github.gwtcannonjs.client.objects;

import com.github.gwtcannonjs.client.constraints.HingeConstraint;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.world.World;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Simple vehicle helper class with spherical rigid body wheels.
 */
public class RigidVehicle extends JavaScriptObject {
	protected RigidVehicle() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native Vec3 getCoordinateSystem() /*-{
		return this.coordinateSystem;
	}-*/;
	
	public final native void setCoordinateSystem(Vec3 coordinateSystem) /*-{
		this.coordinateSystem = coordinateSystem;
	}-*/;
	
	public final native RigidVehicle withCoordinateSystem(Vec3 coordinateSystem) /*-{
		this.coordinateSystem = coordinateSystem;
		return this;
	}-*/;
	
	public final native Body getChassisBody() /*-{
		return this.chassisBody;
	}-*/;
	
	public final native void setChassisBody(Body chassisBody) /*-{
		this.chassisBody = chassisBody;
	}-*/;
	
	public final native RigidVehicle withChassisBody(Body chassisBody) /*-{
		this.chassisBody = chassisBody;
		return this;
	}-*/;
	
	public final native JsArray<HingeConstraint> getConstraints() /*-{
		return this.constraints;
	}-*/;
	
	public final native void setConstraints(JsArray<HingeConstraint> constraints) /*-{
		this.constraints = constraints;
	}-*/;
	
	public final native RigidVehicle withConstraints(JsArray<HingeConstraint> constraints) /*-{
		this.constraints = constraints;
		return this;
	}-*/;
	
	/**
	 * Add a wheel
	 * @param options
	 */
	public final native void addWheel(RigidVehicleOptions options) /*-{
		this.addWheel(options);
	}-*/;
	
	/**
	 * Set the steering value of a wheel.
	 * @param value
	 * @param wheelIndex
	 */
	public final native void setSteeringValue(double value, int wheelIndex) /*-{
		this.setSteeringValue(value, wheelIndex);
	}-*/;
	
	/**
	 * Set the target rotational speed of the hinge constraint.
	 * @param value
	 * @param wheelIndex
	 */
	public final native void setMotorSpeed(double value, int wheelIndex) /*-{
		this.setMotorSpeed(value, wheelIndex);
	}-*/;
	
	/**
	 * Set the target rotational speed of the hinge constraint.
	 * @param value
	 * @param wheelIndex
	 */
	public final native void disableMotor(double value, int wheelIndex) /*-{
		this.disableMotor(value, wheelIndex);
	}-*/;
	
	/**
	 * Set the wheel force to apply on one of the wheels each time step
	 * @param value
	 * @param wheelIndex
	 */
	public final native void setWheelForce(double value, int wheelIndex) /*-{
		this.setWheelForce(value, wheelIndex);
	}-*/;
	
	/**
	 * Apply a torque on one of the wheels.
	 * @param value
	 * @param wheelIndex
	 */
	public final native void applyWheelForce(double value, int wheelIndex) /*-{
		this.applyWheelForce(value, wheelIndex);
	}-*/;
	
	/**
	 * Add the vehicle including its constraints to the world.
	 * @param world
	 */
	public final native void addToWorld(World world) /*-{
		this.addToWorld(world);
	}-*/;
	
	/**
	 * Remove the vehicle including its constraints from the world.
	 * @param world
	 */
	public final native void removeFromWorld(World world) /*-{
		this.removeFromWorld(world);
	}-*/;
	
	/**
	 * Get current rotational velocity of a wheel
	 * @param wheelIndex
	 */
	public final native void getWheelSpeed(int wheelIndex) /*-{
		this.getWheelSpeed(wheelIndex);
	}-*/;
	
}
