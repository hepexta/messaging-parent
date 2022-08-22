package com.hepexta.activemqpublisher.publisher;

public interface Publisher {
    void publishQueue(String message);
    void publishTopic(String message);
}
