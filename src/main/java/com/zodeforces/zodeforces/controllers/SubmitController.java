package com.zodeforces.zodeforces.controllers;

import com.zodeforces.zodeforces.services.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/submits")
public class SubmitController {
    private final SubmitService submitService;

    @Autowired
    public SubmitController(SubmitService submitService) {
        this.submitService = submitService;
    }

    @GetMapping(path = "/{id}")
    public Map<String, Object> getSubmitById(@PathVariable Long id) {
        return submitService.getSubmitById(id);
    }

    @PostMapping
    public void createSubmit(@RequestBody Map<String, Object> requestedSubmit) {
        submitService.createSubmit(requestedSubmit);
    }
}
