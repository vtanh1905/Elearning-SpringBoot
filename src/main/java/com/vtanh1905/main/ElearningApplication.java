package com.vtanh1905.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.vtanh1905")
@EntityScan(basePackages = "com.vtanh1905.entity")
@EnableJpaRepositories(basePackages = "com.vtanh1905.repository")
public class ElearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElearningApplication.class, args);
		System.out.println("====================================================================================");
		System.out.println("Server's Running	: http://localhost:8080");
		System.out.println("URL API			: http://localhost:8080/swagger-ui.html");
		System.out.println("====================================================================================");
	}

}
