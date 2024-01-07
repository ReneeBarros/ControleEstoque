package com.dasare.estoque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasare.estoque.DTOmapper.ClientDTOmapper;
import com.dasare.estoque.Repository.ManagerRepository;
import com.dasare.estoque.model.Client;
import com.dasare.estoque.model.Manager;
import com.dasare.estoque.record.reponse.ClientRecordResponse;

@Service
public class ManagerService {
	
	@Autowired
	ManagerRepository managerRepository;

	public Manager saveManager(Manager manager) {
		return managerRepository.save(manager);
	}

	public Optional<Manager> findById(Long id) {
		Optional<Manager> manager;
		if (id == null) {
			throw new IllegalArgumentException(); 
		}
		manager = managerRepository.findById(id);
		if (manager.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return manager;
	}

	public Manager findByName(String name) {
		return managerRepository.findByName(name);
	}
	
	public List<Manager> getAllManager() {
		return managerRepository.findAll();
	}
	
	public Manager upDateManager( Manager manager) {
		Optional<Manager> m1;
		m1 = findById(manager.getManagerID());
		m1.get().setName(manager.getName());
		m1.get().setEmail(manager.getEmail());

		return managerRepository.save(m1.get());
	}



	public void deleteManager(Long id) {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		managerRepository.deleteById(id);
	}
}
