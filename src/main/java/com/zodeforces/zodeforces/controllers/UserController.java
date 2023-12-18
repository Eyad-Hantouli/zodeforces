package com.zodeforces.zodeforces.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @GetMapping(path = "/{userName}")
    public Map<String, Object> getUserById(@PathVariable String userName) {
        return new HashMap<>();
    }

    @PostMapping
    public void createUser(@RequestBody Map<String, Object> requestedUser) {

    }

}
