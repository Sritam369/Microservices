package com.sri.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sri.entity.Products;
import com.sri.service.IProductsService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

	@Autowired
	private IProductsService service;
	
	@PostMapping("/add")
	public ResponseEntity<String> addProduct(@RequestBody Products p) {
		String product = service.addProduct(p);
		return new ResponseEntity<String>(product,HttpStatus.OK);
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<List<Products>> showAllProducts() {
		List<Products> allProducts = service.getAllProducts();
		return new ResponseEntity<List<Products>>(allProducts,HttpStatus.OK);
	}
	
	@GetMapping("/showById/{prodId}")
	public ResponseEntity<Products> showProductById(@PathVariable Integer prodId) {
		Products productById = service.getProductById(prodId);
		return new ResponseEntity<Products>(productById,HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(@RequestBody Products p) {
		String updateProduct = service.updateProduct(p);
		return new ResponseEntity<String>(updateProduct,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{prodId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer prodId) {
		String deleteProduct = service.deleteProduct(prodId);
		return new ResponseEntity<String>(deleteProduct,HttpStatus.OK);
	}
	
	@PatchMapping("/reduce/{prodId}/{number}")
	public ResponseEntity<String> reduceProductQty(@PathVariable Integer prodId,@PathVariable Integer number){
		String reduceProductQuantiy = service.reduceProductQuantiy(prodId, number);
		return new ResponseEntity<String>(reduceProductQuantiy,HttpStatus.OK);
	}

}
