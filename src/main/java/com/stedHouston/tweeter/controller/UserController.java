package com.stedHouston.tweeter.controller;

import com.stedHouston.tweeter.model.User;
import com.stedHouston.tweeter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
