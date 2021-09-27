package com.stedHouston.tweeter.service;

import com.stedHouston.tweeter.model.Role;
import com.stedHouston.tweeter.model.Tweet;
import com.stedHouston.tweeter.model.User;
import com.stedHouston.tweeter.repository.RoleRepository;
import com.stedHouston.tweeter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String handle) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByUsername(handle);
        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found in the database");
        }

        User user = optionalUser.get();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
        Optional<User> checkEmailDuplication = userRepository.findUserByEmail(user.getEmail());
        if (checkEmailDuplication.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        Optional<User> checkHandleDuplication = userRepository.findUserByUsername(user.getUsername());
        if (checkHandleDuplication.isPresent()) {
            throw new IllegalStateException("username taken");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new IllegalStateException("user does not exist");
        }
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void addRoleToUser(String username, String roleName) {
        Optional<User> optionalUser = userRepository.findUserByUsername(username);
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
