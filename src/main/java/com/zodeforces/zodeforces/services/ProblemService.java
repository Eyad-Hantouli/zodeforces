package com.zodeforces.zodeforces.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProblemService {

    public Map<String, Object> getProblemById(Long id) {
        return new HashMap<>();
    }

    public void createProblem(Map<String, Object> requestedProblem) {

    }
}
