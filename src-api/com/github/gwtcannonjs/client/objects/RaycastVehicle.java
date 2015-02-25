package com.github.gwtcannonjs.client.objects;

import com.github.gwtcannonjs.client.math.Transform;
import com.github.gwtcannonjs.client.world.World;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Vehicle helper class that casts rays from the wheel positions towards the ground and applies forces.
 */
public class RaycastVehicle extends JavaScriptObject {
	protected RaycastVehicle() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native Body getChassisBody() /*-{
		return this.chassisBody;
	}-*/;
	
	public final native void setChassisBody(Body chassisBody) /*-{
		this.chassisBody = chassisBody;
	}-*/;
	
	public final native RaycastVehicle withChassisBody(Body chassisBody) /*-{
		this.chassisBody = chassisBody;
		return this;
	}-*/;
	
	/**
	 * An array of WheelInfo objects.
	 */
	public final native JsArray<WheelInfo> getWheelInfos() /*-{
		return this.wheelInfos;
	}-*/;
	
	/**
	 * An array of WheelInfo objects.
	 */
	public final native void setWheelInfos(JsArray<WheelInfo> wheelInfos) /*-{
		this.wheelInfos = wheelInfos;
	}-*/;
	
	/**
	 * An array of WheelInfo objects.
	 */
	public final native RaycastVehicle withWheelInfos(JsArray<WheelInfo> wheelInfos) /*-{
		this.wheelInfos = wheelInfos;
		return this;
	}-*/;
	
	/**
	 * Will be set to true if the car is sliding.
	 */
	public final native boolean isSliding() /*-{
		return this.sliding;
	}-*/;
	
	/**
	 * Will be set to true if the car is sliding.
	 */
	public final native void setSliding(boolean sliding) /*-{
		this.sliding = sliding;
	}-*/;
	
	/**
	 * Will be set to true if the car is sliding.
	 */
	public final native RaycastVehicle withSliding(boolean sliding) /*-{
		this.sliding = sliding;
		return this;
	}-*/;
	
	public final native World getWorld() /*-{
		return this.world;
	}-*/;
	
	public final native void setWorld(World world) /*-{
		this.world = world;
	}-*/;
	
	public final native RaycastVehicle withWorld(World world) /*-{
		this.world = world;
		return this;
	}-*/;
	
	/**
	 * Index of the right axis, 0=x, 1=y, 2=z
	 * Default is 1.
	 */
	public final native int getIndexRightAxis() /*-{
		return this.indexRightAxis;
	}-*/;
	
	/**
	 * Index of the right axis, 0=x, 1=y, 2=z
	 * Default is 1.
	 */
	public final native void setIndexRightAxis(int indexRightAxis) /*-{
		this.indexRightAxis = indexRightAxis;
	}-*/;
	
	/**
	 * Index of the right axis, 0=x, 1=y, 2=z
	 * Default is 1.
	 */
	public final native RaycastVehicle withIndexRightAxis(int indexRightAxis) /*-{
		this.indexRightAxis = indexRightAxis;
		return this;
	}-*/;
	
	/**
	 * Index of the forward axis, 0=x, 1=y, 2=z
	 * Default is 0.
	 */
	public final native int getIndexForwardAxis() /*-{
		return this.indexForwardAxis;
	}-*/;
	
	/**
	 * Index of the forward axis, 0=x, 1=y, 2=z
	 * Default is 0.
	 */
	public final native void setIndexForwardAxis(int indexForwardAxis) /*-{
		this.indexForwardAxis = indexForwardAxis;
	}-*/;
	
	/**
	 * Index of the forward axis, 0=x, 1=y, 2=z
	 * Default is 0.
	 */
	public final native RaycastVehicle withIndexForwardAxis(int indexForwardAxis) /*-{
		this.indexForwardAxis = indexForwardAxis;
		return this;
	}-*/;
	
	/**
	 * Index of the up axis, 0=x, 1=y, 2=z
	 * Default is 2.
	 */
	public final native int getIndexUpAxis() /*-{
		return this.indexUpAxis;
	}-*/;
	
	/**
	 * Index of the up axis, 0=x, 1=y, 2=z
	 * Default is 2.
	 */
	public final native void setIndexUpAxis(int indexUpAxis) /*-{
		this.indexUpAxis = indexUpAxis;
	}-*/;
	
	/**
	 * Index of the up axis, 0=x, 1=y, 2=z
	 * Default is 2.
	 */
	public final native RaycastVehicle withIndexUpAxis(int indexUpAxis) /*-{
		this.indexUpAxis = indexUpAxis;
		return this;
	}-*/;
	
	/**
	 * Add a wheel. For information about the options, see WheelInfo.
	 * @param options Optional.
	 */
	public final native void addWheel(WheelInfoOptions options) /*-{
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
	 * Set the wheel force to apply on one of the wheels each time step
	 * @param value
	 * @param wheelIndex
	 */
	public final native void applyEngineForce(double value, int wheelIndex) /*-{
		this.applyEngineForce(value, wheelIndex);
	}-*/;
	
	/**
	 * Set the braking force of a wheel
	 * @param brake
	 * @param wheelIndex
	 */
	public final native void setBrake(double brake, int wheelIndex) /*-{
		this.setBrake(brake, wheelIndex);
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
	 * Update one of the wheel transform.
	 * @param wheelIndex
	 */
	public final native void updateWheelTransform(int wheelIndex) /*-{
		this.updateWheelTransform(wheelIndex);
	}-*/;
	
	/**
	 * Get the world transform of one of the wheels
	 * @param wheelIndex
	 */
	public final native Transform getWheelTransformWorld(int wheelIndex) /*-{
		return this.getWheelTransformWorld(wheelIndex);
	}-*/;
	
}
