package com.hepexta.activemqsubscribe.reciever.impl;

import com.hepexta.activemqsubscribe.reciever.Listener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VirtualTopicListener2 implements Listener {

    @JmsListener(destination = "${service.activemq.virtualTopicName2}", containerFactory = "virtualTopicContainerFactory")
    public void listen(String message) {
        log.info("VirtualTopicListener2 reads a message from Topic: {}", message);
    }
}
