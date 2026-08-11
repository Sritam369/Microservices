package com.sri.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class CSTestingController {

	@Value("${dbUser}")
	private String username;
	@Value("${dbPwd}")
	private String password;
	
	@GetMapping("/show")
	public String show() {
		return "Data collected through config server : "+username+"----"+password;
	}
}
