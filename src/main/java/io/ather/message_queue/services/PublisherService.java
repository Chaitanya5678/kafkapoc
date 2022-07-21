package io.ather.message_queue.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ather.message_queue.models.Event;
import io.ather.message_queue.strategies.MessageQueueStrategy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PublisherService {

    @Autowired
    MessageQueueStrategy messageQueueStrategy;

    @Autowired
    ObjectMapper objectMapper;

    public void publishEvent(Event event) {
        String message;
        try {
            message = objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            log.error("Error while serializing event : " + event, e);
            return;
        }
        messageQueueStrategy.sendMessage(message);
    }
}
