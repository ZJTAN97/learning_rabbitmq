package com.demo.rabbitListener;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private static final String QUEUE_NAME = "MyQueue";

    @Bean
    Queue myQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    Exchange myExchange() {
        return ExchangeBuilder
          .topicExchange("MyTopicExchange")
          .durable(true)
          .build();
    }

    @Bean
    Binding binding() {
        return BindingBuilder
          .bind(myQueue())
          .to(myExchange())
          .with("topic")
          .noargs();
    }

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory =
          new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");

        return cachingConnectionFactory;
    }

    @Bean
    MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer =
          new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(myQueue());
        simpleMessageListenerContainer.setMessageListener(new RabbitMessageListener());
        return simpleMessageListenerContainer;
    }

}
