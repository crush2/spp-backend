package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.Alliance;
import com.example.spp_backend.entity.Keyword;
import com.example.spp_backend.entity.Museum;
import com.example.spp_backend.entity.Station;
import com.example.spp_backend.repository.AllianceRepository;
import com.example.spp_backend.repository.MuseumRepository;
import com.example.spp_backend.repository.StationRepository;
import com.example.spp_backend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {
    @Autowired
    AllianceRepository allianceRepository;
    @Autowired
    MuseumRepository museumRepository;
    @Autowired
    StationRepository stationRepository;
    
    @Override
    public Map<String, Object> getResultList(Keyword keyword) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        try {
            List<Alliance> resultAllianceList = allianceRepository.getAlliancesByNameContains(keyword.getValue());
            List<Museum> resultMuseumList = museumRepository.getMuseumsByNameContains(keyword.getValue());
            List<Station> resultStationList = stationRepository.getStationsByNameContains(keyword.getValue());

            List<Map<String, Object>> resultMapList = new ArrayList<Map<String, Object>>();

            for (Alliance allianceResult : resultAllianceList) {
                Map<String, Object> resultMap = new HashMap<String, Object>();
                resultMap.put("type", 0);
                resultMap.put("result", allianceResult);
                resultMapList.add(resultMap);
            }
            for (Museum museumResult : resultMuseumList) {
                Map<String, Object> resultMap = new HashMap<String, Object>();
                resultMap.put("type", 1);
                resultMap.put("result", museumResult);
                resultMapList.add(resultMap);
            }
            for (Station stationResult : resultStationList) {
                Map<String, Object> resultMap = new HashMap<String, Object>();
                resultMap.put("type", 2);
                resultMap.put("result", stationResult);
                resultMapList.add(resultMap);
            }


            modelMap.put("success", true);
            modelMap.put("resultList", resultMapList);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.toString());
        }

        return modelMap;
    }
}
