package com.hepexta.activemqpublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJms
@EnableWebMvc
public class ActivemqPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqPublisherApplication.class, args);
	}

}
