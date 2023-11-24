package com.nt.niranjana.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService 
{
	
	@JmsListener(destination = "${my.app.destination-name}")
	public void readMessage(String message)
	{
		System.out.println("MESSAGE RECEIVED FROM PRODUCER "+message);
	}

}
