package com.demo.rabbitMq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@SpringBootApplication
public class RabbitMqApplication implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleMessage simpleMessage = SimpleMessage.builder().name("FirstMessage")
          .description("simpleDescription").build();

        rabbitTemplate.convertAndSend("TestExchange", "testRouting", simpleMessage);

    }
}
