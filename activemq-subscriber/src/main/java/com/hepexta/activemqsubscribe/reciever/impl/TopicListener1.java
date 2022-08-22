package com.hepexta.activemqsubscribe.reciever.impl;

import com.hepexta.activemqsubscribe.reciever.Listener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopicListener1 implements Listener {

    @JmsListener(destination = "${service.activemq.topicName}", containerFactory = "topicListenerContainerFactory")
    public void listen(String message) {
        log.info("TopicListener1 gets: {}", message);
    }
}
