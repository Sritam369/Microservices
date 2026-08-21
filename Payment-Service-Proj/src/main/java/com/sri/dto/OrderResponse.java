package com.sri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

	private Integer orderId;
	private Integer productId;
	private Integer orderQuantity;
	private Double orderPrice;
	private String orderStatus;
}
