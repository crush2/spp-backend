package com.example.spp_backend.service;

import com.example.spp_backend.entity.MuseumEvaluation;

import java.util.Map;

public interface MuseumEvaluationService {
    Map<String, Object> getMuseumEvaluationList(Integer museumId);

    Map<String, Object> addMuseumEvaluation(MuseumEvaluation museumEvaluation);

    Map<String, Object> deleteMuseumEvaluation(MuseumEvaluation museumEvaluation);

    Long getMuseumEvaluationCount();
}
