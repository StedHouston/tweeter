package com.stedHouston.tweeter.controller;

import com.stedHouston.tweeter.model.Role;
import com.stedHouston.tweeter.model.User;
import com.stedHouston.tweeter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/save")
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.addUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.ok().body(userService.saveRole(role));
    }
}
