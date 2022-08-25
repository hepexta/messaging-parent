package com.hepexta.activemqpublisher.controller;

import com.hepexta.activemqpublisher.model.PublishRequest;
import com.hepexta.activemqpublisher.publisher.Publisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class PublisherRestController {

    private final Publisher publisher;

    @PostMapping(value = "/addToQueue", consumes = {APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addToQueue(@RequestBody PublishRequest message) {
        log.info("Publish a message to queue {}", message.getMessage());
        publisher.publishQueue(message.getMessage());
        return new ResponseEntity<>("POST Response", HttpStatus.OK);
    }

    @PostMapping(value = "/addToTopic", consumes = {APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addToTopic(@RequestBody PublishRequest message) {
        log.info("Publish a message to topic {}", message.getMessage());
        publisher.publishTopic(message.getMessage());
        return new ResponseEntity<>("POST Response", HttpStatus.OK);
    }

    @PostMapping(value = "/addToDurableTopic", consumes = {APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addToDurableTopic(@RequestBody PublishRequest message) {
        log.info("Publish a message to durable topic {}", message.getMessage());
        publisher.publishDurableTopic(message.getMessage());
        return new ResponseEntity<>("POST Response", HttpStatus.OK);
    }

    @PostMapping(value = "/addToVirtualTopic", consumes = {APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addToVirtualTopic(@RequestBody PublishRequest message) {
        log.info("Publish a message to virtual topic {}", message.getMessage());
        publisher.publishVirtualTopic(message.getMessage());
        return new ResponseEntity<>("POST Response", HttpStatus.OK);
    }
}
