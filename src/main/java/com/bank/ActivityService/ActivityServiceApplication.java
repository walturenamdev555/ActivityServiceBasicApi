package com.bank.ActivityService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan({"com.example"})
@SpringBootApplication
public class ActivityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityServiceApplication.class, args);
	}

}
