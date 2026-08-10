package com.sri.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sri.client.IShoppingServiceRestConsumer;

@RestController
@RequestMapping("shopping")
public class ConsumerShoppingAPI {

	@Autowired
	private IShoppingServiceRestConsumer consumer;
	
	@GetMapping("details")
	public String displayProducerDetails() {
		return "Durga puja 2026 shopping for family "+consumer.fetchProducerDetails();
	}
}
