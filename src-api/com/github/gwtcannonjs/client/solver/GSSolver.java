package com.github.gwtcannonjs.client.solver;

/**
 * Constraint equation Gauss-Seidel solver.
 * @see https://www8.cs.umu.se/kurser/5DV058/VT09/lectures/spooknotes.pdf
 */
public class GSSolver extends Solver {
	protected GSSolver() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * The number of solver iterations determines quality of the constraints in the world. The more iterations, the more correct simulation. More iterations need more computations though. If you have a large gravity force in your world, you will need more iterations.
	 */
	public final native double getIterations() /*-{
		return this.iterations;
	}-*/;
	
	/**
	 * The number of solver iterations determines quality of the constraints in the world. The more iterations, the more correct simulation. More iterations need more computations though. If you have a large gravity force in your world, you will need more iterations.
	 */
	public final native void setIterations(double iterations) /*-{
		this.iterations = iterations;
	}-*/;
	
	/**
	 * The number of solver iterations determines quality of the constraints in the world. The more iterations, the more correct simulation. More iterations need more computations though. If you have a large gravity force in your world, you will need more iterations.
	 */
	public final native GSSolver withIterations(double iterations) /*-{
		this.iterations = iterations;
		return this;
	}-*/;
	
	/**
	 * When tolerance is reached, the system is assumed to be converged.
	 */
	public final native double getTolerance() /*-{
		return this.tolerance;
	}-*/;
	
	/**
	 * When tolerance is reached, the system is assumed to be converged.
	 */
	public final native void setTolerance(double tolerance) /*-{
		this.tolerance = tolerance;
	}-*/;
	
	/**
	 * When tolerance is reached, the system is assumed to be converged.
	 */
	public final native GSSolver withTolerance(double tolerance) /*-{
		this.tolerance = tolerance;
		return this;
	}-*/;
	
}
