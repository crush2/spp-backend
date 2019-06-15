package com.example.spp_backend.controller;

import com.example.spp_backend.entity.UniversityEvaluation;
import com.example.spp_backend.service.UniversityEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class UniversityController {
    @Autowired
    private UniversityEvaluationService universityEvaluationService;

    @GetMapping(path = "getlist/universityevaluation/{universityId}")
    public Map<String, Object> getUniversityEvaluationList(@PathVariable Integer universityId) {
        return universityEvaluationService.getUniversityEvaluationList(universityId);
    }

    @PostMapping(path = "add/universityevaluation")
    public Map<String, Object> addUniversityEvaluation(@RequestBody UniversityEvaluation universityEvaluation) {
        return universityEvaluationService.addUniversityEvaluation(universityEvaluation);
    }

    @PostMapping(path = "delete/universityevaluation")
    public Map<String, Object> deleteUniversityEvaluation(@RequestBody UniversityEvaluation universityEvaluation) {
        return universityEvaluationService.deleteUniversityEvaluation(universityEvaluation);
    }

    @GetMapping(path = "getcount/universityevaluation")
    public Map<String, Object> getUniversityEvaluationCount() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Long count = universityEvaluationService.getUniversityEvaluationCount();
        modelMap.put("count", count);
        return modelMap;
    }
}
