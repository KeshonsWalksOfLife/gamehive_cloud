package com.gcu.gamehive_cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcu.gamehive_cloud.model.Product;

// Jpa Repository that takes the entity type, and primary key type
// auto-creates findAll(), findById(), save(), deleteById()
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
