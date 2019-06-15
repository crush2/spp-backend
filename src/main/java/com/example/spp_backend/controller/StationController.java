package com.example.spp_backend.controller;

import com.example.spp_backend.entity.Station;
import com.example.spp_backend.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping(path = "getlist/station")
    public Map<String, Object> getStationLsit() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Station> stationList = stationService.queryStationList();
        modelMap.put("stationList", stationList);
        modelMap.put("success", true);
        return modelMap;
    }

    @PostMapping(path = "add/station")
    public Map<String, Object> addStation(@RequestBody Station station) {
        return stationService.addStation(station);
    }

    @PostMapping(path = "delete/station")
    public Map<String, Object> deleteStation(@RequestBody Station station) {
        return stationService.deleteStation(station);
    }

    @PostMapping(path = "update/station")
    public Map<String, Object> updateStation(@RequestBody Station newStation) {
        return stationService.updateStation(newStation);
    }
}
