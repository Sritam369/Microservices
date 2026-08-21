package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
