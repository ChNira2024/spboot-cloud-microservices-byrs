package com.nt.niranjana.kafka.producer.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.niranjana.kafka.producer.dao.MessageStore;
import com.nt.niranjana.kafka.producer.model.Patient;
import com.nt.niranjana.kafka.producer.service.KafkaProducerService;

@RestController
@RequestMapping("/producer-app")
public class KafkaEventController  
{
	private static final Logger LOG = LoggerFactory.getLogger(KafkaEventController.class);
	
	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	
	@Autowired
	private MessageStore store;
	
	@PostMapping("/randomNumber")
	public ResponseEntity<?> updateLocation(String location)
	{
		for(int i=1;i<=100;i++)
		{
			kafkaProducerService.generateRandomNumber(" "+Math.round(Math.random()*100)+","+Math.round(Math.random()*100));
		}
		return new ResponseEntity(Map.of("message","generate random number succesfully"),HttpStatus.OK);
	}
	
	@GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) 
	{
        try 
        {
            for (int i = 0; i<= 10; i++) 
            {
            	kafkaProducerService.sendMessageToTopic(message + " : " + i);
            }
            return ResponseEntity.ok("message published successfully ..");
        } 
        catch (Exception ex) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	@PostMapping("/patientData")
    public ResponseEntity<?> publishPatientPojo(@RequestBody Patient patient) 
	{
        
            	kafkaProducerService.sendPojoToTopic(patient);
            	return ResponseEntity.ok("Producer published Patient pojo data successfully ..");
    }

	@GetMapping("/send/{msg}")
	public ResponseEntity<String> sendMessage(@PathVariable String msg) 
	{
		ResponseEntity<String> resp = null;
		LOG.info("REST CONTROLLER IS ABOUT TO SEND MESSAGE");
		try 
		{
			kafkaProducerService.send(msg);
			LOG.info("REST CONTROLLER FINISHED SENDING");
			resp = new ResponseEntity<String>("SENT SUCCESSFULLY!",	HttpStatus.CREATED);
			
		} 
		catch (Exception e) 
		{
			LOG.error("SENDING FAILED {}",e.getMessage());
			e.printStackTrace();
			resp = new ResponseEntity<String>("UNABLE TO SEND!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOG.info("RETURN FROM REST CONTROLLER  SEND MESSAGE");
		return resp;
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> viewAllMessages()
	{
		LOG.info("ENTERED INTO FETCH ALL MESG");
		ResponseEntity<?> resp = null;
		try 
		{
			List<Patient> list = store.getAllMessages();
			LOG.info("DATA FETCH SUCCESSFUL!");
			resp = new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			LOG.error("FETCHING FAILED {}",e.getMessage());
			e.printStackTrace();
			resp = new ResponseEntity<String>("UNABLE TO FETCH!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
}
