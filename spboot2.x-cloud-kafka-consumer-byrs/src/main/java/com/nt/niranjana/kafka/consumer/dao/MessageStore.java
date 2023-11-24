package com.nt.niranjana.kafka.consumer.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.niranjana.kafka.consumer.model.Patient;
import com.nt.niranjana.kafka.consumer.repo.PatientKafkaRepo;

@Component
public class MessageStore 
{
	
	private static final Logger LOG = LoggerFactory.getLogger(MessageStore.class);
	
	@Autowired
	private PatientKafkaRepo repo;
	
	public void addMessage(Patient msg){
		msg=repo.save(msg);
		LOG.info("MESSAGE IS STORED AT DATABASE {}",msg.getPid());
	}
	
	public List<Patient> getAllMessages() {
		LOG.info("FETCHING MESSAGES FROM DATABASE");
		return repo.findAll();
	}
}