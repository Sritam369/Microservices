package com.sri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.client.ProductConsumerClient;
import com.sri.dto.ProductResponse;
import com.sri.entity.Orders;
import com.sri.exception.OrderNotFoundException;
import com.sri.repository.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private ProductConsumerClient client;
	
	@Override
	public String addOrder(Orders order) {
		
		ProductResponse p = client.getProductByIdConsumer(order.getProductId());
		
		if(order.getOrderQuantity()>p.getProductQuantity()) {
			return "Insufficient product quantity in the store";
		}
		else if(order.getOrderQuantity()<=0){
			return "Order quantity must be greater than 0";
		}
		else {
		Double totalPrice = p.getProductPrice()*order.getOrderQuantity();
		order.setOrderPrice(totalPrice);
		client.reduceProductQuantity(order.getProductId(), order.getOrderQuantity());
		Orders save = repo.save(order);
		return "Order is added with order id "+save.getOrderId();
		}
	}

	@Override
	public List<Orders> getAllOrders() {
		List<Orders> all = repo.findAll();
		return all;
	}

	@Override
	public Orders getOrderById(Integer orderId) {
		Orders p = repo.findById(orderId).orElseThrow(()-> new OrderNotFoundException("Order with this id doesn't exist"));
		return p;
	}

	@Override
	public String updateOrder(Orders order) {
		
		Orders or = repo.findById(order.getOrderId()).orElseThrow(()-> new OrderNotFoundException("Order with this id doesn't exist"));
		or.setOrderPrice(order.getOrderPrice());
		or.setOrderQuantity(order.getOrderQuantity());
		or.setOrderStatus(order.getOrderStatus());
		
		Orders save = repo.save(or);
		return "Order with id : "+save.getOrderId()+" updated successfully";
	}

	@Override
	public String deleteOrder(Integer orderId) {
		Orders p = repo.findById(orderId).orElseThrow(()-> new OrderNotFoundException("Order with this id doesn't exist"));
		repo.delete(p);
		return "Order with id : "+orderId+" deleted successfully";
	}

}
