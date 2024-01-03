package com.dasare.estoque.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dasare.estoque.Repository.ProductRepository;
import com.dasare.estoque.model.Product;

@Service
public class ProductService {

	ProductRepository productRepository;

	private final void ClientRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Optional<Product> findById(Long id) {
		Optional<Product> product;
		if (id == null) {
			throw new IllegalArgumentException();
		}
		product = productRepository.findById(id);
		if (product.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return product;
	}
	
	public Product findByName (String name) {
		return productRepository.findByName(name);
	}

	public Product upDateProduct(Long id, Product client) {
		Optional<Product> product;
		var productAux = new Product();
		product = findById(id);
		upDate(productAux, product);
		return productRepository.saveAndFlush(productAux);
	}

	private void upDate(Product pAux, Optional<Product> p1) {
		pAux.setName(p1.get().getName());
		pAux.setProductStatus(p1.get().getProductStatus());
		pAux.setCategory(p1.get().getCategory());
	}
	
	public void deleteProduct(Long id) {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		productRepository.deleteById(id);
	}
}
