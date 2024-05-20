package com.ifsp.trabalhoAPI.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.ifsp.trabalhoAPI.models")
@SpringBootApplication
public class ApiDeViagensApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDeViagensApplication.class, args);
	}

}
