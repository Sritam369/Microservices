package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class AdminServerProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServerProjApplication.class, args);
	}

}
