package com.ecommerce.java_react.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.java_react.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword% OR p.brand LIKE %:keyword%")
    Page<Product> findByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
