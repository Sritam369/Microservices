package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Ms1ForTestingAdminSeverApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms1ForTestingAdminSeverApplication.class, args);
	}

}
