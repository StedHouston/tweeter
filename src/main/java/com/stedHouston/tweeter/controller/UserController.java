package com.stedHouston.tweeter.controller;

import com.stedHouston.tweeter.model.Role;
import com.stedHouston.tweeter.model.RoleToUserForm;
import com.stedHouston.tweeter.model.User;
import com.stedHouston.tweeter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users/save")
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.addUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.ok().body(userService.saveRole(role));
    }

    @PostMapping("/role/addRoleToUser")
    public ResponseEntity<Role> saveRole(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getHandle(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
