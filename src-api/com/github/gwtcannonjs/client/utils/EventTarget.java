package com.github.gwtcannonjs.client.utils;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Base class for objects that dispatches events.
 */
public class EventTarget extends JavaScriptObject {
	protected EventTarget() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Add an event listener
	 * @param type
	 * @param listener
	 * @return The self object, for chainability.
	 */
	public final native EventTarget addEventListener(String type, EventListener listener) /*-{
		var listener__callback = (listener ? function(event) { listener.@com.github.gwtcannonjs.client.utils.EventListener::onEvent(Lcom/github/gwtcannonjs/client/utils/Event;)(event); } : undefined);
		if (this.listener__store === undefined) { this.listener__store = {}; } this.listener__store[listener] = listener__callback;
		return this.addEventListener(type, listener__callback);
	}-*/;
	
	/**
	 * Check if an event listener is added
	 * @param type
	 * @param listener
	 */
	public final native boolean hasEventListener(String type, EventListener listener) /*-{
		var listener__callback = null; if (this.listener__store !== undefined) { listener__callback = this.listener__store[listener]; }
		return this.hasEventListener(type, listener__callback);
	}-*/;
	
	/**
	 * Remove an event listener
	 * @param type
	 * @param listener
	 * @return The self object, for chainability.
	 */
	public final native EventTarget removeEventListener(String type, EventListener listener) /*-{
		var listener__callback = null; if (this.listener__store !== undefined) { listener__callback = this.listener__store[listener]; delete this.listener__store[listener]; }
		return this.removeEventListener(type, listener__callback);
	}-*/;
	
	/**
	 * Emit an event.
	 * @param event
	 * @return The self object, for chainability.
	 */
	public final native EventTarget dispatchEvent(Event event) /*-{
		return this.dispatchEvent(event);
	}-*/;
	
}
