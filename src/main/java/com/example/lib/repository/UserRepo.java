package com.example.lib.repository;

import com.example.lib.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;

public interface UserRepo extends JpaRepository<User, Long> {
    User getUserByUserId( Long userId);
}
