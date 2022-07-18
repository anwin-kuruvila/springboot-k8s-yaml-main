package com.javatechie.k8s;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootK8sDemoApplication {

	@GetMapping("/message")
	public String displayMessage(){
		
		ArrayList<String> envVars = new ArrayList<String>();
		envVars.add(System.getenv("DB_TYPE"));
		envVars.add(System.getenv("DB_SERVER_NAME"));
		envVars.add(System.getenv("DB_PORT_NUMBER"));
		envVars.add(System.getenv("DB_NAME"));
		envVars.add(System.getenv("DB_USER"));
		envVars.add(System.getenv("DB_PASSWORD"));
		envVars.add(System.getenv("LOV_KAFKA_DEV_USER"));
		envVars.add(System.getenv("LOV_KAFKA_SCHEMA_DEV_PASSWORD"));
		
		System.out.println(envVars);
		
		return "ENV vars fetched from container >>>  " + envVars;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootK8sDemoApplication.class, args);
	}

}

