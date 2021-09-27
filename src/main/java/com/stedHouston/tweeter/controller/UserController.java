package com.stedHouston.tweeter.controller;

import com.stedHouston.tweeter.model.Role;
import com.stedHouston.tweeter.model.RoleToUserForm;
import com.stedHouston.tweeter.model.Tweet;
import com.stedHouston.tweeter.model.User;
import com.stedHouston.tweeter.service.TweetService;
import com.stedHouston.tweeter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class UserController {

    private final UserService userService;
    private final TweetService tweetService;

    @Autowired
    public UserController(UserService userService, TweetService tweetService) {
        this.userService = userService;
        this.tweetService = tweetService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(Authentication authentication) {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users/save")
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

    @PostMapping("/users/tweet")
    public ResponseEntity<Tweet> saveTweet(@RequestBody Tweet tweet, Authentication authentication) {
        return ResponseEntity.ok().body(tweetService.saveTweet(tweet, authentication.getName()));
    }

    @GetMapping("/users/{id}/tweets")
    public ResponseEntity<User> getUserTweets(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return ResponseEntity.ok().body(userService.saveRole(role));
    }

    @PostMapping("/role/addRoleToUser")
    public ResponseEntity<Role> saveRole(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
