package com.dasare.estoque.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dasare.estoque.Repository.ManagerRepository;
import com.dasare.estoque.model.Manager;

@Service
public class ManagerService {

	ManagerRepository managerRepository;

	private final void ManagerRepository(ManagerRepository managerRepository) {
		this.managerRepository = managerRepository;
	}

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

	public Manager upDateManager(Long id, Manager manager) {
		Optional<Manager> m1;
		var managerAux = new Manager();
		m1 = findById(id);
		upDate(managerAux, m1);
		return managerRepository.saveAndFlush(managerAux);
	}

	private void upDate(Manager managerAux, Optional<Manager> m1) {
		managerAux.setName(m1.get().getName());
		managerAux.setEmail(m1.get().getEmail());
	}

	public void deleteManager(Long id) {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		managerRepository.deleteById(id);
	}
}
