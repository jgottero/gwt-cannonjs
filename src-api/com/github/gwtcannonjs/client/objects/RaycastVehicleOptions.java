package com.github.gwtcannonjs.client.objects;

import com.google.gwt.core.client.JavaScriptObject;

public class RaycastVehicleOptions extends JavaScriptObject {
	protected RaycastVehicleOptions() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * The car chassis body. Optional.
	 */
	public final native Body getChassisBody() /*-{
		return this.chassisBody;
	}-*/;
	
	/**
	 * The car chassis body. Optional.
	 */
	public final native void setChassisBody(Body chassisBody) /*-{
		this.chassisBody = chassisBody;
	}-*/;
	
	/**
	 * The car chassis body. Optional.
	 */
	public final native RaycastVehicleOptions withChassisBody(Body chassisBody) /*-{
		this.chassisBody = chassisBody;
		return this;
	}-*/;
	
	/**
	 * Axis to use for right. x=0, y=1, z=2. Optional.
	 */
	public final native int getIndexRightAxis() /*-{
		return this.indexRightAxis;
	}-*/;
	
	/**
	 * Axis to use for right. x=0, y=1, z=2. Optional.
	 */
	public final native void setIndexRightAxis(int indexRightAxis) /*-{
		this.indexRightAxis = indexRightAxis;
	}-*/;
	
	/**
	 * Axis to use for right. x=0, y=1, z=2. Optional.
	 */
	public final native RaycastVehicleOptions withIndexRightAxis(int indexRightAxis) /*-{
		this.indexRightAxis = indexRightAxis;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native int getIndexLeftAxis() /*-{
		return this.indexLeftAxis;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setIndexLeftAxis(int indexLeftAxis) /*-{
		this.indexLeftAxis = indexLeftAxis;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native RaycastVehicleOptions withIndexLeftAxis(int indexLeftAxis) /*-{
		this.indexLeftAxis = indexLeftAxis;
		return this;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native int getIndexUpAxis() /*-{
		return this.indexUpAxis;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native void setIndexUpAxis(int indexUpAxis) /*-{
		this.indexUpAxis = indexUpAxis;
	}-*/;
	
	/**
	 * Optional.
	 */
	public final native RaycastVehicleOptions withIndexUpAxis(int indexUpAxis) /*-{
		this.indexUpAxis = indexUpAxis;
		return this;
	}-*/;
	
}
