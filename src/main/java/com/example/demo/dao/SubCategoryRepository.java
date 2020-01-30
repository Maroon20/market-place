package com.example.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.SubCategory;

@RepositoryRestResource
public interface SubCategoryRepository extends MongoRepository<SubCategory, String> {
	public List<SubCategory> findByCategory(String id);
	public void deleteByCategory(String id);
}
