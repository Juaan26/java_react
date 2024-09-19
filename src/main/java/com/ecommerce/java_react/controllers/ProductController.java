package com.ecommerce.java_react.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.java_react.models.Product;
import com.ecommerce.java_react.service.ProductServiceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

     @Autowired
    private ProductServiceImp productServiceImp;

    @GetMapping
    public Page<Product> getProducts(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(value = "keyword" ,required = false ) String keyword)
    {

        Pageable pageable = PageRequest.of(page, size);
    
        return productServiceImp.getAllProducts(keyword, pageable);
    }
   

    
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long id)
    {

        return productServiceImp.getProductById(id);

    }
    @PostMapping
    public void createProduct(@RequestBody Product product)
    {
        productServiceImp.saveProduct(product);
    }
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        productServiceImp.updateProduct(id, product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {
        productServiceImp.deleteProduct(id);
    }
    
}
