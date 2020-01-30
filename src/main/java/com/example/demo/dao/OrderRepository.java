package com.example.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.demo.entities.Order;


public interface OrderRepository extends MongoRepository<Order, String> ,QuerydslPredicateExecutor<Order> {
	public List<Order> findByCustomer(String id);

}
