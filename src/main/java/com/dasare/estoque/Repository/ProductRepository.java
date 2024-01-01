package com.dasare.estoque.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.dasare.estoque.model.Product;

public interface ProductRepository extends JpaRepositoryImplementation<Product, Long> {

	@Query(value = "select c from Client c where c.name like %?1%")
	public Product findByName(String name);

}
