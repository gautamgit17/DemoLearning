package com.test.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringDemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringDemoApplication.class);
	@Value("${spring.application.name:SpringTesT}")
	private String name;
	
	public static void main(String[] args) {
		 logger.info("this is a info message");
	     logger.warn("this is a warn message");
		SpringApplication.run(SpringDemoApplication.class, args);
	}
	
	@RequestMapping(value="/helo")
	public String HelloWorld() {
		return name;
		
	}

}
