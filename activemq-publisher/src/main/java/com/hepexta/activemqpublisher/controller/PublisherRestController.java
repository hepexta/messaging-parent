package com.hepexta.activemqpublisher.controller;

import com.hepexta.activemqpublisher.model.PublishRequest;
import com.hepexta.activemqpublisher.publisher.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class PublisherRestController {

    private final Publisher publisher;

    @PostMapping(value = "/addToQueue", consumes = {APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addToQueue(@RequestBody PublishRequest message) {
        publisher.publishQueue(message.getMessage());
        return new ResponseEntity<>("POST Response", HttpStatus.OK);
    }

    @PostMapping(value = "/addToTopic", consumes = {APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addToTopic(@RequestBody PublishRequest message) {
        publisher.publishTopic(message.getMessage());
        return new ResponseEntity<>("POST Response", HttpStatus.OK);
    }
}
