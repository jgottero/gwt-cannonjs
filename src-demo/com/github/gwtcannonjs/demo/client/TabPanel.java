package com.github.gwtcannonjs.demo.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class TabPanel extends Composite implements HasSelectionHandlers<Integer> {
    protected final FlowPanel tabPanel;
    protected final FlowPanel tabBar;
    protected final FlowPanel container;
    
    public TabPanel() {
        this.tabBar = new FlowPanel();
        this.tabBar.addStyleName("tab-bar");
        
        this.container = new FlowPanel();
        this.container.addStyleName("tab-panel-container");
        
        this.tabPanel = new FlowPanel();
        this.tabPanel.addStyleName("tab-panel");
        this.tabPanel.add(tabBar);
        this.tabPanel.add(container);
        
        initWidget(this.tabPanel);
    }
    
    public void add(Widget widget, String text) {
        final int index = container.getWidgetCount();
        
        Label tabWidget = new Label(text);
        tabWidget.addStyleName("tab");
        tabWidget.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                selectTab(index, true);
            }
        });
        tabBar.add(tabWidget);
        container.add(widget);
        
        if (index == 0) {
            selectTab(0, false);
        }
    }
    
    public void selectTab(int index, boolean fireEvent) {
        for (int i = 0; i < tabBar.getWidgetCount(); i++) {
            if (i == index) {
                tabBar.getWidget(i).addStyleName("tab-selected");
            } else {
                tabBar.getWidget(i).removeStyleName("tab-selected");
            }
            container.getWidget(i).setVisible(i == index);
        }
        if (fireEvent) {
            SelectionEvent.fire(this, index);
        }
    }
    
    @Override
    public HandlerRegistration addSelectionHandler(
            SelectionHandler<Integer> handler) {
        return addHandler(handler, SelectionEvent.getType());
    }
}
