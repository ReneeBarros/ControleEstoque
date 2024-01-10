package com.dasare.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasare.estoque.Repository.OrderRepository;
import com.dasare.estoque.model.Order;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public Order saveOrder(Order order) {

		return orderRepository.save(order);
	}

	public Order findById(Long id) {
		Optional<Order> order;
		if (id == null) {
			throw new IllegalArgumentException();
		}
		order = orderRepository.findById(id);
		if (order.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return order.get();
	}

	public List<Order> AllOrder() {
		return orderRepository.findAll();
	}

	public Order upDateStatusOrder(Order order) {
		Order o1;
		var orderAux = new Order();
		o1 = findById(order.getOrderID());
		orderAux.setOrderStatus(o1.getOrderStatus());
		return orderRepository.save(orderAux);
	}

	public void deleteOrder(Long id) {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		orderRepository.deleteById(id);
	}

}
