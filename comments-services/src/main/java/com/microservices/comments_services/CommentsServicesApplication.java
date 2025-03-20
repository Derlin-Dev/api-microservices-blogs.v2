package com.microservices.comments_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CommentsServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentsServicesApplication.class, args);
	}

}
