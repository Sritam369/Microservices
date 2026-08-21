package com.sri.service;

import java.util.List;

import com.sri.entity.Products;

public interface IProductsService {

	String addProduct(Products prod);
	List<Products> getAllProducts();
	Products getProductById(Integer prodId);
	String updateProduct(Products prod);
	String deleteProduct(Integer prodId);
	String reduceProductQuantiy(Integer prodId,Integer reducedNumber);
}
