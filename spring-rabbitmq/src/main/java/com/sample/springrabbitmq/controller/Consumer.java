package com.sample.springrabbitmq.controller;

import com.sample.springrabbitmq.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = {"queue.A", "queue.fanout"})
    private void receiveA(Message message) {
        log.info("-- FROM QUEUE A --");
        log.info(message.toString());
    }

    @RabbitListener(queues = {"queue.B", "queue.fanout"})
    private void receiveB(Message message) {
        log.info("-- FROM QUEUE B --");
        log.info(message.toString());
    }

    @RabbitListener(queues = {"queue.all"})
    private void receiveAll(Message message) {
        log.info("-- FROM QUEUE ALL --");
        log.info(message.toString());
    }

}
