package com.example.spp_backend.service;

import com.example.spp_backend.entity.AllianceEvaluation;

import java.util.Map;

public interface AllianceEvaluationService {
    Map<String, Object> getAllianceEvaluationList(Integer allianceId);

    Map<String, Object> addAllianceEvaluation(AllianceEvaluation allianceEvaluation);

    Map<String, Object> deleteAllianceEvaluation(AllianceEvaluation allianceEvaluation);

    Long getAllianceEvaluationCount();
}
