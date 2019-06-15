package com.example.spp_backend.controller;

import com.example.spp_backend.entity.Curriculum;
import com.example.spp_backend.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class WarnController {
    @Autowired
    CurriculumService curriculumService;

    @GetMapping(path = "/getlist/warnedteacher")
    public List<Curriculum> getWarnedTeacherList(){
        return curriculumService.getWarnedCurriculumList();
    }
    @GetMapping(path = "/getlist/notwarnedteacher")
    public List<Curriculum> getNotWarnedTeacherList(){
        return curriculumService.getNotWarnedCurriculumList();
    }

    @GetMapping(path = "/getlist/warn")
    public Map<String,Object> getWarnList(){
        return curriculumService.getWarnList();
    }
}
