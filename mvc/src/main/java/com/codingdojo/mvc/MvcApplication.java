package com.codingdojo.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvcApplication {

	public static void main(String[] args) {
		System.out.println("YO the server is a going");
		SpringApplication.run(MvcApplication.class, args);
	}
}
