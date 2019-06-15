package com.example.spp_backend.controller;

import com.example.spp_backend.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @GetMapping(path = "getlist/latestevaluation")
    public Map<String, Object> getLatestEvaluatioinList() {
        return evaluationService.getLatestEvaluationList();
    }

    @GetMapping(path = "getcount/allevaluation")
    public Long getAllEvaluationCount() {
        return evaluationService.getAllEvaluationCount();
    }

    @GetMapping(path = "getcount/todayevaluation")
    public Long getTodayEvaluatioinList() {
        return evaluationService.getTodayEvaluationCount();
    }


}
