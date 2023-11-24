package com.nt.niranjana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Spboot2xCloudConfigServerByrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spboot2xCloudConfigServerByrsApplication.class, args);
	}

}
