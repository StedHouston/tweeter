package com.stedHouston.tweeter.service;

import com.stedHouston.tweeter.model.Role;
import com.stedHouston.tweeter.model.User;
import com.stedHouston.tweeter.repository.RoleRepository;
import com.stedHouston.tweeter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User addUser(User user) {
        Optional<User> checkEmailDuplication = userRepository.findUserByEmail(user.getEmail());
        if (checkEmailDuplication.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        Optional<User> checkHandleDuplication = userRepository.findUserByHandle(user.getHandle());
        if (checkHandleDuplication.isPresent()) {
            throw new IllegalStateException("handle taken");
        }
        return userRepository.save(user);
    }

    public User getUser(String handle) {
        Optional<User> optionalUser = userRepository.findUserByHandle(handle);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new IllegalStateException("user does not exist");
        }
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void addRoleToUser(String handle, String roleName) {
        Optional<User> optionalUser = userRepository.findUserByHandle(handle);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Role role = roleRepository.findByName(roleName);
            user.getRoles().add(role);
        } else {
            throw new IllegalStateException("user does not exist");
        }
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
