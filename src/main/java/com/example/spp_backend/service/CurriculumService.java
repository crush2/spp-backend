package com.example.spp_backend.service;

import com.example.spp_backend.entity.Curriculum;

import java.util.List;
import java.util.Map;

public interface CurriculumService {
    Map<String, Object> getLatestCurriculumList();
    Map<String, Object> addCurriculum(Curriculum curriculum);

    Map<String, Object> deleteCurriculum(Curriculum curriculum);

    Map<String, Object> updateCurriculum(Curriculum newCurriculum);
    List<Curriculum> getTommorrowCurriculumList();
    List<Curriculum> getWarnedCurriculumList();
    List<Curriculum> getNotWarnedCurriculumList();
    Map<String,Object> getWarnList();
}
