package com.sri.service;

import java.util.List;

import com.sri.entity.Payment;

public interface IPaymentService {
	
	String addPayment(Payment prod);
	List<Payment> getAllPayments();
	Payment getPaymentById(Integer paymentId);
	String updatePayment(Payment payment);
	String deletePayment(Integer paymentId);
}
