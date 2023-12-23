package com.zodeforces.zodeforces.controllers;

import com.zodeforces.zodeforces.services.TestcaseService;
import com.zodeforces.zodeforces.tables.Testcase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/testcases")
public class TestcaseController {
    private final TestcaseService testcaseService;

    @Autowired
    public TestcaseController(TestcaseService testcaseService) {
        this.testcaseService = testcaseService;
    }

    @GetMapping(path = "/{id}")
    public Map<String, Object> getTestById(@PathVariable Long id) {
        return testcaseService.getTestById(id);
    }

    @PostMapping
    public void createTest(@RequestBody Map<String, Object> requestedTest) {
        testcaseService.createTest(requestedTest);
    }
}
