package com.PrimeiroTestMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.PrimeiroTestMongo.entities.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
	boolean existsByName(String name);

}
