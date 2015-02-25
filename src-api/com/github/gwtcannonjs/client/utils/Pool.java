package com.github.gwtcannonjs.client.utils;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * For pooling objects that can be reused.
 */
public class Pool<T extends JavaScriptObject> extends JavaScriptObject {
	protected Pool() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * The pooled objects
	 */
	public final native JsArray<T> getObjects() /*-{
		return this.objects;
	}-*/;
	
	/**
	 * The pooled objects
	 */
	public final native void setObjects(JsArray<T> objects) /*-{
		this.objects = objects;
	}-*/;
	
	/**
	 * The pooled objects
	 */
	public final native Pool<T> withObjects(JsArray<T> objects) /*-{
		this.objects = objects;
		return this;
	}-*/;
	
	/**
	 * Constructor of the objects
	 */
	public final native JavaScriptObject getType() /*-{
		return this.type;
	}-*/;
	
	/**
	 * Constructor of the objects
	 */
	public final native void setType(JavaScriptObject type) /*-{
		this.type = type;
	}-*/;
	
	/**
	 * Constructor of the objects
	 */
	public final native Pool<T> withType(JavaScriptObject type) /*-{
		this.type = type;
		return this;
	}-*/;
	
	/**
	 * Release an object after use
	 * @param obj
	 */
	public final native void release(T obj) /*-{
		this.release(obj);
	}-*/;
	
	/**
	 * Get an object
	 */
	public final native T get() /*-{
		return this.get();
	}-*/;
	
	/**
	 * Construct an object. Should be implmented in each subclass.
	 */
	public final native T constructObject() /*-{
		return this.constructObject();
	}-*/;
	
}
