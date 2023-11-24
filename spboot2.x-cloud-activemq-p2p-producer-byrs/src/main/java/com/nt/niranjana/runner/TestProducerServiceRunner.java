package com.nt.niranjana.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nt.niranjana.service.ProducerService;

@Component
public class TestProducerServiceRunner //implements CommandLineRunner 
{

	@Autowired
	private ProducerService service;
	
	/*
	@Override
	public void run(String... args) throws Exception
	{
		service.sendMessage("Hi Everyone,Today is "+new Date());
	}
	*/
	
	@Scheduled(cron ="*/15 * * * * *")
	public void sendMessage()throws Exception
	{
		service.sendMessage("Hi Everyone,Today is "+new Date());

	}

}
//2 way 1)using simple 2)mostly use with using scheduling