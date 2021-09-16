package com.stedHouston.tweeter.repository;

import com.stedHouston.tweeter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
