package com.ecommerce.java_react.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.java_react.models.Product;
import com.ecommerce.java_react.service.ProductServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> getProducts()
    {
        String keyword = "Apple";
        return productServiceImp.getAllProducts(keyword);

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
