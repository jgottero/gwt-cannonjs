/* The MIT License (MIT)
 * 
 * Copyright (c) 2015 Jérémie Gottero
 */

package com.github.gwtcannonjs.demo.client.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface SourceCodeBundle extends ClientBundle {
    public static final SourceCodeBundle INSTANCE = GWT.create(SourceCodeBundle.class);
    
    @Source("BodyTypesDemo.java")
    TextResource bodyTypesDemo();
    
    @Source("BounceDemo.java")
    TextResource bounceDemo();
    
    @Source("BunnyDemo.java")
    TextResource bunnyDemo();
    
    @Source("CallbacksDemo.java")
    TextResource callbacksDemo();

    @Source("CollisionFilterDemo.java")
    TextResource collisionFilterDemo();
    
    @Source("CollisionsDemo.java")
    TextResource collisionsDemo();
    
    @Source("ContainerDemo.java")
    TextResource containerDemo();
    
    @Source("CompoundDemo.java")
    TextResource compoundDemo();

    @Source("ConstraintsDemo.java")
    TextResource constraintsDemo();

    @Source("ConvexDemo.java")
    TextResource convexDemo();

    @Source("EventsDemo.java")
    TextResource eventsDemo();
    
    @Source("FixedRotationDemo.java")
    TextResource fixedRotationDemo();

    @Source("FrictionDemo.java")
    TextResource frictionDemo();

    @Source("HeightfieldDemo.java")
    TextResource heightfieldDemo();

    @Source("HingeDemo.java")
    TextResource hingeDemo();
    
    @Source("ImpulsesDemo.java")
    TextResource impulsesDemo();
    
    @Source("PileDemo.java")
    TextResource pileDemo();
    
    @Source("RaycastVehicleDemo.java")
    TextResource raycastVehicleDemo();
    
    @Source("RigidVehicleDemo.java")
    TextResource rigidVehicleDemo();
    
    @Source("ShapesDemo.java")
    TextResource shapesDemo();
    
    @Source("SingleBodyOnPlaneDemo.java")
    TextResource singleBodyOnPlaneDemo();
    
    @Source("SleepDemo.java")
    TextResource sleepDemo();
    
    @Source("SphDemo.java")
    TextResource sphDemo();
    
    @Source("SplitSolverDemo.java")
    TextResource splitSolverDemo();
    
    @Source("SpringDemo.java")
    TextResource springDemo();
    
    @Source("StacksDemo.java")
    TextResource stacksDemo();
}
