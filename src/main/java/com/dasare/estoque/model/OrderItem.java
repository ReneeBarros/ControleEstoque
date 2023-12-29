package com.dasare.estoque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_ORDERITEM")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Double quant;
	
	private Order order;

	private List<Product>product = new ArrayList<>();

	public OrderItem() {
	}

	public OrderItem( Double quant, Order order, List<Product> product) {
		super();

		this.quant = quant;
		this.order = order;
		this.product = product;
	}


	public Double getQuant() {
		return quant;
	}

	public void setQuant(Double quant) {
		this.quant = quant;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public List<Product> getProduct() {
		return product;
	}



}
