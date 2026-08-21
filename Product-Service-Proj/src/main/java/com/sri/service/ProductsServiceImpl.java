package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sri.entity.Products;
import com.sri.exception.ProductNotFoundException;
import com.sri.repository.ProductRepository;

@Service
public class ProductsServiceImpl implements IProductsService {
	
	@Autowired
	private ProductRepository repo;

   	@Override
	public String addProduct(Products prod) {
		Products save = repo.save(prod);
		return "Product is added with product id "+save.getProductId();
	}

	@Override
	public List<Products> getAllProducts() {
		List<Products> all = repo.findAll();
		return all;
	}

	@Override
	public Products getProductById(Integer prodId) {
		Products p = repo.findById(prodId).orElseThrow(()-> new ProductNotFoundException("Product with this id doesn't exist"));
		return p;
	}

	@Override
	public String updateProduct(Products prod) {
		
		Products pr = repo.findById(prod.getProductId()).orElseThrow(()-> new ProductNotFoundException("Product with this id doesn't exist"));
		pr.setProductCategory(prod.getProductCategory());
		pr.setProductDescription(prod.getProductDescription());
		pr.setProductName(prod.getProductName());
		pr.setProductPrice(prod.getProductPrice());
		pr.setProductQuantity(prod.getProductQuantity());
		
		Products save = repo.save(pr);
		return "Product with id : "+save.getProductId()+" updated successfully";
	}

	@Override
	public String deleteProduct(Integer prodId) {
		Products p = repo.findById(prodId).orElseThrow(()-> new ProductNotFoundException("Product with this id doesn't exist"));
		repo.delete(p);
		return "Product with id : "+prodId+" deleted successfully";
	}

	@Override
	public String reduceProductQuantiy(Integer prodId, Integer reducedNumber) {
		Products p = repo.findById(prodId).orElseThrow(()-> new ProductNotFoundException("Product with this id doesn't exist"));
		p.setProductQuantity(p.getProductQuantity()-reducedNumber);
		repo.save(p);
		return "Product quantity reduced by "+reducedNumber;
	}

}
