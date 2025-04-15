package com.devconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration.class })
public class DevConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevConnectApplication.class, args);
	}

}
