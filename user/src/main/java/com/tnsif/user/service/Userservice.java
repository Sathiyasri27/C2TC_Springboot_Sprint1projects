package com.tnsif.user.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tnsif.user.entity.User;
import com.tnsif.user.repository.Userrepository;

@Service
public class Userservice {

    @Autowired
    private Userrepository userRepository;

    // Add a new user
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    // Update user by ID
    public User updateUser(int id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setFullName(updatedUser.getFullName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setPhoneNumber(updatedUser.getPhoneNumber()); // ✅ New field
            user.setAddress(updatedUser.getAddress());         // ✅ New field
            user.setRole(updatedUser.getRole());               // ✅ New field
            return userRepository.save(user);
        }).orElse(null);
    }

    // Delete user by ID
    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
