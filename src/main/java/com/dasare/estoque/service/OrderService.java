package com.dasare.estoque.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dasare.estoque.Repository.OrderRepository;
import com.dasare.estoque.model.Order;

@Service
public class OrderService {

	OrderRepository orderRepository;

	private final void ClientRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Order saveClient(Order order) {
		return orderRepository.save(order);
	}

	public Optional<Order> findById(Long id) {
		Optional<Order> order;
		if (id == null) {
			throw new IllegalArgumentException();
		}
		order = orderRepository.findById(id);
		if (order.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return order;
	}
	
	public Order upDateOrder(Long id, Order order) {
		Optional<Order> o1;
		var orderAux = new Order();
		o1 = findById(id);
		upDate(orderAux, o1);
		return orderRepository.saveAndFlush(orderAux);
	}

	private void upDate(Order orderAux, Optional<Order> o1) {
		orderAux.setOrderStatus(o1.get().getOrderStatus());
	}
	
	public void deleteClient(Long id) {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		orderRepository.deleteById(id);
	}


}
