package com.example.spp_backend.controller;

import com.example.spp_backend.entity.Curriculum;
import com.example.spp_backend.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class CurriculumController {
    @Autowired
    CurriculumService curriculumService;

    @GetMapping(path = "/getlist/latestcurriculum")
    public Map<String, Object> getLatestCurriculumList() {
        return curriculumService.getLatestCurriculumList();
    }


    @PostMapping(path = "/add/curriculum")
    public Map<String, Object> addCurriculum(@RequestBody Curriculum curriculum) {
        return curriculumService.addCurriculum(curriculum);
    }

    @PostMapping(path = "/delete/curriculum")
    public Map<String, Object> deleteCurriculum(@RequestBody Curriculum curriculum) {
        return curriculumService.deleteCurriculum(curriculum);
    }

    @PostMapping(path = "/update/curriculum")
    public Map<String, Object> updateCurriculum(@RequestBody Curriculum curriculum) {
        return curriculumService.updateCurriculum(curriculum);
    }

}
