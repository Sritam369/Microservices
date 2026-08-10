package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShoppingProducerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingProducerMsApplication.class, args);
	}

}
