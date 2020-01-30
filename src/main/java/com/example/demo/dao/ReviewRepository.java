package com.example.demo.dao;


import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.demo.entities.Review;


public interface ReviewRepository extends MongoRepository<Review, String>,QuerydslPredicateExecutor<Review> {

	
	public List<Review> findByProduct(String id);
	public List<Review> findByCustomer(String id);

}
