package com.demo.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
public class ABankingManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ABankingManagementSystemApplication.class, args);
		log.info("A BANKING MANAGEMENT APPLICATION IS STARTED ..................");
	}

}
