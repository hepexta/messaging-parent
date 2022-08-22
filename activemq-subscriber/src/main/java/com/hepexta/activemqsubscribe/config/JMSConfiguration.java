package com.hepexta.activemqsubscribe.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.ConnectionFactory;

@Configuration
public class JMSConfiguration {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;
    @Value("${spring.activemq.user}")
    private String user;
    @Value("${spring.activemq.password}")
    private String password;

    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        activeMQConnectionFactory.setUserName(user);
        activeMQConnectionFactory.setPassword(password);
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsListenerContainerFactory<DefaultMessageListenerContainer> queueContainerFactory(ConnectionFactory factory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        configurer.configure(containerFactory, factory);
        return containerFactory;
    }

    @Bean
    public JmsListenerContainerFactory<DefaultMessageListenerContainer> queueDurableContainerFactory(SingleConnectionFactory factory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setSubscriptionDurable(true);
        containerFactory.setClientId("clientId");
        factory.setClientId("clientId");
        containerFactory.setConnectionFactory(factory);
        configurer.configure(containerFactory, factory);
        return containerFactory;
    }

    @Bean
    public JmsListenerContainerFactory topicListenerContainerFactory() {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setPubSubDomain(true);
        containerFactory.setConnectionFactory(activeMQConnectionFactory());
        return containerFactory;
    }
}
