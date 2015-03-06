// The MIT License (MIT)
// Copyright (c) 2015 Jérémie Gottero

package com.github.gwtcannonjs.client.utils;

import com.github.gwtcannonjs.client.equations.ContactEquation;
import com.github.gwtcannonjs.client.objects.Body;

public class CollideEvent extends Event {
	protected CollideEvent() {
		// A JavaScriptObject cannot be created directly
	}
	
	public final native Body getBody() /*-{
		return this.body;
	}-*/;
	
	public final native void setBody(Body body) /*-{
		this.body = body;
	}-*/;
	
	public final native CollideEvent withBody(Body body) /*-{
		this.body = body;
		return this;
	}-*/;
	
	public final native ContactEquation getContact() /*-{
		return this.contact;
	}-*/;
	
	public final native void setContact(ContactEquation contact) /*-{
		this.contact = contact;
	}-*/;
	
	public final native CollideEvent withContact(ContactEquation contact) /*-{
		this.contact = contact;
		return this;
	}-*/;
	
}
