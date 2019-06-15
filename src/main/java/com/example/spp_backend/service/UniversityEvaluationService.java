package com.example.spp_backend.service;

import com.example.spp_backend.entity.UniversityEvaluation;

import java.util.Map;

public interface UniversityEvaluationService {
    Map<String, Object> getUniversityEvaluationList(Integer universityId);

    Map<String, Object> addUniversityEvaluation(UniversityEvaluation universityEvaluation);

    Map<String, Object> deleteUniversityEvaluation(UniversityEvaluation universityEvaluation);

    Long getUniversityEvaluationCount();
}
