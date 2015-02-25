package com.github.gwtcannonjs.client.demo;

import com.google.gwt.core.client.JavaScriptObject;

public class DemoOptions extends JavaScriptObject {
	protected DemoOptions() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native int getStepFrequency() /*-{
		return this.stepFrequency;
	}-*/;
	
	public final native void setStepFrequency(int stepFrequency) /*-{
		this.stepFrequency = stepFrequency;
	}-*/;
	
	public final native DemoOptions withStepFrequency(int stepFrequency) /*-{
		this.stepFrequency = stepFrequency;
		return this;
	}-*/;
	
	public final native double getQuatNormalizeSkip() /*-{
		return this.quatNormalizeSkip;
	}-*/;
	
	public final native void setQuatNormalizeSkip(double quatNormalizeSkip) /*-{
		this.quatNormalizeSkip = quatNormalizeSkip;
	}-*/;
	
	public final native DemoOptions withQuatNormalizeSkip(double quatNormalizeSkip) /*-{
		this.quatNormalizeSkip = quatNormalizeSkip;
		return this;
	}-*/;
	
	public final native boolean isQuatNormalizeFast() /*-{
		return this.quatNormalizeFast;
	}-*/;
	
	public final native void setQuatNormalizeFast(boolean quatNormalizeFast) /*-{
		this.quatNormalizeFast = quatNormalizeFast;
	}-*/;
	
	public final native DemoOptions withQuatNormalizeFast(boolean quatNormalizeFast) /*-{
		this.quatNormalizeFast = quatNormalizeFast;
		return this;
	}-*/;
	
	public final native double getGx() /*-{
		return this.gx;
	}-*/;
	
	public final native void setGx(double gx) /*-{
		this.gx = gx;
	}-*/;
	
	public final native DemoOptions withGx(double gx) /*-{
		this.gx = gx;
		return this;
	}-*/;
	
	public final native double getGy() /*-{
		return this.gy;
	}-*/;
	
	public final native void setGy(double gy) /*-{
		this.gy = gy;
	}-*/;
	
	public final native DemoOptions withGy(double gy) /*-{
		this.gy = gy;
		return this;
	}-*/;
	
	public final native double getGz() /*-{
		return this.gz;
	}-*/;
	
	public final native void setGz(double gz) /*-{
		this.gz = gz;
	}-*/;
	
	public final native DemoOptions withGz(double gz) /*-{
		this.gz = gz;
		return this;
	}-*/;
	
	public final native int getIterations() /*-{
		return this.iterations;
	}-*/;
	
	public final native void setIterations(int iterations) /*-{
		this.iterations = iterations;
	}-*/;
	
	public final native DemoOptions withIterations(int iterations) /*-{
		this.iterations = iterations;
		return this;
	}-*/;
	
	public final native double getTolerance() /*-{
		return this.tolerance;
	}-*/;
	
	public final native void setTolerance(double tolerance) /*-{
		this.tolerance = tolerance;
	}-*/;
	
	public final native DemoOptions withTolerance(double tolerance) /*-{
		this.tolerance = tolerance;
		return this;
	}-*/;
	
	public final native double getK() /*-{
		return this.k;
	}-*/;
	
	public final native void setK(double k) /*-{
		this.k = k;
	}-*/;
	
	public final native DemoOptions withK(double k) /*-{
		this.k = k;
		return this;
	}-*/;
	
	public final native double getD() /*-{
		return this.d;
	}-*/;
	
	public final native void setD(double d) /*-{
		this.d = d;
	}-*/;
	
	public final native DemoOptions withD(double d) /*-{
		this.d = d;
		return this;
	}-*/;
	
	public final native int getScene() /*-{
		return this.scene;
	}-*/;
	
	public final native void setScene(int scene) /*-{
		this.scene = scene;
	}-*/;
	
	public final native DemoOptions withScene(int scene) /*-{
		this.scene = scene;
		return this;
	}-*/;
	
	public final native boolean isPaused() /*-{
		return this.paused;
	}-*/;
	
	public final native void setPaused(boolean paused) /*-{
		this.paused = paused;
	}-*/;
	
	public final native DemoOptions withPaused(boolean paused) /*-{
		this.paused = paused;
		return this;
	}-*/;
	
	public final native String getRendermode() /*-{
		return this.rendermode;
	}-*/;
	
	public final native void setRendermode(String rendermode) /*-{
		this.rendermode = rendermode;
	}-*/;
	
	public final native DemoOptions withRendermode(String rendermode) /*-{
		this.rendermode = rendermode;
		return this;
	}-*/;
	
	public final native boolean isConstraints() /*-{
		return this.constraints;
	}-*/;
	
	public final native void setConstraints(boolean constraints) /*-{
		this.constraints = constraints;
	}-*/;
	
	public final native DemoOptions withConstraints(boolean constraints) /*-{
		this.constraints = constraints;
		return this;
	}-*/;
	
	public final native boolean isContacts() /*-{
		return this.contacts;
	}-*/;
	
	public final native void setContacts(boolean contacts) /*-{
		this.contacts = contacts;
	}-*/;
	
	public final native DemoOptions withContacts(boolean contacts) /*-{
		this.contacts = contacts;
		return this;
	}-*/;
	
	public final native boolean isCm2contact() /*-{
		return this.cm2contact;
	}-*/;
	
	public final native void setCm2contact(boolean cm2contact) /*-{
		this.cm2contact = cm2contact;
	}-*/;
	
	public final native DemoOptions withCm2contact(boolean cm2contact) /*-{
		this.cm2contact = cm2contact;
		return this;
	}-*/;
	
	public final native boolean isNormals() /*-{
		return this.normals;
	}-*/;
	
	public final native void setNormals(boolean normals) /*-{
		this.normals = normals;
	}-*/;
	
	public final native DemoOptions withNormals(boolean normals) /*-{
		this.normals = normals;
		return this;
	}-*/;
	
	public final native boolean isAxes() /*-{
		return this.axes;
	}-*/;
	
	public final native void setAxes(boolean axes) /*-{
		this.axes = axes;
	}-*/;
	
	public final native DemoOptions withAxes(boolean axes) /*-{
		this.axes = axes;
		return this;
	}-*/;
	
	public final native double getParticleSize() /*-{
		return this.particleSize;
	}-*/;
	
	public final native void setParticleSize(double particleSize) /*-{
		this.particleSize = particleSize;
	}-*/;
	
	public final native DemoOptions withParticleSize(double particleSize) /*-{
		this.particleSize = particleSize;
		return this;
	}-*/;
	
	public final native boolean isShadows() /*-{
		return this.shadows;
	}-*/;
	
	public final native void setShadows(boolean shadows) /*-{
		this.shadows = shadows;
	}-*/;
	
	public final native DemoOptions withShadows(boolean shadows) /*-{
		this.shadows = shadows;
		return this;
	}-*/;
	
	public final native boolean isAabbs() /*-{
		return this.aabbs;
	}-*/;
	
	public final native void setAabbs(boolean aabbs) /*-{
		this.aabbs = aabbs;
	}-*/;
	
	public final native DemoOptions withAabbs(boolean aabbs) /*-{
		this.aabbs = aabbs;
		return this;
	}-*/;
	
	public final native boolean isProfiling() /*-{
		return this.profiling;
	}-*/;
	
	public final native void setProfiling(boolean profiling) /*-{
		this.profiling = profiling;
	}-*/;
	
	public final native DemoOptions withProfiling(boolean profiling) /*-{
		this.profiling = profiling;
		return this;
	}-*/;
	
	public final native int getMaxSubSteps() /*-{
		return this.maxSubSteps;
	}-*/;
	
	public final native void setMaxSubSteps(int maxSubSteps) /*-{
		this.maxSubSteps = maxSubSteps;
	}-*/;
	
	public final native DemoOptions withMaxSubSteps(int maxSubSteps) /*-{
		this.maxSubSteps = maxSubSteps;
		return this;
	}-*/;
	
}
