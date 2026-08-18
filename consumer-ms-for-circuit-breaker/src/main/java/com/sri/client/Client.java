package com.sri.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("producer-ms-for-circuit-breaker")
public interface Client {

	@GetMapping("producer/method")
	public String getProducerDetails();
}
