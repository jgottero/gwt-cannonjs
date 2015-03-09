// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.demo.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.gwtcannonjs.client.CANNON;
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
import com.google.gwt.user.client.ui.Panel;
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

		        String demoToRun = Window.Location.getParameter("demo");
		        
		        if (demoToRun == null) {
		            setup(RootPanel.get());
		        } else {
		            runDemo(demoToRun, RootPanel.get());
		        }
			}
		});
	}
	
	public void runDemo(String name, Panel container) {
        DemoInstance instance = DemoInstanceFactory.get().getInstanceByName(name);
        if (instance == null) {
            container.add(new Label("Demo not found: " + SafeHtmlUtils.htmlEscape(name)));
        } else {
            instance.run();
        }
	}
	
	public void setup(Panel container) {
        final FlowPanel demoContainer = new FlowPanel();
        demoContainer.addStyleName("demo-container");
        
        Label selectDemoLabel = new Label("← Select a demo");
        selectDemoLabel.addStyleName("select-demo");
        demoContainer.add(selectDemoLabel);
        
        FlowPanel menu = new FlowPanel();
        menu.addStyleName("menu");
        
        Label title = new Label("GWT CannonJS");
        title.addStyleName("page-title");
        
        for (final DemoInstance instance : DemoInstanceFactory.get().getAllInstances()) {
            Label item = new Label(instance.getName());
            item.addStyleName("menu-item");
            item.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    demoContainer.clear();
                    
                    final Frame demoFrame = new Frame("index.html?demo=" + URL.encodeQueryString(instance.getName()));
                    HTMLPanel sourceCodeWidget = new HTMLPanel(highlightJava(instance.getSourceCode()));
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
        
        container.add(title);
        container.add(menu);
        container.add(demoContainer);
	}
	
	private static native String highlightJava(String code) /*-{
	    var brush = new $wnd.SyntaxHighlighter.brushes.Java();
        var params = {};
        params['toolbar'] = false;
        brush.init(params);
        return brush.getHtml(code);
    }-*/;
}
