package com.zodeforces.zodeforces.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/problems")
public class ProblemController {
    @GetMapping(path = "/{id}")
    public Map<String, Object> getProblemById(@PathVariable Long id) {
        return new HashMap<>();
    }

    @PostMapping
    public void createProblem(@RequestBody Map<String, Object> requestedProblem) {

    }
}
