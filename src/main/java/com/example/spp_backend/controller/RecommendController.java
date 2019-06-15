package com.example.spp_backend.controller;

import com.example.spp_backend.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
public class RecommendController {
    @Autowired
    RecommendService recommendService;

    @PostMapping(path = "/getlist/recommend")
    public Map<String, Object> getRecommendList(@RequestParam(value = "longitude", required = true) String longitude,
                                                @RequestParam(value = "latitude", required = true) String latitude) {
        return recommendService.getRecommendList(longitude, latitude);
    }
}
