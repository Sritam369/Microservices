package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.client.OrderConsumerClient;
import com.sri.dto.OrderResponse;
import com.sri.entity.Payment;
import com.sri.exception.PaymentNotFoundException;
import com.sri.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private PaymentRepository repo;
	@Autowired
	private OrderConsumerClient client;
	
	@Override
	public String addPayment(Payment payment) {
		
		OrderResponse order = client.getOrderByIdConsumer(payment.getOrderId());
		
		if(!order.getOrderStatus().equalsIgnoreCase("placed")) {
			return "Confirm the order placement before payment";
		}
		else {
		payment.setAmount(order.getOrderPrice());
		Payment save = repo.save(payment);
		return "Payment successfull with id : "+save.getPaymentId();
		}
	}

	@Override
	public List<Payment> getAllPayments() {
		return repo.findAll();
	}

	@Override
	public Payment getPaymentById(Integer paymentId) {
		Payment pay = repo.findById(paymentId).orElseThrow(()->new PaymentNotFoundException("Payment id doesn't exist"));
		return pay;
	}

	@Override
	public String updatePayment(Payment payment) {
		Payment pay = repo.findById(payment.getPaymentId()).orElseThrow(()->new PaymentNotFoundException("Payment id doesn't exist"));
		pay.setPaymentMode(payment.getPaymentMode());
		pay.setPaymentStatus(payment.getPaymentStatus());
		
		repo.save(pay);
		return "Payment updated";
	}

	@Override
	public String deletePayment(Integer paymentId) {
		Payment pay = repo.findById(paymentId).orElseThrow(()->new PaymentNotFoundException("Payment id doesn't exist"));
		repo.delete(pay);
		return "Payment record with id : "+paymentId+" deleted successfully";
	}

}
