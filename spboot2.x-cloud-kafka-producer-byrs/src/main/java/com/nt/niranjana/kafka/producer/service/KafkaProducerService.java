package com.nt.niranjana.kafka.producer.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.nt.niranjana.kafka.producer.config.AppConstants;
import com.nt.niranjana.kafka.producer.model.Patient;

@Service
public class KafkaProducerService 
{
	private static Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
	
	@Value("${my.kafka-tpc-name}")
	private String topic;
	
	//using kafkatemplate we can send msg to consumer
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate2;
	
	public boolean generateRandomNumber(String number)
	{
		kafkaTemplate.send(AppConstants.RANDOM_NUMBER_TOPIC_NAME,number);
		logger.info("Producer produce random number{}: ",number);
		return true;
	}
	
	public void sendMessageToTopic(String message)
	{
		logger.info("Producer produce message{}: ",message);
		CompletableFuture<SendResult<String, Object>> future= (CompletableFuture<SendResult<String, Object>>) kafkaTemplate2.send(AppConstants.USERMESSAGE_TOPIC_NAME, message);
		future.whenComplete((result,ex)->
		{
			if (ex == null) 
			{
                System.out.println("Producer produce message=["+ message +"] with offset=[" + result.getRecordMetadata().offset() + "]");
            } 
			else 
			{
                System.out.println("Unable to Producer produce message=["+ message + "] due to : " + ex.getMessage());
            }
		});
	}
	
	public void sendPojoToTopic(Patient patient)
	{
		logger.info("Producer produce Patient pojo{}: ",patient);
		
		try {
			CompletableFuture<SendResult<String, Object>> future= (CompletableFuture<SendResult<String, Object>>) kafkaTemplate2.send(AppConstants.PATIENTPOJO_TOPIC_NAME, patient);
			future.whenComplete((result,ex)->
			{
				if (ex == null) 
				{
	                System.out.println("Producer produce patientPojo=["+ patient +"] with offset=[" + result.getRecordMetadata().offset() + "]");
	            } 
				else 
				{
	                System.out.println("Unable to Producer produce patientPojo=["+ patient + "] due to : " + ex.getMessage());
	            }
			});
		}
		catch(Exception e)
		{
			logger.info("Unable to Producer produce patientPojo{}: "+e.getMessage());
		}
		
	}
	
	
	public void send(String message) 
	{
		logger.info("SENDING MESSAGE TO KAFKA RUNTIME");
		kafkaTemplate2.send(topic, message);
		logger.info("SENDT SUCCESFULLY FROM PRODUCER!!");
	}
	

}
