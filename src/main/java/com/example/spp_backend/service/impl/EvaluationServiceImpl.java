package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.AllianceEvaluation;
import com.example.spp_backend.entity.MuseumEvaluation;
import com.example.spp_backend.entity.UniversityEvaluation;
import com.example.spp_backend.repository.AllianceEvaluationRepository;
import com.example.spp_backend.repository.MuseumEvaluationRepository;
import com.example.spp_backend.repository.UniversityEvaluationRepository;
import com.example.spp_backend.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    AllianceEvaluationRepository allianceEvaluationRepository;
    @Autowired
    MuseumEvaluationRepository museumEvaluationRepository;
    @Autowired
    UniversityEvaluationRepository universityEvaluationRepository;

    @Override
    public Map<String, Object> getLatestEvaluationList() {
        AllianceEvaluation allianceEvaluation = allianceEvaluationRepository.getTopByOrderByCreateTimeDesc();
        MuseumEvaluation museumEvaluation = museumEvaluationRepository.getTopByOrderByCreateTimeDesc();
        UniversityEvaluation universityEvaluation = universityEvaluationRepository.getTopByOrderByCreateTimeDesc();

        Map<String, Object> evaluation_alliance = new HashMap<String, Object>();
        evaluation_alliance.put("star", allianceEvaluation.getStar());
        evaluation_alliance.put("review", allianceEvaluation.getReview());
        evaluation_alliance.put("createTime", allianceEvaluation.getCreateTime());
        Map<String, Object> evaluation_museum = new HashMap<String, Object>();
        evaluation_museum.put("star", museumEvaluation.getStar());
        evaluation_museum.put("review", museumEvaluation.getReview());
        evaluation_museum.put("createTime", museumEvaluation.getCreateTime());
        Map<String, Object> evaluation_university = new HashMap<String, Object>();
        evaluation_university.put("star", universityEvaluation.getStar());
        evaluation_university.put("review", universityEvaluation.getReview());
        evaluation_university.put("createTime", universityEvaluation.getCreateTime());

        List<Map<String, Object>> latestEvaluationList = new ArrayList<Map<String, Object>>();
        latestEvaluationList.add(evaluation_alliance);
        latestEvaluationList.add(evaluation_museum);
        latestEvaluationList.add(evaluation_university);

        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("latestEvaluationList", latestEvaluationList);

        return modelMap;
    }

    @Override
    public Long getAllEvaluationCount() {
        Long allEvaluationCount = allianceEvaluationRepository.count() + museumEvaluationRepository.count() + universityEvaluationRepository.count();
        return allEvaluationCount;
    }

    @Override
    public Long getTodayEvaluationCount() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date today = calendar.getTime();
        Long allianceCount = allianceEvaluationRepository.countByCreateTimeIsAfter(today);
        Long museumCount = museumEvaluationRepository.countByCreateTimeIsAfter(today);
        Long universityCount = universityEvaluationRepository.countByCreateTimeIsAfter(today);

        return allianceCount + museumCount + universityCount;
    }
}
