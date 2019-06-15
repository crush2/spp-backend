package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.Museum;
import com.example.spp_backend.entity.MuseumEvaluation;
import com.example.spp_backend.repository.MuseumEvaluationRepository;
import com.example.spp_backend.repository.MuseumRepository;
import com.example.spp_backend.service.MuseumEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MuseumEvaluationServiceImpl implements MuseumEvaluationService {
    @Autowired
    private MuseumRepository museumRepository;
    @Autowired
    private MuseumEvaluationRepository museumEvaluationRepository;

    @Override
    public Map<String, Object> getMuseumEvaluationList(Integer museumId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Museum museum = museumRepository.findMuseumById(museumId);
        List<MuseumEvaluation> museumEvaluationList;
        try {
            museumEvaluationList = museum.getMuseumEvaluations();
            modelMap.put("success", true);
            modelMap.put("evaluationList", museumEvaluationList);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.getMessage());
        }

        return modelMap;
    }

    @Override
    public Map<String, Object> addMuseumEvaluation(MuseumEvaluation museumEvaluation) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            museumEvaluationRepository.save(museumEvaluation);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.getMessage());
        }
        return modelMap;
    }

    @Override
    public Map<String, Object> deleteMuseumEvaluation(MuseumEvaluation museumEvaluation) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            museumEvaluationRepository.deleteById(museumEvaluation.getId());
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.getMessage());
        }
        return modelMap;
    }

    @Override
    public Long getMuseumEvaluationCount() {
        Long count = museumEvaluationRepository.count();
        return count;
    }
}
