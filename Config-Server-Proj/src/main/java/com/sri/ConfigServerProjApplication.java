package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerProjApplication.class, args);
	}

}
