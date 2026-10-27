package com.gcu.gamehive_cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcu.gamehive_cloud.model.User;

// Same repository to use for CRUD operations
public interface UserRepository extends JpaRepository<User, Integer> {

}
