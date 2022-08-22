package com.hepexta.activemqsubscribe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ActivemqSubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqSubscriberApplication.class, args);
	}

}
