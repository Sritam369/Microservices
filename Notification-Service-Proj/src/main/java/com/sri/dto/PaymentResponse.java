package com.sri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

	private Integer paymentId;
	private Integer orderId;
	private Double amount;
	private String paymentMode;
	private String paymentStatus;
}
