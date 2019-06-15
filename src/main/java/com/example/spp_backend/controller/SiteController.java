package com.example.spp_backend.controller;

import com.example.spp_backend.entity.Curriculum;
import com.example.spp_backend.entity.ExhibitionHall;
import com.example.spp_backend.entity.University;
import com.example.spp_backend.service.AllianceService;
import com.example.spp_backend.service.MuseumService;
import com.example.spp_backend.service.QueryService;
import com.example.spp_backend.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class SiteController {
    @Autowired
    private QueryService queryService;
    @Autowired
    private AllianceService allianceService;
    @Autowired
    private MuseumService museumService;
    @Autowired
    private StationService stationService;


    @RequestMapping(path = "getexhibitionhalllist/{allianceid}", method = RequestMethod.GET)
    Map<String, Object> getExhibitionHallList(@PathVariable("allianceid") Integer allianceId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ExhibitionHall> exhibitionHallList = queryService.queryExhibitionHallList(allianceId);
        modelMap.put("exhibitionHallList", exhibitionHallList);
        modelMap.put("success", true);

        return modelMap;
    }

    @RequestMapping(path = "getuniversitylist/{stationid}", method = RequestMethod.GET)
    public Map<String, Object> getUniversityList(@PathVariable("stationid") Integer stationId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<University> universityList = queryService.queryUniversityList(stationId);
        modelMap.put("universityList", universityList);
        modelMap.put("success", true);

        return modelMap;
    }

    @RequestMapping(path = "getcurriculumlist/{universityid}", method = RequestMethod.GET)
    public Map<String, Object> getCurriculumList(@PathVariable("universityid") Integer universityId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Curriculum> curriculumList = queryService.queryCurriculumList(universityId);
        modelMap.put("curriculumList", curriculumList);
        modelMap.put("success", true);

        return modelMap;
    }

    @GetMapping(path = "getsitecount")
    public Map<String, Object> getSiteCount() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        long allianceCount = allianceService.getAllianceCount();
        long museumCount = museumService.getMuseumCount();
        long stationCount = stationService.getStationCount();
        modelMap.put("allianceCount", allianceCount);
        modelMap.put("museumCount", museumCount);
        modelMap.put("stationCount", stationCount);

        return modelMap;

    }

}
