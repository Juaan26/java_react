package com.ecommerce.java_react.service;

import java.util.List;
import java.util.Optional;
import com.ecommerce.java_react.models.Product;

public interface ProductService {

    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    void saveOrUpdateProduct(Product product);
    void deleteProduct(Long id);
      
    

    
}
