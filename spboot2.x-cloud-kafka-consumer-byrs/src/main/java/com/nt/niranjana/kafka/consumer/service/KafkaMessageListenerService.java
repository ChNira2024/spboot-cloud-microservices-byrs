package com.nt.niranjana.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.nt.niranjana.kafka.consumer.config.AppConstants;
import com.nt.niranjana.kafka.consumer.dto.Patient;

@Service
public class KafkaMessageListenerService
{
	private static Logger logger = LoggerFactory.getLogger(KafkaMessageListenerService.class); 
	
	@KafkaListener(topics=AppConstants.RANDOM_NUMBER_TOPIC_NAME,groupId = AppConstants.RANDOM_NUMBER_GROUPID )
	public void uploadRandomNumber(String value)
	{
			logger.info("Consumer Consume Random Number{}: "+value);
	}
	
	@KafkaListener(topics=AppConstants.USERMESSAGE_TOPIC_NAME,groupId = AppConstants.USERMESSAGE_GROUPID )
	public void uploadUserMessage(String message)
	{
			logger.info("Consumer Consume User Message{}: "+message);
	}
	
	@KafkaListener(topics=AppConstants.PATIENTPOJO_TOPIC_NAME,groupId = AppConstants.PATIENTPOJO_GROUPID )
	public void uploadPatientPojo(Patient patient)
	{
			logger.info("Consumer Consume Patient pojo{}: "+patient.toString());
	}
	

}
