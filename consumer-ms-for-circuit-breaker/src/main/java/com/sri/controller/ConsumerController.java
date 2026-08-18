package com.sri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.client.Client;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private Client client;
	
	@GetMapping("/method")
	public String getDetails() {
		return client.getProducerDetails();
	}
}
