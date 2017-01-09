package com.dos.bsapp.event;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PayEventListener implements ApplicationListener<PayEvent> {

	@Override
	public void onApplicationEvent(PayEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
