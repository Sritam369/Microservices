package com.sri.service;

import java.util.List;

import com.sri.entity.Orders;

public interface IOrderService {

	String addOrder(Orders order);
	List<Orders> getAllOrders();
	Orders getOrderById(Integer orderId);
	String updateOrder(Orders order);
	String deleteOrder(Integer orderId);
}
