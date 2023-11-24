package com.nt.niranjana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Spboot2xCloudActivemqPubsubConsumerByrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spboot2xCloudActivemqPubsubConsumerByrsApplication.class, args);
	}

}
