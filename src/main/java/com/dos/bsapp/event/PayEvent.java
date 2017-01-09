package com.dos.bsapp.event;

import org.springframework.context.ApplicationEvent;

public class PayEvent extends ApplicationEvent {

	public PayEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}


	private static final long serialVersionUID = 1L;


	public PayEvent(String portTitle, String appTitle, String appSeriesNumber, String unitSeriesNumber) {
        super(portTitle);
    }


}
