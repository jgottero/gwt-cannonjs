package com.github.gwtcannonjs.client.solver;

import com.github.gwtcannonjs.client.equations.Equation;
import com.github.gwtcannonjs.client.world.World;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Constraint equation solver base class.
 */
public class Solver extends JavaScriptObject {
	protected Solver() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * All equations to be solved
	 */
	public final native JsArray<? extends Equation> getEquations() /*-{
		return this.equations;
	}-*/;
	
	/**
	 * All equations to be solved
	 */
	public final native void setEquations(JsArray<? extends Equation> equations) /*-{
		this.equations = equations;
	}-*/;
	
	/**
	 * All equations to be solved
	 */
	public final native Solver withEquations(JsArray<? extends Equation> equations) /*-{
		this.equations = equations;
		return this;
	}-*/;
	
	/**
	 * Should be implemented in subclasses!
	 * @param dt
	 * @param world
	 */
	public final native void solve(double dt, World world) /*-{
		this.solve(dt, world);
	}-*/;
	
	/**
	 * Add an equation
	 * @param eq
	 */
	public final native void addEquation(Equation eq) /*-{
		this.addEquation(eq);
	}-*/;
	
	/**
	 * Remove an equation
	 * @param eq
	 */
	public final native void removeEquation(Equation eq) /*-{
		this.removeEquation(eq);
	}-*/;
	
	/**
	 * Add all equations
	 */
	public final native void removeAllEquations() /*-{
		this.removeAllEquations();
	}-*/;
	
}
