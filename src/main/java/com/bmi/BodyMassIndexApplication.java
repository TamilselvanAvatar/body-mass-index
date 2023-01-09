package com.bmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan("com.*")
public class BodyMassIndexApplication {

	public static void main(String[] args) {
		SpringApplication.run(BodyMassIndexApplication.class, args);
	}

}
