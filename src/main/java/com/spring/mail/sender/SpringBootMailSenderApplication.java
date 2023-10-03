package com.spring.mail.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootMailSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMailSenderApplication.class, args);
	}

}
