package com.nt.niranjana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class Spboot2xCloudAdminServerByrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spboot2xCloudAdminServerByrsApplication.class, args);
	}

}
