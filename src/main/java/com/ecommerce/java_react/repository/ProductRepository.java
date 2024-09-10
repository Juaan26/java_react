package com.ecommerce.java_react.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.java_react.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    

    @Query(" SELECT p FROM Product p WHERE p.name LIKE %?1% OR p.brand LIKE %?1%")
    public List<Product> findAll(String keyword);
}
