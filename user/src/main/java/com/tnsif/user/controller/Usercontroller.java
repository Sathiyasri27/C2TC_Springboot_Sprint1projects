package com.tnsif.user.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tnsif.user.entity.User;
import com.tnsif.user.service.Userservice;


@RestController
@RequestMapping("/users")
public class Usercontroller {

    @Autowired
    private Userservice userService;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id).orElse(null);
    }

    // Create a new user (REST standard: no ID in path)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // Update user by ID
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}