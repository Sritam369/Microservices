package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
