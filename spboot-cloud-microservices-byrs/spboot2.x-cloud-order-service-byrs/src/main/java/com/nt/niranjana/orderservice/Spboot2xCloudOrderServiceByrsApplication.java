package com.nt.niranjana.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SuppressWarnings("deprecation")
@SpringBootApplication
//@EnableEurekaClient
//@EnableCircuitBreaker
@EnableFeignClients
public class Spboot2xCloudOrderServiceByrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spboot2xCloudOrderServiceByrsApplication.class, args);
	}

}
