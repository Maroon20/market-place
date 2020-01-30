package com.example.demo.dao;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;


import com.example.demo.entities.Product;


public interface ProductRepo extends MongoRepository<Product, String> {
	
	public List <Product> findByDesignationAndPrice(String desingation, double price);
	public List<Product> findByDescriptionContaining(String infix);
	public List<Product> findByPriceBetween(double price1, double price2);
	public List<Product> findByDesignation(String designation);
	public List<Product> findByCategory(String category);

}