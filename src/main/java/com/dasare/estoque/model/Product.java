package com.dasare.estoque.model;

import com.dasare.estoque.model.enumm.ProductStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUCT")
public class Product {

	private Long productID;
	private String name;
	private ProductStatus productStatus;
	private Category category;
	
	public Product() {
	}
	public Product(Long productID, String name, ProductStatus productStatus, Category category) {
		super();
		this.productID = productID;
		this.name = name;
		this.productStatus = productStatus;
		this.category = category;
	}
	
	
	

}
