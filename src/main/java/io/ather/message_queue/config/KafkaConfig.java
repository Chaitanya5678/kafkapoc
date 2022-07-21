package io.ather.message_queue.config;

import io.ather.message_queue.strategies.KafkaStrategy;
import io.ather.message_queue.strategies.MessageQueueStrategy;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static io.ather.message_queue.utils.AppConstants.*;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic getKafkaTopic() {
        return TopicBuilder.name(TOPIC_NAME).partitions(NUMBER_OF_PARTITIONS).replicas(NUMBER_OF_REPLICAS).build();
    }
}
