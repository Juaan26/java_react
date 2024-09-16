package com.ecommerce.java_react.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.java_react.models.Product;
import com.ecommerce.java_react.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.*;


@Service
public class ProductServiceImp implements ProductService {
    
        @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(String keyword) {
        if(keyword !=null){
            return productRepository.findAll(keyword);
        }
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
    @Override
    public void updateProduct(Long id, Product newProductData) {
        // Buscar el producto existente por ID
        Optional<Product> existingProductOptional = productRepository.findById(id);

        if (existingProductOptional.isPresent()) {
            // Si el producto existe, lo actualizamos
            Product existingProduct = existingProductOptional.get();
            
            // Actualiza los campos necesarios del producto
            existingProduct.setBrand(newProductData.getBrand());
            existingProduct.setName(newProductData.getName());
            existingProduct.setPrice(newProductData.getPrice());
            existingProduct.setSlug(newProductData.getSlug());
            existingProduct.setDescription(newProductData.getDescription());

            // Guardar el producto actualizado
            productRepository.save(existingProduct);
        } else {
            // Si el producto no existe, puedes lanzar una excepción o manejarlo como prefieras
            throw new EntityNotFoundException("Producto no encontrado con ID: " + id);
        }

   
}
}