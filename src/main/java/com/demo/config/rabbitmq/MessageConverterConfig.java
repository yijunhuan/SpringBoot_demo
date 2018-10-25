package com.demo.config.rabbitmq;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConverterConfig {
    
    @Bean
    public MessageConverter setMessageConverterToJson() {
        return new Jackson2JsonMessageConverter();
    }
}
