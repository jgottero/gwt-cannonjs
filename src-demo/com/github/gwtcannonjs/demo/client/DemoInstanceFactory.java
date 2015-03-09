/* The MIT License (MIT)
 * 
 * Copyright (c) 2015 Jérémie Gottero
 */

package com.github.gwtcannonjs.demo.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.gwtcannonjs.demo.client.impl.BodyTypesDemo;
import com.github.gwtcannonjs.demo.client.impl.BounceDemo;
import com.github.gwtcannonjs.demo.client.impl.BunnyDemo;
import com.github.gwtcannonjs.demo.client.impl.CallbacksDemo;
import com.github.gwtcannonjs.demo.client.impl.CollisionFilterDemo;
import com.github.gwtcannonjs.demo.client.impl.CollisionsDemo;
import com.github.gwtcannonjs.demo.client.impl.CompoundDemo;
import com.github.gwtcannonjs.demo.client.impl.ConstraintsDemo;
import com.github.gwtcannonjs.demo.client.impl.ContainerDemo;
import com.github.gwtcannonjs.demo.client.impl.ConvexDemo;
import com.github.gwtcannonjs.demo.client.impl.EventsDemo;
import com.github.gwtcannonjs.demo.client.impl.FixedRotationDemo;
import com.github.gwtcannonjs.demo.client.impl.FrictionDemo;
import com.github.gwtcannonjs.demo.client.impl.HeightfieldDemo;
import com.github.gwtcannonjs.demo.client.impl.HingeDemo;
import com.github.gwtcannonjs.demo.client.impl.ImpulsesDemo;
import com.github.gwtcannonjs.demo.client.impl.PileDemo;
import com.github.gwtcannonjs.demo.client.impl.RaycastVehicleDemo;
import com.github.gwtcannonjs.demo.client.impl.RigidVehicleDemo;
import com.github.gwtcannonjs.demo.client.impl.ShapesDemo;
import com.github.gwtcannonjs.demo.client.impl.SingleBodyOnPlaneDemo;
import com.github.gwtcannonjs.demo.client.impl.SleepDemo;
import com.github.gwtcannonjs.demo.client.impl.SphDemo;
import com.github.gwtcannonjs.demo.client.impl.SplitSolverDemo;
import com.github.gwtcannonjs.demo.client.impl.SpringDemo;
import com.github.gwtcannonjs.demo.client.impl.StacksDemo;

public class DemoInstanceFactory {
    private final static DemoInstanceFactory INSTANCE = new DemoInstanceFactory();
    
    private final List<DemoInstance> instances;
    private final Map<String, DemoInstance> instancesMap;
    
    private DemoInstanceFactory() {
        this.instances = Collections.unmodifiableList(createInstances());
        
        this.instancesMap = new HashMap<String, DemoInstance>();
        for (DemoInstance instance : instances) {
            instancesMap.put(instance.getName(), instance);
        }
    }
    
    public List<DemoInstance> getAllInstances() {
        return instances;
    }

    public DemoInstance getInstanceByName(String name) {
        return instancesMap.get(name);
    }
    
    public static DemoInstanceFactory get() {
        return INSTANCE;
    }
    
    private List<DemoInstance> createInstances() {
        List<DemoInstance> instances = new ArrayList<DemoInstance>();
        instances.add(new BodyTypesDemo());
        instances.add(new BounceDemo());
        instances.add(new BunnyDemo());
        instances.add(new CallbacksDemo());
        instances.add(new CollisionFilterDemo());
        instances.add(new CollisionsDemo());
        instances.add(new CompoundDemo());
        instances.add(new ConstraintsDemo());
        instances.add(new ContainerDemo());
        instances.add(new ConvexDemo());
        instances.add(new EventsDemo());
        instances.add(new FixedRotationDemo());
        instances.add(new FrictionDemo());
        instances.add(new HeightfieldDemo());
        instances.add(new HingeDemo());
        instances.add(new ImpulsesDemo());
        instances.add(new PileDemo());
        instances.add(new RaycastVehicleDemo());
        instances.add(new RigidVehicleDemo());
        instances.add(new ShapesDemo());
        instances.add(new SingleBodyOnPlaneDemo());
        instances.add(new SleepDemo());
        instances.add(new SphDemo());
        instances.add(new SplitSolverDemo());
        instances.add(new SpringDemo());
        instances.add(new StacksDemo());
        return instances;
    }
}
