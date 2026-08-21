package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
