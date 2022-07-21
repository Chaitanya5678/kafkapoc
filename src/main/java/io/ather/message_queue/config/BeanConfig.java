package io.ather.message_queue.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.ather.message_queue.strategies.KafkaStrategy;
import io.ather.message_queue.strategies.MessageQueueStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public MessageQueueStrategy getMessageQueueStrategy() {
        return new KafkaStrategy();
    }
}
