package io.ather.message_queue.controllers;

import io.ather.message_queue.models.Event;
import io.ather.message_queue.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @PostMapping("/publish/events")
    public ResponseEntity<String> publishEvent(@RequestBody Event event) {
        try {
            publisherService.publishEvent(event.toBuilder().id(UUID.randomUUID()).build());
            return new ResponseEntity<>("Event got published successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
