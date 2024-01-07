package com.dasare.estoque.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.dasare.estoque.model.Manager;

public interface ManagerRepository extends JpaRepositoryImplementation<Manager, Long> {

	@Query(value = "select m from Manager m where m.name like %?1%")
	public Manager findByName(String name);

}
