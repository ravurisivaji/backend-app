package com.caliber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CaliberApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaliberApplication.class, args);
	}

}
