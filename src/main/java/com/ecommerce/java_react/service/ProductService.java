package com.ecommerce.java_react.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ecommerce.java_react.models.Product;

public interface ProductService {

    Page<Product> getAllProducts(String keyword, Pageable pageable);
    Optional<Product> getProductById(Long id);
    void saveProduct(Product product);
    void updateProduct(Long id, Product product);
    void deleteProduct(Long id);
      
    

    
}
