package com.nt.niranjana.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean
	public RestTemplate rt() {
		return new RestTemplate();
	}

	//Zipkin client collects data from sleuth and send to zipkin server(this is old version configuration)
	/*
	@Bean
	public Sampler configSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}*/
	
}