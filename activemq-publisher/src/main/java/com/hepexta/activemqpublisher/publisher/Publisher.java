package com.hepexta.activemqpublisher.publisher;

public interface Publisher {
    void publishQueue(String message);
    void publishTopic(String message);
    void publishDurableTopic(String message);
    void publishVirtualTopic(String message);
}
