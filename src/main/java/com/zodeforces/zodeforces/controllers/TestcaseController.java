package com.zodeforces.zodeforces.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/testcases")
public class TestcaseController {
    @GetMapping(path = "/{id}")
    public Map<String, Object> getTestById(@PathVariable Long id) {
        return new HashMap<>();
    }

    @PostMapping
    public void createTest(@RequestBody Map<String, Object> requestedTest) {

    }
}
