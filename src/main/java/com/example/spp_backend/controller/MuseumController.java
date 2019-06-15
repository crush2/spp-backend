package com.example.spp_backend.controller;

import com.example.spp_backend.entity.Museum;
import com.example.spp_backend.entity.MuseumEvaluation;
import com.example.spp_backend.service.MuseumEvaluationService;
import com.example.spp_backend.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class MuseumController {
    @Autowired
    private MuseumService museumService;
    @Autowired
    private MuseumEvaluationService museumEvaluationService;

    @GetMapping(path = "getlist/museum")
    public Map<String, Object> getMuseumLsit() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Museum> museumList = museumService.queryMuseumList();
        modelMap.put("museumList", museumList);
        modelMap.put("success", true);
        return modelMap;
    }

    @PostMapping(path = "add/museum")
    public Map<String, Object> addMuseum(@RequestBody Museum museum) {
        return museumService.addMuseum(museum);
    }

    @PostMapping(path = "delete/museum")
    public Map<String, Object> deleteMuseum(@RequestBody Museum museum) {
        return museumService.deleteMuseum(museum);
    }

    @PostMapping(path = "update/museum")
    public Map<String, Object> updateMuseum(@RequestBody Museum newMuseum) {
        return museumService.updateMuseum(newMuseum);
    }

    @GetMapping(path = "getlist/museumevaluation/{museumId}")
    public Map<String, Object> getMuseumEvaluationList(@PathVariable Integer museumId) {
        return museumEvaluationService.getMuseumEvaluationList(museumId);
    }

    @PostMapping(path = "add/museumevaluation")
    public Map<String, Object> addMuseumEvaluation(@RequestBody MuseumEvaluation museumEvaluation) {
        return museumEvaluationService.addMuseumEvaluation(museumEvaluation);
    }

    @PostMapping(path = "delete/museumevaluation")
    public Map<String, Object> deleteMuseumEvaluation(@RequestBody MuseumEvaluation museumEvaluation) {
        return museumEvaluationService.deleteMuseumEvaluation(museumEvaluation);
    }

    @GetMapping(path = "getcount/museumevaluation")
    public Map<String, Object> getMuseumEvaluationCount() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Long count = museumEvaluationService.getMuseumEvaluationCount();
        modelMap.put("count", count);
        return modelMap;
    }
}
