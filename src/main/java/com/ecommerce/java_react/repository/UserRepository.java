package com.ecommerce.java_react.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.java_react.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
