package com.dasare.estoque.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasare.estoque.Repository.ProductRepository;
import com.dasare.estoque.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product findById(Long id) {
		Optional<Product> product;
		if (id == null) {
			throw new IllegalArgumentException();
		}
		product = productRepository.findById(id);
		if (product.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return product.get();
	}

	public Product findByName(String name) {
		return productRepository.findByName(name); 
	}

	public Product upDateProduct(Product product1) {
		Product product;
		var productAux = new Product();
		product = findById(product1.getProductID());
		upDate(productAux, product);
		return productRepository.save(productAux);
	}

	private void upDate(Product pAux, Product p1) {
		pAux.setName(p1.getName());
		pAux.setProductStatus(p1.getProductStatus());
		pAux.setCategory(p1.getCategory());
	}

	public void deleteProduct(Long id) {
		if (id == null) {
			throw new IllegalArgumentException();
		}
		productRepository.deleteById(id);
	}
}
