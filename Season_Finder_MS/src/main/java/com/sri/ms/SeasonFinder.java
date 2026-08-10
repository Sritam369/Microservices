package com.sri.ms;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/season")
public class SeasonFinder {

	@Value("${spring.application.instance-id}")
	private String instanceId;
	
	@GetMapping("/show")
	public ResponseEntity<String> findSeason(){
		
		LocalDateTime ldt = LocalDateTime.now();
		
		int month = ldt.getMonthValue();
		String seasonName = null;
		if(month>=7 && month<=10) {
			seasonName = "rainy";
		}
		else if(month>=3 && month<=6) {
			seasonName = "summer";
		}
		else {
			seasonName = "winter";
		}
		
		return ResponseEntity.ok(seasonName);
	}
}
