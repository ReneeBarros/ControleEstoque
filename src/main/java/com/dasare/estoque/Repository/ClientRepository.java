package com.dasare.estoque.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.dasare.estoque.model.Client;


public interface ClientRepository extends JpaRepositoryImplementation<Client, Long> {
	
	@Query(value = "select c from Client c where c.name like %?1%")
	public List<Client> findByName (String name);
	

}
