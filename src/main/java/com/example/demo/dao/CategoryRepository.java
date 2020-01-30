package com.example.demo.dao;


import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.demo.entities.Category;

public interface CategoryRepository extends MongoRepository<Category, String>,QuerydslPredicateExecutor<Category> {
    public Long countByInHome(boolean inHome);
    public List<Category> findByInHome(boolean inHome);
}
