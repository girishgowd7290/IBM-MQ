package com.ggbs.ibm.mq.java;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QaMsgReceiver {
	
	@JmsListener(destination = "DEV.QUEUE.1")
	public void receiveQaMessage(String message) {
		System.out.println("Received: " + message);
	}
} 