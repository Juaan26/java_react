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
@Table(name = "user")
public class User {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
 @Column(name = "id")
private Long id;

@Column(name = "admin")
private Boolean admin;

@Column(name = "first_name")
private String firstName;

@Column(name = "last_name")
private String lastName;

@Column(name = "email", unique = true, nullable = false)
private String email;

@Column(name = "address")
private String address;

@Column(name = "password")
private String password;



}
