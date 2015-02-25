package com.github.gwtcannonjs.client.demo;

import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.world.World;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Demo framework class. If you want to learn how to connect Cannon.js with Three.js, please look at the examples/ instead.
 */
public class Demo extends JavaScriptObject {
	protected Demo() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Add a scene to the demo app
	 * @param title Title of the scene
	 * @param initfunc A function that takes one argument, app, and initializes a physics scene. The function runs app.setWorld(body), app.addVisual(body), app.removeVisual(body) etc.
	 */
	public final native void addScene(String title, AddSceneCallback initfunc) /*-{
		var initfunc__callback = (initfunc ? function() { initfunc.@com.github.gwtcannonjs.client.demo.AddSceneCallback::execute()(); } : undefined);
		if (this.initfunc__store === undefined) { this.initfunc__store = {}; } this.initfunc__store[initfunc] = initfunc__callback;
		this.addScene(title, initfunc__callback);
	}-*/;
	
	/**
	 * Restarts the current scene
	 */
	public final native void restartCurrentScene() /*-{
		this.restartCurrentScene();
	}-*/;
	
	public final native void start() /*-{
		this.start();
	}-*/;
	
	public final native void addVisual(Body body) /*-{
		this.addVisual(body);
	}-*/;
	
	public final native World getWorld() /*-{
		return this.getWorld();
	}-*/;
	
}
