package com.hepexta.activemqrequestreply;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTempQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.MessageNotWriteableException;
import java.util.UUID;

import static com.hepexta.activemqrequestreply.reciever.AppConstants.REPLY_QUEUE;
import static com.hepexta.activemqrequestreply.reciever.AppConstants.REQUEST_QUEUE;

@SpringBootApplication
@EnableJms
@Slf4j
public class ActivemqRequestReplyApplication {

	public static void main(String[] args) throws MessageNotWriteableException {
		ConfigurableApplicationContext context = SpringApplication.run(ActivemqRequestReplyApplication.class, args);
		JmsMessagingTemplate jmsMessagingTemplate = (JmsMessagingTemplate) context.getBean("jmsMessagingTemplate");

		ActiveMQTextMessage message = getActiveMQTextMessage();
		String receive = jmsMessagingTemplate.convertSendAndReceive(REQUEST_QUEUE, message, String.class);
		log.info("Response: {}", receive);
	}

	private static ActiveMQTextMessage getActiveMQTextMessage() throws MessageNotWriteableException {
		ActiveMQTextMessage message = new ActiveMQTextMessage();
		message.setText("Hello world");
		message.setJMSCorrelationID(UUID.randomUUID().toString());
		ActiveMQTempQueue replyTo = new ActiveMQTempQueue(REPLY_QUEUE);
		message.setReplyTo(replyTo);
		return message;
	}

}
