package com.ggbs.ibm.mq.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableJms
@SpringBootApplication
public class MqIbmSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqIbmSpringBootApplication.class, args);
	}
	 
	 @Autowired
	 JmsOperations jmsOperations;

	 @GetMapping("/sendMQClient/{message}")
	 public String sendMQClient(@PathVariable String message){
	   jmsOperations.convertAndSend("DEV.QUEUE.1", message);
	   
	   return "Message Sent :: ".concat(message);
	 }

}
