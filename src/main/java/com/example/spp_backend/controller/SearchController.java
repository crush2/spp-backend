package com.example.spp_backend.controller;

import com.example.spp_backend.entity.Keyword;
import com.example.spp_backend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class SearchController {
    @Autowired
    SearchService searchService;

    @PostMapping(path = "/getlist/search")
    public Map<String, Object> getResultList(@RequestBody Keyword keyword) {
        return searchService.getResultList(keyword);
    }

}
