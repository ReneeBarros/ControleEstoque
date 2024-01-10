package com.dasare.estoque.model;

import java.io.Serializable;

import com.dasare.estoque.model.pk.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="TB_ORDER_ITEM")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private OrderItemPk id = new OrderItemPk();
	
	private Double quant;


	public OrderItem(Product product,Order order,Double quant ) {
		super();
		this.quant = quant;
		id.setOrder(order);
		id.setProduct(product);
		

	}


	public Double getQuant() {
		return quant;
	}

	public void setQuant(Double quant) {
		this.quant = quant;
	}

	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder( order);
	}
	

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);;
	}

}
