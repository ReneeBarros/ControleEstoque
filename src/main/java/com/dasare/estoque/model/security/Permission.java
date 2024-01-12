package com.dasare.estoque.model.security;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PERMISSION")
public class Permission implements GrantedAuthority ,Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_permission")
	private Long id;
	
	private String description;

	public Permission(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permission other = (Permission) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id);
	}

	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public Permission() {
	}
	
	
	
	

	@Override
	public String getAuthority() {

		return this.description;
	}



	
}
