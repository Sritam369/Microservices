package com.sri.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.entity.Orders;
import com.sri.service.IOrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

	@Autowired
	private IOrderService service;
	
	@PostMapping("/add")
	@CircuitBreaker(name="add",fallbackMethod = "addFallback")
	public ResponseEntity<String> addOrder(@RequestBody Orders o){
		String order = service.addOrder(o);
		return new ResponseEntity<String>(order,HttpStatus.OK);
	}
	
	public ResponseEntity<String> addFallback(Orders o,Exception e){
		return new ResponseEntity<String>("Order can't be placed currently due to an internal problem",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/showAll")
	@CircuitBreaker(name="showAll", fallbackMethod = "showAllFallback")
	public ResponseEntity<List<Orders>> showAllOrders() {
		List<Orders> allOrders = service.getAllOrders();
		return new ResponseEntity<List<Orders>>(allOrders,HttpStatus.OK);
	}
	
	public ResponseEntity<String> showAllFallback(Exception e){
		return new ResponseEntity<String>("Orders can't be displayed currently due to some internal problem",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/showById/{orderId}")
	@CircuitBreaker(name="showById", fallbackMethod = "showFallback")
	public ResponseEntity<Orders> showOrder(@PathVariable Integer orderId) {
		Orders order = service.getOrderById(orderId);
		return new ResponseEntity<Orders>(order,HttpStatus.OK);
	}
	
	public ResponseEntity<String> showFallback(Integer id,Exception e){
		return new ResponseEntity<String>("Order can't be displayed currently due to some internal problem",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/update")
	@CircuitBreaker(name="update", fallbackMethod = "updateFallback")
	public ResponseEntity<String> updateOrder(@RequestBody Orders o) {
		String updateOrder = service.updateOrder(o);
		return new ResponseEntity<String>(updateOrder,HttpStatus.OK);
	}
	
	public ResponseEntity<String> updateFallback(Exception e){
		return new ResponseEntity<String>("Order can't be updated currently due to some internal problem",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/delete/{orderId}")
	@CircuitBreaker(name="delete", fallbackMethod = "deleteFallback")
	public ResponseEntity<String> deleteOrder(@PathVariable Integer orderId) {
		String deleteOrder = service.deleteOrder(orderId);
		return new ResponseEntity<String>(deleteOrder,HttpStatus.OK);
	}
	
	public ResponseEntity<String> deleteFallback(Integer id,Exception e){
		return new ResponseEntity<String>("Order can't be deleted currently due to some internal problem",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
