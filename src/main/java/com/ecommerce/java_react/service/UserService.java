package com.ecommerce.java_react.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.java_react.models.User;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    void saveOrUpdateUser(User user);
    void deleteUser(Long id);
      
}
