package com.hepexta.activemqsubscribe.reciever.impl;

import com.hepexta.activemqsubscribe.reciever.Listener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueueDurableListener implements Listener {

    @JmsListener(destination = "${service.activemq.durableQueueName}", containerFactory = "queueDurableContainerFactory")
    public void listen(String message) {
        log.info("QueueDurableListener reads a message from Queue: {}", message);
    }
}
