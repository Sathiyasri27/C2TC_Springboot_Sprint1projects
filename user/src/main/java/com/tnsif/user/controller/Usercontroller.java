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

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id).orElse(null);
    }


    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }


}
