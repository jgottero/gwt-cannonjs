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
    
    @Source("CallbacksDemo.java")
    TextResource callbacksDemo();

    @Source("CollisionFilterDemo.java")
    TextResource collisionFilterDemo();
    
    @Source("ContainerDemo.java")
    TextResource containerDemo();
    
    @Source("FixedRotationDemo.java")
    TextResource fixedRotationDemo();
    
    @Source("RaycastVehicleDemo.java")
    TextResource raycastVehicleDemo();
    
    @Source("SphDemo.java")
    TextResource sphDemo();
}
