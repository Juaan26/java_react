package com.ecommerce.java_react.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Product> getAllProducts(String keyword, Pageable pageable) {
        if (keyword != null && !keyword.isEmpty()) {
            return productRepository.findByKeyword(keyword, pageable); // Llamada al método personalizado
        }
        return productRepository.findAll(pageable); // Si no hay palabra clave, devolver todos los productos
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