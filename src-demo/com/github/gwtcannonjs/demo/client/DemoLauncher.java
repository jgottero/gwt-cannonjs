// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.gwtcannonjs.client.CANNON;
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
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class DemoLauncher implements EntryPoint {
	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void onUncaughtException(Throwable e) {
				Logger.getGlobal().log(Level.SEVERE, "Uncaught exception", e);
			}
		});
    	
    	Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				CANNON.injectDemoRuntime();

				init();
			}
		});
	}
	
	private void init() {
		final List<DemoInstance> instances = new ArrayList<DemoInstance>();
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
		
        Map<String, DemoInstance> instancesMap = new HashMap<String, DemoInstance>();
        for (DemoInstance instance : instances) {
            instancesMap.put(instance.getName(), instance);
        }
        
        String demoToRun = Window.Location.getParameter("demo");
        
        if (demoToRun == null) {
            final FlowPanel demoContainer = new FlowPanel();
            demoContainer.addStyleName("demo-container");
            
            Label selectDemoLabel = new Label("← Select a demo");
            selectDemoLabel.addStyleName("select-demo");
            demoContainer.add(selectDemoLabel);
            
            FlowPanel menu = new FlowPanel();
            menu.addStyleName("menu");
            
            Label title = new Label("GWT CannonJS");
            title.addStyleName("page-title");
            
            for (final DemoInstance instance : instances) {
                Label item = new Label(instance.getName());
                item.addStyleName("menu-item");
                item.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        demoContainer.clear();
                        
                        final Frame demoFrame = new Frame("index.html?demo=" + URL.encodeQueryString(instance.getName()));
                        HTMLPanel sourceCodeWidget = new HTMLPanel(highlight(instance.getSourceCode()));
                        sourceCodeWidget.addStyleName("source-code");
                        
                        TabPanel tabPanel = new TabPanel();
                        tabPanel.add(demoFrame, "Demo");
                        tabPanel.add(sourceCodeWidget, "Source code");
                        
                        demoContainer.add(tabPanel);
                        
                        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                            @Override
                            public void execute() {
                                focus(demoFrame.getElement());
                            }
                            
                            private native void focus(Element iframeElement) /*-{
                                iframeElement.contentWindow.focus();
                            }-*/;
                        });
                    }
                });
                menu.add(item);
            }
            
            RootPanel.get().add(title);
            RootPanel.get().add(menu);
            RootPanel.get().add(demoContainer);
        } else {
            DemoInstance instance = instancesMap.get(demoToRun);
            if (instance == null) {
                RootPanel.get().add(new Label("Demo not found: " + SafeHtmlUtils.htmlEscape(demoToRun)));
            } else {
                instance.run();
            }
        }
	}
	
	private static native String highlight(String code) /*-{
	    var brush = new $wnd.SyntaxHighlighter.brushes.Java();
        var params = {};
        params['toolbar'] = false;
        brush.init(params);
        return brush.getHtml(code);
    }-*/;
}
