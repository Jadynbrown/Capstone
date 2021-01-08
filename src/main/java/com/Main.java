package com; 

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Main {
	
	static Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		logger.info("Application Running...");
	}
	
}
