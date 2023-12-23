package com.zodeforces.zodeforces.controllers;

import com.zodeforces.zodeforces.services.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/problems")
public class ProblemController {
    private final ProblemService problemService;

    @Autowired
    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping(path = "/{id}")
    public Map<String, Object> getProblemById(@PathVariable Long id) {
        return problemService.getProblemById(id);
    }

    @PostMapping
    public void createProblem(@RequestBody Map<String, Object> requestedProblem) {
        problemService.createProblem(requestedProblem);
    }
}
