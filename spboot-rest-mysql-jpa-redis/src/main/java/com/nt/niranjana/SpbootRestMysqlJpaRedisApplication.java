package com.nt.niranjana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpbootRestMysqlJpaRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpbootRestMysqlJpaRedisApplication.class, args);
	}

}
