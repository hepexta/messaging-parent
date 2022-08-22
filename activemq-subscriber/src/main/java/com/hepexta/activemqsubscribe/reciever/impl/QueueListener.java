package com.hepexta.activemqsubscribe.reciever.impl;

import com.hepexta.activemqsubscribe.reciever.Listener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueueListener implements Listener {

    @JmsListener(destination = "${service.activemq.queueName}", containerFactory = "queueContainerFactory")
    public void listen(String message) {
        log.info("Message from Queue: {}", message);
    }
}
