package com.gcu.gamehive_cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcu.gamehive_cloud.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
}
