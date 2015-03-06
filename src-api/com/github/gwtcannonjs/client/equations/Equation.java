// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.equations;

import com.github.gwtcannonjs.client.math.JacobianElement;
import com.github.gwtcannonjs.client.objects.Body;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Equation base class
 */
public class Equation extends JavaScriptObject {
	protected Equation() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native double getMinForce() /*-{
		return this.minForce;
	}-*/;
	
	public final native void setMinForce(double minForce) /*-{
		this.minForce = minForce;
	}-*/;
	
	public final native Equation withMinForce(double minForce) /*-{
		this.minForce = minForce;
		return this;
	}-*/;
	
	public final native double getMaxForce() /*-{
		return this.maxForce;
	}-*/;
	
	public final native void setMaxForce(double maxForce) /*-{
		this.maxForce = maxForce;
	}-*/;
	
	public final native Equation withMaxForce(double maxForce) /*-{
		this.maxForce = maxForce;
		return this;
	}-*/;
	
	public final native Body getBi() /*-{
		return this.bi;
	}-*/;
	
	public final native void setBi(Body bi) /*-{
		this.bi = bi;
	}-*/;
	
	public final native Equation withBi(Body bi) /*-{
		this.bi = bi;
		return this;
	}-*/;
	
	public final native Body getBj() /*-{
		return this.bj;
	}-*/;
	
	public final native void setBj(Body bj) /*-{
		this.bj = bj;
	}-*/;
	
	public final native Equation withBj(Body bj) /*-{
		this.bj = bj;
		return this;
	}-*/;
	
	/**
	 * SPOOK parameter
	 */
	public final native double getA() /*-{
		return this.a;
	}-*/;
	
	/**
	 * SPOOK parameter
	 */
	public final native void setA(double a) /*-{
		this.a = a;
	}-*/;
	
	/**
	 * SPOOK parameter
	 */
	public final native Equation withA(double a) /*-{
		this.a = a;
		return this;
	}-*/;
	
	/**
	 * SPOOK parameter
	 */
	public final native double getB() /*-{
		return this.b;
	}-*/;
	
	/**
	 * SPOOK parameter
	 */
	public final native void setB(double b) /*-{
		this.b = b;
	}-*/;
	
	/**
	 * SPOOK parameter
	 */
	public final native Equation withB(double b) /*-{
		this.b = b;
		return this;
	}-*/;
	
	/**
	 * SPOOK parameter
	 */
	public final native double getEps() /*-{
		return this.eps;
	}-*/;
	
	/**
	 * SPOOK parameter
	 */
	public final native void setEps(double eps) /*-{
		this.eps = eps;
	}-*/;
	
	/**
	 * SPOOK parameter
	 */
	public final native Equation withEps(double eps) /*-{
		this.eps = eps;
		return this;
	}-*/;
	
	public final native JacobianElement getJacobianElementA() /*-{
		return this.jacobianElementA;
	}-*/;
	
	public final native void setJacobianElementA(JacobianElement jacobianElementA) /*-{
		this.jacobianElementA = jacobianElementA;
	}-*/;
	
	public final native Equation withJacobianElementA(JacobianElement jacobianElementA) /*-{
		this.jacobianElementA = jacobianElementA;
		return this;
	}-*/;
	
	public final native JacobianElement getJacobianElementB() /*-{
		return this.jacobianElementB;
	}-*/;
	
	public final native void setJacobianElementB(JacobianElement jacobianElementB) /*-{
		this.jacobianElementB = jacobianElementB;
	}-*/;
	
	public final native Equation withJacobianElementB(JacobianElement jacobianElementB) /*-{
		this.jacobianElementB = jacobianElementB;
		return this;
	}-*/;
	
	/**
	 * Recalculates a,b,eps.
	 */
	public final native void setSpookParams() /*-{
		this.setSpookParams();
	}-*/;
	
	/**
	 * Computes the RHS of the SPOOK equation
	 */
	public final native double computeB() /*-{
		return this.computeB();
	}-*/;
	
	/**
	 * Computes G*q, where q are the generalized body coordinates
	 */
	public final native double computeGq() /*-{
		return this.computeGq();
	}-*/;
	
	/**
	 * Computes G*W, where W are the body velocities
	 */
	public final native double computeGW() /*-{
		return this.computeGW();
	}-*/;
	
	/**
	 * Computes G*Wlambda, where W are the body velocities
	 */
	public final native double computeGWlambda() /*-{
		return this.computeGWlambda();
	}-*/;
	
	/**
	 * Computes G*inv(M)*f, where M is the mass matrix with diagonal blocks for each body, and f are the forces on the bodies.
	 */
	public final native double computeGiMf() /*-{
		return this.computeGiMf();
	}-*/;
	
	/**
	 * Computes G*inv(M)*G'
	 */
	public final native double computeGiMGt() /*-{
		return this.computeGiMGt();
	}-*/;
	
	/**
	 * Add constraint velocity to the bodies.
	 * @param deltalambda
	 */
	public final native void addToWlambda(double deltalambda) /*-{
		this.addToWlambda(deltalambda);
	}-*/;
	
	/**
	 * Compute the denominator part of the SPOOK equation: C = G*inv(M)*G' + eps
	 * @param eps
	 */
	public final native double computeInvC(double eps) /*-{
		return this.computeInvC(eps);
	}-*/;
	
}
