package com.example.api.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication (scanBasePackages = {"com.example.api"})
@EnableJpaRepositories(basePackages = "com.example.api.repository")
@EntityScan(basePackages = "com.example.api.model")
public class TestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestApiApplication.class, args);
	}
}
