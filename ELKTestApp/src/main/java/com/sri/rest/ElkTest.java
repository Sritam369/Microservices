package com.sri.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/elk")
@Slf4j
public class ElkTest {

	@GetMapping("/info")
	public String info() {	
		log.info("Start of method");
		String msg = "this is a testing app for log monitoring tools";
		log.info("end of method");
		return msg;
	}
}
