package com.PrimeiroTestMongo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PrimeiroTestMongo.entities.Product;
import com.PrimeiroTestMongo.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	  private final ProductService productService;

	    public ProductsController(ProductService productService) {
	        this.productService = productService;
	    }

	    @GetMapping
	    public List<Product> getAllProducts() {
	        return productService.getAllProducts(); 
	    }

	    @PostMapping
	    public ResponseEntity<?> createProduct(@RequestBody Product product) {
	        try {
	            Product createdProduct = productService.createProduct(product);
	            return ResponseEntity.ok(createdProduct);
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	    
}
