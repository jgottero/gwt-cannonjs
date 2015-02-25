package com.github.gwtcannonjs.client.math;

import com.google.gwt.core.client.JavaScriptObject;

public class Transform extends JavaScriptObject {
	protected Transform() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native Vec3 getPosition() /*-{
		return this.position;
	}-*/;
	
	public final native void setPosition(Vec3 position) /*-{
		this.position = position;
	}-*/;
	
	public final native Transform withPosition(Vec3 position) /*-{
		this.position = position;
		return this;
	}-*/;
	
	public final native Quaternion getQuaternion() /*-{
		return this.quaternion;
	}-*/;
	
	public final native void setQuaternion(Quaternion quaternion) /*-{
		this.quaternion = quaternion;
	}-*/;
	
	public final native Transform withQuaternion(Quaternion quaternion) /*-{
		this.quaternion = quaternion;
		return this;
	}-*/;
	
	/**
	 * @param position
	 * @param quaternion
	 * @param worldPoint
	 * @param result
	 */
	public static final native void pointToLocaFrame(Vec3 position, Quaternion quaternion, Vec3 worldPoint, Vec3 result) /*-{
		this.pointToLocaFrame(position, quaternion, worldPoint, result);
	}-*/;
	
	/**
	 * @param position
	 * @param quaternion
	 * @param localPoint
	 * @param result
	 */
	public static final native void pointToWorldFrame(Vec3 position, Vec3 quaternion, Vec3 localPoint, Vec3 result) /*-{
		this.pointToWorldFrame(position, quaternion, localPoint, result);
	}-*/;
	
}
