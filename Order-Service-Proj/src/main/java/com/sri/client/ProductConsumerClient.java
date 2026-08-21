package com.sri.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sri.dto.ProductResponse;

@FeignClient(name="Product-Service-Proj")
public interface ProductConsumerClient {

	@GetMapping("/product/showById/{prodId}")
	ProductResponse getProductByIdConsumer(@PathVariable Integer prodId);
	@PatchMapping("/product/reduce/{prodId}/{number}")
	String reduceProductQuantity(@PathVariable Integer prodId,@PathVariable Integer number);
}
