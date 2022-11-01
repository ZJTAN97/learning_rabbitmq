package com.sample.springrabbitmq.tutorial3;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile({ "tut3", "pub-sub", "publish-subscribe" })
public class Tutorial3Config {

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("tut.fanout");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean
        public Queue autoDeleteQueue1() {
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2() {
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding1(FanoutExchange fanout,
                                Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
        }

        @Bean
        public Binding binding2(FanoutExchange fanout,
                                Queue autoDeleteQueue2) {
            return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
        }

        @Bean
        public Tutorial3Receiver receiver() {
            return new Tutorial3Receiver();
        }
    }

    @Profile("sender")
    @Bean
    public Tutorial3Sender sender() {
        return new Tutorial3Sender();
    }

}
