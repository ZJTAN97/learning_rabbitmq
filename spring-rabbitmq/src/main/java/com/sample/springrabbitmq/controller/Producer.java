package com.sample.springrabbitmq.controller;

import com.sample.springrabbitmq.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    private final DirectExchange directExchange;

    private final FanoutExchange fanoutExchange;

    private final TopicExchange topicExchange;


    @PostMapping("/post/A")
    public String sendA(@RequestBody Message message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "routing.A", message);
        return "Message sent successfully to Direct Exchange A";
    }

    @PostMapping("/post/B")
    public String sendB(@RequestBody Message message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "routing.B", message);
        return "Message sent successfully to Direct Exchange B";
    }

    @PostMapping("/post/fanout")
    public String sendFanOut(@RequestBody Message message) {
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", message);
        return "Message sent successfully to Fanout Exchange";
    }

    @PostMapping("/post/topic")
    public String sendTopic(@RequestBody Message message) {
        rabbitTemplate.convertAndSend(topicExchange.getName(), "routing.A", message);
        return "Message sent successfully to Topic Exchange";
    }

}
