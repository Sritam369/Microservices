package com.sri.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sri.dto.OrderResponse;

@FeignClient(name="Order-Service-Proj")
public interface OrderConsumerClient {

	@GetMapping("/order/showById/{orderId}")
	OrderResponse getOrderByIdConsumer(@PathVariable Integer orderId);
}
