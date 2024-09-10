package com.ecommerce.java_react.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
 @Column(name = "id")
private Long id;

@Column(name = "brand")
private String brand;

@Column(name = "name")
private String name;

@Column(name = "slug")
private String slug;

@Column(name = "description")
private String description;

@Column(name = "image")
private String image;
}
