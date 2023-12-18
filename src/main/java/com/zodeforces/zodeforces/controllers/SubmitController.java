package com.zodeforces.zodeforces.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/submits")
public class SubmitController {
    @GetMapping(path = "/{id}")
    public Map<String, Object> getSubmitById(@PathVariable Long id) {
        return new HashMap<>();
    }

    @PostMapping
    public void createSubmit(@RequestBody Map<String, Object> requestedSubmit) {

    }
}
