package com.ecommerce.java_react.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.java_react.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
