package com.tnsif.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.user.entity.User;

public interface Userrepository extends JpaRepository<User, Integer> {
}


