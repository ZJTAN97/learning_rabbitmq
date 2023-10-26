package com.tutorial.learnrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LearnRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnRabbitMqApplication.class, args);
	}

}
