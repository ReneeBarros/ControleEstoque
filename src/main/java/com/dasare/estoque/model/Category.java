package com.dasare.estoque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CATEGORIA")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryID;
	private String name;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> product = new ArrayList<>();

	public Category() {
	}

	public Category(Long categoryID, String name) {
		super();
		this.categoryID = categoryID;
		this.name = name;
	}

	public Long getCateogyID() {
		return categoryID;
	}

	public void setCateogyID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryID, name);
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
		return Objects.equals(categoryID, other.categoryID) && Objects.equals(name, other.name);
	}

}
