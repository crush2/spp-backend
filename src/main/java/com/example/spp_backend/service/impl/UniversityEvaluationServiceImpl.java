package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.University;
import com.example.spp_backend.entity.UniversityEvaluation;
import com.example.spp_backend.repository.UniversityEvaluationRepository;
import com.example.spp_backend.repository.UniversityRepository;
import com.example.spp_backend.service.UniversityEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UniversityEvaluationServiceImpl implements UniversityEvaluationService {
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private UniversityEvaluationRepository universityEvaluationRepository;

    @Override
    public Map<String, Object> getUniversityEvaluationList(Integer universityId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        University university = universityRepository.findUniversityById(universityId);
        List<UniversityEvaluation> universityEvaluationList;
        try {
            universityEvaluationList = university.getUniversityEvaluations();
            modelMap.put("success", true);
            modelMap.put("evaluationList", universityEvaluationList);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.getMessage());
        }

        return modelMap;
    }

    @Override
    public Map<String, Object> addUniversityEvaluation(UniversityEvaluation universityEvaluation) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            universityEvaluationRepository.save(universityEvaluation);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.getMessage());
        }
        return modelMap;
    }

    @Override
    public Map<String, Object> deleteUniversityEvaluation(UniversityEvaluation universityEvaluation) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            universityEvaluationRepository.deleteById(universityEvaluation.getId());
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.getMessage());
        }
        return modelMap;
    }

    @Override
    public Long getUniversityEvaluationCount() {
        Long count = universityEvaluationRepository.count();
        return count;
    }
}
