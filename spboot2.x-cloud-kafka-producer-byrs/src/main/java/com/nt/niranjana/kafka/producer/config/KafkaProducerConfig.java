package com.nt.niranjana.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig
{
	//create new topic and also create partitions
	@Bean
	public NewTopic randomNumberTopic()
	{
		return new NewTopic(AppConstants.RANDOM_NUMBER_TOPIC_NAME, 5, (short)1);
	}
	
	@Bean
	public NewTopic userMessageTopic()
	{
		return new NewTopic(AppConstants.USERMESSAGE_TOPIC_NAME, 5, (short)1);
	}
	
	@Bean
	public NewTopic patientPojoTopic()
	{
		return new NewTopic(AppConstants.PATIENTPOJO_TOPIC_NAME, 5, (short)1);
	}

}

//here 5 --->number of message size
//(short)1---->number of consumers