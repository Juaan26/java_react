package com.ecommerce.java_react.service;

import java.util.List;
import java.util.Optional;
import com.ecommerce.java_react.models.Product;

public interface ProductService {

    List<Product> getAllProducts(String keyword);
    Optional<Product> getProductById(Long id);
    void saveProduct(Product product);
    void updateProduct(Long id, Product product);
    void deleteProduct(Long id);
      
    

    
}
