package com.example.spp_backend.controller;

import com.example.spp_backend.entity.Alliance;
import com.example.spp_backend.entity.AllianceEvaluation;
import com.example.spp_backend.service.AllianceEvaluationService;
import com.example.spp_backend.service.AllianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class AllianceController {
    @Autowired
    private AllianceService allianceService;
    @Autowired
    private AllianceEvaluationService allianceEvaluationService;

    @RequestMapping(path = "getlist/alliance", method = RequestMethod.GET)
    public Map<String, Object> getAllianceList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Alliance> allianceList = allianceService.queryAllianceList();
        modelMap.put("allianceList", allianceList);
        modelMap.put("success", true);
        return modelMap;
    }

    @PostMapping(path = "add/alliance")
    public Map<String, Object> addAlliance(@RequestBody Alliance alliance) {
        return allianceService.addAlliance(alliance);
    }

    @PostMapping(path = "delete/alliance")
    public Map<String, Object> deleteAlliance(@RequestBody Alliance alliance) {
        return allianceService.deleteAlliance(alliance);
    }

    @PostMapping(path = "update/alliance")
    public Map<String, Object> updateAlliance(@RequestBody Alliance newAlliance) {
        return allianceService.updateAlliance(newAlliance);
    }

    //    @GetMapping(path = "getcount/alliance")
//    public Map<String, Object> getAllianceCount(){
//        return allianceService.getAllianceCount();
//    }
    @GetMapping(path = "getlist/allianceevaluation/{allianceId}")
    public Map<String, Object> getAllianceEvaluationList(@PathVariable Integer allianceId) {
        return allianceEvaluationService.getAllianceEvaluationList(allianceId);
    }

    @PostMapping(path = "add/allianceevaluation")
    public Map<String, Object> addAllianceEvaluation(@RequestBody AllianceEvaluation allianceEvaluation) {
        return allianceEvaluationService.addAllianceEvaluation(allianceEvaluation);
    }

    @PostMapping(path = "delet/allianceeevaluation")
    public Map<String, Object> deleteAllianceEvaluation(@RequestBody AllianceEvaluation allianceEvaluation) {
        return allianceEvaluationService.deleteAllianceEvaluation(allianceEvaluation);
    }

    @GetMapping(path = "getcount/allianceevaluation")
    public Map<String, Object> getAllianceEvaluationCount() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Long count = allianceEvaluationService.getAllianceEvaluationCount();
        modelMap.put("count", count);
        return modelMap;
    }
}
