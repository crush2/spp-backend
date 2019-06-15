package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.Alliance;
import com.example.spp_backend.entity.AllianceEvaluation;
import com.example.spp_backend.repository.AllianceEvaluationRepository;
import com.example.spp_backend.repository.AllianceRepository;
import com.example.spp_backend.service.AllianceEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AllianceEvaluationServiceImpl implements AllianceEvaluationService {
    @Autowired
    private AllianceRepository allianceRepository;
    @Autowired
    private AllianceEvaluationRepository allianceEvaluationRepository;

    @Override
    public Map<String, Object> getAllianceEvaluationList(Integer allianceId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Alliance alliance = allianceRepository.findAllianceById(allianceId);
        List<AllianceEvaluation> allianceEvaluationList;
        try {
            allianceEvaluationList = alliance.getAllianceEvaluations();
            modelMap.put("success", true);
            modelMap.put("evaluationList", allianceEvaluationList);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.getMessage());
        }

        return modelMap;
    }

    @Override
    public Map<String, Object> addAllianceEvaluation(AllianceEvaluation allianceEvaluation) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            allianceEvaluationRepository.save(allianceEvaluation);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e);
        }
        return modelMap;
    }

    @Override
    public Map<String, Object> deleteAllianceEvaluation(AllianceEvaluation allianceEvaluation) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            allianceEvaluationRepository.deleteById(allianceEvaluation.getId());
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.getMessage());
        }
        return modelMap;
    }

    @Override
    public Long getAllianceEvaluationCount() {
        Long count = allianceEvaluationRepository.count();
        return count;
    }
}
