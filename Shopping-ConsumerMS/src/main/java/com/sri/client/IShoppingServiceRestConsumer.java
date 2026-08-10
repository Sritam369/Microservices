package com.sri.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Shopping-ProducerMS")
public interface IShoppingServiceRestConsumer {

	@GetMapping("billing/info")
	public String fetchProducerDetails();
}
