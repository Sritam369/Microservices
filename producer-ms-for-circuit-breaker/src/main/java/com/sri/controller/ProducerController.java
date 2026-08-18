package com.sri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/producer")
public class ProducerController {

	@GetMapping("/method")
	@CircuitBreaker(name="producer-method",fallbackMethod = "fallback")
	public String producerMethod() {
		return "This is producer method with circuit breaker";
	}
	
	public ResponseEntity<String> fallback(Exception e){
		return new ResponseEntity<String>("producer operations are out of service",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
