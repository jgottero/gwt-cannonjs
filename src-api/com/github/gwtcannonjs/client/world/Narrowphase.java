package com.github.gwtcannonjs.client.world;

import com.github.gwtcannonjs.client.equations.ContactEquation;
import com.github.gwtcannonjs.client.math.Quaternion;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.utils.Vec3Pool;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;

/**
 * Helper class for the World. Generates ContactEquations.
 */
public class Narrowphase extends JavaScriptObject {
	protected Narrowphase() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Internal storage of pooled contact points.
	 */
	public final native JsArray<ContactEquation> getContactPointPool() /*-{
		return this.contactPointPool;
	}-*/;
	
	/**
	 * Internal storage of pooled contact points.
	 */
	public final native void setContactPointPool(JsArray<ContactEquation> contactPointPool) /*-{
		this.contactPointPool = contactPointPool;
	}-*/;
	
	/**
	 * Internal storage of pooled contact points.
	 */
	public final native Narrowphase withContactPointPool(JsArray<ContactEquation> contactPointPool) /*-{
		this.contactPointPool = contactPointPool;
		return this;
	}-*/;
	
	/**
	 * Pooled vectors.
	 */
	public final native Vec3Pool getV3pool() /*-{
		return this.v3pool;
	}-*/;
	
	/**
	 * Pooled vectors.
	 */
	public final native void setV3pool(Vec3Pool v3pool) /*-{
		this.v3pool = v3pool;
	}-*/;
	
	/**
	 * Pooled vectors.
	 */
	public final native Narrowphase withV3pool(Vec3Pool v3pool) /*-{
		this.v3pool = v3pool;
		return this;
	}-*/;
	
	/**
	 * Make a contact object, by using the internal pool or creating a new one.
	 */
	public final native ContactEquation makeResult() /*-{
		return this.makeResult();
	}-*/;
	
	/**
	 * Generate all contacts between a list of body pairs
	 * @param p1 Array of body indices
	 * @param p2 Array of body indices
	 * @param world
	 * @param result Array to store generated contacts
	 * @param oldcontacts Optional. Array of reusable contact objects
	 */
	public final native void getContacts(JsArrayInteger p1, JsArrayInteger p2, World world, JsArray<ContactEquation> result, JsArray<ContactEquation> oldcontacts) /*-{
		this.getContacts(p1, p2, world, result, oldcontacts);
	}-*/;
	
	/**
	 * @param result
	 * @param si
	 * @param sj
	 * @param xi
	 * @param xj
	 * @param qi
	 * @param qj
	 * @param bi
	 * @param bj
	 */
	public final native void sphereSphere(JsArray<ContactEquation> result, Shape si, Shape sj, Vec3 xi, Vec3 xj, Quaternion qi, Quaternion qj, Body bi, Body bj) /*-{
		this.sphereSphere(result, si, sj, xi, xj, qi, qj, bi, bj);
	}-*/;
	
	/**
	 * @param result
	 * @param si
	 * @param sj
	 * @param xi
	 * @param xj
	 * @param qi
	 * @param qj
	 * @param bi
	 * @param bj
	 */
	public final native void spherePlane(JsArray<ContactEquation> result, Shape si, Shape sj, Vec3 xi, Vec3 xj, Quaternion qi, Quaternion qj, Body bi, Body bj) /*-{
		this.spherePlane(result, si, sj, xi, xj, qi, qj, bi, bj);
	}-*/;
	
	/**
	 * @param result
	 * @param si
	 * @param sj
	 * @param xi
	 * @param xj
	 * @param qi
	 * @param qj
	 * @param bi
	 * @param bj
	 */
	public final native void sphereBox(JsArray<ContactEquation> result, Shape si, Shape sj, Vec3 xi, Vec3 xj, Quaternion qi, Quaternion qj, Body bi, Body bj) /*-{
		this.sphereBox(result, si, sj, xi, xj, qi, qj, bi, bj);
	}-*/;
	
	/**
	 * @param result
	 * @param si
	 * @param sj
	 * @param xi
	 * @param xj
	 * @param qi
	 * @param qj
	 * @param bi
	 * @param bj
	 */
	public final native void sphereConvex(JsArray<ContactEquation> result, Shape si, Shape sj, Vec3 xi, Vec3 xj, Quaternion qi, Quaternion qj, Body bi, Body bj) /*-{
		this.sphereConvex(result, si, sj, xi, xj, qi, qj, bi, bj);
	}-*/;
	
	/**
	 * @param result
	 * @param si
	 * @param sj
	 * @param xi
	 * @param xj
	 * @param qi
	 * @param qj
	 * @param bi
	 * @param bj
	 */
	public final native void planeBox(JsArray<ContactEquation> result, Shape si, Shape sj, Vec3 xi, Vec3 xj, Quaternion qi, Quaternion qj, Body bi, Body bj) /*-{
		this.planeBox(result, si, sj, xi, xj, qi, qj, bi, bj);
	}-*/;
	
	/**
	 * @param result
	 * @param si
	 * @param sj
	 * @param xi
	 * @param xj
	 * @param qi
	 * @param qj
	 * @param bi
	 * @param bj
	 */
	public final native void planeConvex(JsArray<ContactEquation> result, Shape si, Shape sj, Vec3 xi, Vec3 xj, Quaternion qi, Quaternion qj, Body bi, Body bj) /*-{
		this.planeConvex(result, si, sj, xi, xj, qi, qj, bi, bj);
	}-*/;
	
	/**
	 * @param result
	 * @param si
	 * @param sj
	 * @param xi
	 * @param xj
	 * @param qi
	 * @param qj
	 * @param bi
	 * @param bj
	 */
	public final native void convexConvex(JsArray<ContactEquation> result, Shape si, Shape sj, Vec3 xi, Vec3 xj, Quaternion qi, Quaternion qj, Body bi, Body bj) /*-{
		this.convexConvex(result, si, sj, xi, xj, qi, qj, bi, bj);
	}-*/;
	
	/**
	 * @param result
	 * @param si
	 * @param sj
	 * @param xi
	 * @param xj
	 * @param qi
	 * @param qj
	 * @param bi
	 * @param bj
	 */
	public final native void particlePlane(JsArray<ContactEquation> result, Shape si, Shape sj, Vec3 xi, Vec3 xj, Quaternion qi, Quaternion qj, Body bi, Body bj) /*-{
		this.particlePlane(result, si, sj, xi, xj, qi, qj, bi, bj);
	}-*/;
	
	/**
	 * @param result
	 * @param si
	 * @param sj
	 * @param xi
	 * @param xj
	 * @param qi
	 * @param qj
	 * @param bi
	 * @param bj
	 */
	public final native void particleSphere(JsArray<ContactEquation> result, Shape si, Shape sj, Vec3 xi, Vec3 xj, Quaternion qi, Quaternion qj, Body bi, Body bj) /*-{
		this.particleSphere(result, si, sj, xi, xj, qi, qj, bi, bj);
	}-*/;
	
	/**
	 * @param result
	 * @param si
	 * @param sj
	 * @param xi
	 * @param xj
	 * @param qi
	 * @param qj
	 * @param bi
	 * @param bj
	 */
	public final native void convexParticle(JsArray<ContactEquation> result, Shape si, Shape sj, Vec3 xi, Vec3 xj, Quaternion qi, Quaternion qj, Body bi, Body bj) /*-{
		this.convexParticle(result, si, sj, xi, xj, qi, qj, bi, bj);
	}-*/;
	
	public final native void convexHeightfield() /*-{
		this.convexHeightfield();
	}-*/;
	
	public final native void sphereHeightfield() /*-{
		this.sphereHeightfield();
	}-*/;
	
}
