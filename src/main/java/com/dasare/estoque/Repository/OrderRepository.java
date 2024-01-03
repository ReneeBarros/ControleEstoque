package com.dasare.estoque.Repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.dasare.estoque.model.Order;

public interface OrderRepository extends JpaRepositoryImplementation<Order, Long> {
	
}
