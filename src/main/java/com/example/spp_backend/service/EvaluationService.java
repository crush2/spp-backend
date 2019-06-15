package com.example.spp_backend.service;

import java.util.Map;

public interface EvaluationService {
    Map<String, Object> getLatestEvaluationList();

    Long getAllEvaluationCount();

    Long getTodayEvaluationCount();
}
