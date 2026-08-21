package com.sri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
	
    private Integer productId;
    private String productName;
    private Double productPrice;
    private Integer productQuantity;
    private String productCategory;
}
