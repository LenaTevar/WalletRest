package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WallyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WallyApplication.class, args);
		System.out.println("Welcome to Wally");
	}

}
