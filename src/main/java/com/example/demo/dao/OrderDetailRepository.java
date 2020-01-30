package com.example.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.OrderDetail;


public interface OrderDetailRepository extends MongoRepository<OrderDetail, String> {
	
	public List<OrderDetail> findByOrder(String id);
	public Long countByOrderAndState(String id,String state);
	public List<OrderDetail> findBySeller(String id);
	public List<OrderDetail> findBySellerAndOrder(String seller,String order);

}
