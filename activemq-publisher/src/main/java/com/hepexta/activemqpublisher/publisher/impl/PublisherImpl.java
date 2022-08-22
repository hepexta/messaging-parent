package com.hepexta.activemqpublisher.publisher.impl;

import com.hepexta.activemqpublisher.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class PublisherImpl implements Publisher {

    @Autowired
    @Qualifier("queueJmsTemplate")
    private JmsTemplate queueTemplate;

    @Autowired
    @Qualifier("topicJmsTemplate")
    private JmsTemplate topicJmsTemplate;

    @Value("${service.activemq.queueName}")
    private String queueName;

    @Value("${service.activemq.topicName}")
    private String topicName;

    @Override
    public void publishQueue(String message) {
        queueTemplate.convertAndSend(queueName, message);
        queueTemplate.convertAndSend("durable-queue", message);
    }

    @Override
    public void publishTopic(String message) {
        topicJmsTemplate.convertAndSend(topicName, message);
    }
}
