package io.ather.message_queue.strategies;

import io.ather.message_queue.utils.AppConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@Log4j2
public class KafkaStrategy implements MessageQueueStrategy {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info(String.format("Message sent -> %s", message));
        kafkaTemplate.send(AppConstants.TOPIC_NAME, message); //TODO: Handle any exception
    }

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void consume(String message){
        log.info(String.format("Message received -> %s", message));
    }
}
