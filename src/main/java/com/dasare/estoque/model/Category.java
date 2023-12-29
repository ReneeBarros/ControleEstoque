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
@Table(name = "TB_CATEGORIA")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cateogyID;
	private String name;
	
	
	private List<Product>product = new ArrayList<>();
	
	
	
	
	public Category() {
	}
	public Category(Long cateogyID, String name) {
		super();
		this.cateogyID = cateogyID;
		this.name = name;
	}
	
	public Long getCateogyID() {
		return cateogyID;
	}
	public void setCateogyID(Long cateogyID) {
		this.cateogyID = cateogyID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cateogyID, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(cateogyID, other.cateogyID) && Objects.equals(name, other.name);
	}
	
	
	

}
