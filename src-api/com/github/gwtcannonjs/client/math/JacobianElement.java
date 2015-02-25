package com.github.gwtcannonjs.client.math;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An element containing 6 entries, 3 spatial and 3 rotational degrees of freedom.
 */
public class JacobianElement extends JavaScriptObject {
	protected JacobianElement() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native Vec3 getSpatial() /*-{
		return this.spatial;
	}-*/;
	
	public final native void setSpatial(Vec3 spatial) /*-{
		this.spatial = spatial;
	}-*/;
	
	public final native JacobianElement withSpatial(Vec3 spatial) /*-{
		this.spatial = spatial;
		return this;
	}-*/;
	
	public final native Vec3 getRotational() /*-{
		return this.rotational;
	}-*/;
	
	public final native void setRotational(Vec3 rotational) /*-{
		this.rotational = rotational;
	}-*/;
	
	public final native JacobianElement withRotational(Vec3 rotational) /*-{
		this.rotational = rotational;
		return this;
	}-*/;
	
	/**
	 * Multiply with other JacobianElement
	 * @param element
	 */
	public final native double multiplyElement(JacobianElement element) /*-{
		return this.multiplyElement(element);
	}-*/;
	
	/**
	 * Multiply with two vectors
	 * @param spatial
	 * @param rotational
	 */
	public final native double multiplyVectors(Vec3 spatial, Vec3 rotational) /*-{
		return this.multiplyVectors(spatial, rotational);
	}-*/;
	
}
