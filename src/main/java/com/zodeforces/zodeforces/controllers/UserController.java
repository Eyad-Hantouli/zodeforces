package com.zodeforces.zodeforces.controllers;

import com.zodeforces.zodeforces.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{userName}")
    public Map<String, Object> getUserById(@PathVariable String userName) {
        return userService.getUserById(userName);
    }

    @PostMapping
    public void createUser(@RequestBody Map<String, Object> requestedUser) {
        userService.createUser(requestedUser);
    }

}
