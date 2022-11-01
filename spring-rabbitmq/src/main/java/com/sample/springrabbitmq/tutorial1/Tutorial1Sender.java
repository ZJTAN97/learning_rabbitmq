package com.sample.springrabbitmq.tutorial1;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tutorial1Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello world!";
        this.rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }

}
