package com.nt.niranjana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpbootCloud2xActivemqP2PConsumerByrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpbootCloud2xActivemqP2PConsumerByrsApplication.class, args);
	}

}
