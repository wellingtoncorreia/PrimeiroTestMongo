package com.PrimeiroTestMongo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PrimeiroTestMongo.entities.Product;
import com.PrimeiroTestMongo.repository.ProductRepository;

@Service
public class ProductService {
	 private final ProductRepository productRepository;

	    public ProductService(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    public Product createProduct(Product product) {
	    	 // Verifica se já existe um produto com o mesmo nome
	        boolean exists = productRepository.existsByName(product.getName());
	        if (exists) {
	            throw new IllegalArgumentException("Produto com o mesmo nome já existe!");
	        }
	        return productRepository.save(product);

	    }
	    

}
