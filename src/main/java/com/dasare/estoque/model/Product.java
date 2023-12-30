package com.dasare.estoque.model;

import java.util.Objects;

import com.dasare.estoque.model.enumm.ProductStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productID;
	private String name;
	private ProductStatus productStatus;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "CAtegory_ID")
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
	
	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductStatus getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(ProductStatus productStatus) {
		this.productStatus = productStatus;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, productID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name) && Objects.equals(productID, other.productID);
	}
	

}
