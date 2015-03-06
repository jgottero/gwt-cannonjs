// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.world;

import com.google.gwt.core.client.JavaScriptObject;

public class Profile extends JavaScriptObject {
	protected Profile() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native double getSolve() /*-{
		return this.solve;
	}-*/;
	
	public final native void setSolve(double solve) /*-{
		this.solve = solve;
	}-*/;
	
	public final native Profile withSolve(double solve) /*-{
		this.solve = solve;
		return this;
	}-*/;
	
	public final native double getMakeContactConstraints() /*-{
		return this.makeContactConstraints;
	}-*/;
	
	public final native void setMakeContactConstraints(double makeContactConstraints) /*-{
		this.makeContactConstraints = makeContactConstraints;
	}-*/;
	
	public final native Profile withMakeContactConstraints(double makeContactConstraints) /*-{
		this.makeContactConstraints = makeContactConstraints;
		return this;
	}-*/;
	
	public final native double getBroadphase() /*-{
		return this.broadphase;
	}-*/;
	
	public final native void setBroadphase(double broadphase) /*-{
		this.broadphase = broadphase;
	}-*/;
	
	public final native Profile withBroadphase(double broadphase) /*-{
		this.broadphase = broadphase;
		return this;
	}-*/;
	
	public final native double getIntegrate() /*-{
		return this.integrate;
	}-*/;
	
	public final native void setIntegrate(double integrate) /*-{
		this.integrate = integrate;
	}-*/;
	
	public final native Profile withIntegrate(double integrate) /*-{
		this.integrate = integrate;
		return this;
	}-*/;
	
	public final native double getNarrowphase() /*-{
		return this.narrowphase;
	}-*/;
	
	public final native void setNarrowphase(double narrowphase) /*-{
		this.narrowphase = narrowphase;
	}-*/;
	
	public final native Profile withNarrowphase(double narrowphase) /*-{
		this.narrowphase = narrowphase;
		return this;
	}-*/;
	
}
