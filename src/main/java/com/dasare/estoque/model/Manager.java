package com.dasare.estoque.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB-MANAGER")
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long managerID;
	private String name;
	private String email;
	public Manager() {
		super();
	}
	public Manager(Long managerID, String name, String email) {
		super();
		this.managerID = managerID;
		this.name = name;
		this.email = email;
	}
	public Long getManagerID() {
		return managerID;
	}
	public void setManagerID(Long managerID) {
		this.managerID = managerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(managerID, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return Objects.equals(managerID, other.managerID) && Objects.equals(name, other.name);
	}
	
	

}
