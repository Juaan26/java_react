package com.ecommerce.java_react.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.java_react.service.UserService;
import com.ecommerce.java_react.models.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers()
    {

        return userService.getAllUsers();

    }
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") Long id)
    {

        return userService.getUserById(id);

    }
    @PostMapping
    public void createUpdateUser(@RequestBody User user)
    {
        userService.saveOrUpdateUser(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id)
    {
        userService.deleteUser(id);
    }
    
}
