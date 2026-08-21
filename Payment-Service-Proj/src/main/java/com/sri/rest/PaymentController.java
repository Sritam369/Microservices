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

import com.sri.entity.Payment;
import com.sri.service.IPaymentService;

import feign.Response;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

	@Autowired
	private IPaymentService service;
	
	@PostMapping("/add")
	@CircuitBreaker(name="add",fallbackMethod = "addFallback")
	public ResponseEntity<String> addPayment(@RequestBody Payment pay){
		
		String payment = service.addPayment(pay);
		return new ResponseEntity<String>(payment,HttpStatus.OK);
	}
	
	public ResponseEntity<String> addFallback(Payment pay,Exception e){
		return new ResponseEntity<String>("Payment can't be done due to some internal problem",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<List<Payment>> showPayments(){
		
		return new ResponseEntity<List<Payment>>(service.getAllPayments(),HttpStatus.OK);
	}
	
	@GetMapping("/show/{paymentId}")
	public ResponseEntity<Payment> showPaymentById(@PathVariable Integer paymentId){
		
		Payment paymentById = service.getPaymentById(paymentId);
		return new ResponseEntity<Payment>(paymentById,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updatePayment(@RequestBody Payment pay){
		
		String payment = service.updatePayment(pay);
		return new ResponseEntity<String>(payment,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{paymentId}")
	public ResponseEntity<String> deletePaymentById(@PathVariable Integer paymentId){
		
		String paymentById = service.deletePayment(paymentId);
		return new ResponseEntity<String>(paymentById,HttpStatus.OK);
	}
	
}
