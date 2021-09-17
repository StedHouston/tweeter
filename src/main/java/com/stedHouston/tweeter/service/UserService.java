package com.stedHouston.tweeter.service;

import com.stedHouston.tweeter.model.User;
import com.stedHouston.tweeter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        Optional<User> checkEmailDuplication = userRepository.findUserByEmail(user.getEmail());
        if (checkEmailDuplication.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        Optional<User> checkHandleDuplication = userRepository.findUserByHandle(user.getHandle());
        if (checkHandleDuplication.isPresent()) {
            throw new IllegalStateException("handle taken");
        }
        userRepository.save(user);
    }
}
