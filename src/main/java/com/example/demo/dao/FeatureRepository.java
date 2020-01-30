package com.example.demo.dao;



import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.demo.entities.Feature;

public interface FeatureRepository extends MongoRepository<Feature, String>,QuerydslPredicateExecutor<Feature>{
	
	public List<Feature> findByProduct(String id);

}
