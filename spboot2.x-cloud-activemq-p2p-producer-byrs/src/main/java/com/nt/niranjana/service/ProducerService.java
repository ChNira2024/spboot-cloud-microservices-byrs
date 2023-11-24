package com.nt.niranjana.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class ProducerService 
{
	@Autowired
	private JmsTemplate jt;   //jt is a class and its method is send(destination,messageCreator)
	
	@Value("${my.app.destination-name}")
	private String destination;
	
	public void sendMessage(String message)
	{
		//jt.send(destination,session->session.createTextMessage(message)); //use lambda or
		jt.send(destination,new MessageCreator() 
							{
								@Override
								public Message createMessage(Session session) throws JMSException 
								{
									TextMessage tm =  session.createTextMessage(message);
									return tm;
								}
							});
		
		System.out.println("MESSAGE SENT FROM PRODUCER "+message);
	}

}
