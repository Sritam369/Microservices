package com.sri.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sri.dto.PaymentResponse;

@FeignClient(name="Payment-Service-Proj")
public interface PaymentConsumerClient {

	@GetMapping("payment/show/{paymentId}")
	PaymentResponse getPaymentIdConsumer(@PathVariable Integer paymentId);
}
