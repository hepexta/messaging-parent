package com.hepexta.activemqsubscribe.config;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

@Configuration
public class JMSConfiguration {

    @Bean
    public JmsListenerContainerFactory<DefaultMessageListenerContainer> queueContainerFactory(SingleConnectionFactory factory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setSubscriptionDurable(true);
        containerFactory.setClientId("durable-client-one");
        factory.setClientId("durable-client-one");
        containerFactory.setConnectionFactory(factory);
        configurer.configure(containerFactory, factory);
        return containerFactory;
    }

}
