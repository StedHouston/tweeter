package com.stedHouston.tweeter.repository;

import com.stedHouston.tweeter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByHandle(String handle);
}
