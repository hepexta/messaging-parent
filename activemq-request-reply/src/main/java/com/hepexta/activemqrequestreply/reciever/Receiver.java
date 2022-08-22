package com.hepexta.activemqrequestreply.reciever;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import static com.hepexta.activemqrequestreply.reciever.AppConstants.REQUEST_QUEUE;

@Component
@Slf4j
public class Receiver implements SessionAwareMessageListener<Message> {

    @Override
    @JmsListener(destination = REQUEST_QUEUE)
    public void onMessage(Message message, Session session) throws JMSException {

        log.info("Message received {}", message);
        final ActiveMQTextMessage responseMessage = new ActiveMQTextMessage();
        responseMessage.setJMSCorrelationID(message.getJMSCorrelationID());
        responseMessage.setText("RECEIVED");

        // Message sent back to the replyTo address of the income message.
        final MessageProducer producer = session.createProducer(message.getJMSReplyTo());
        producer.send(responseMessage);
    }
}
