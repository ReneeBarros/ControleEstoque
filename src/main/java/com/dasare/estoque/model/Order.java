package com.dasare.estoque.model;

import java.io.Serializable;
import java.time.Instant;

import com.dasare.estoque.model.enumm.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_ORDER")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long orderID;
	private Instant instant;
	private OrderStatus orderStatus;

	public Order() {
		super();
	}

	public Order(Long orderID, Instant instant, OrderStatus orderStatus) {
		super();
		this.orderID = orderID;
		this.instant = instant;
		this.orderStatus = orderStatus;
	}
	
	
	

}
