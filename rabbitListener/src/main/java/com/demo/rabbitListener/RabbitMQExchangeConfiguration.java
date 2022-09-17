package com.demo.rabbitListener;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfiguration {

    @Bean
    Exchange exampleExchange() {
        return new TopicExchange("ExampleTopicExchange");
    }

    @Bean
    Exchange example2ndExchange() {
        return ExchangeBuilder
          .directExchange("Example2ndDirectExchange")
          .autoDelete()
          .internal()
          .build();
    }

    @Bean
    Exchange topicExchange() {
        return ExchangeBuilder
          .topicExchange("TopicTestExchange")
          .autoDelete()
          .durable(true)
          .internal()
          .build();
    }

    @Bean
    Exchange fanOutExchange() {
        return ExchangeBuilder
          .fanoutExchange("FanOutTestExchange")
          .autoDelete()
          .durable(false)
          .internal()
          .build();
    }

    @Bean
    Exchange headersExchange() {
        return ExchangeBuilder
          .headersExchange("HeadersTestExchange")
          .autoDelete()
          .internal()
          .durable(true)
          .ignoreDeclarationExceptions()
          .build();
    }

}
