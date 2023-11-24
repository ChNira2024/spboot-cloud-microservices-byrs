package com.nt.niranjana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Spboot2xCloudGatewayServiceByrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spboot2xCloudGatewayServiceByrsApplication.class, args);
	}

}
