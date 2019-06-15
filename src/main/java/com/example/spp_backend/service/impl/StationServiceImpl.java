package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.Station;
import com.example.spp_backend.repository.StationRepository;
import com.example.spp_backend.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StationServiceImpl implements StationService {
    @Autowired
    StationRepository stationRepository;

    @Override
    public List<Station> queryStationList() {
        return stationRepository.findAll();
    }

    @Override
    public Map<String, Object> addStation(Station station) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean exists = stationRepository.existsStationByName(station.getName());
        if (exists) {
            modelMap.put("success", false);
            modelMap.put("errmsg", "此场馆名称已存在");
        } else {
            stationRepository.save(station);
            modelMap.put("success", true);
            modelMap.put("id", stationRepository.findStationByName(station.getName()).getId());
        }
        return modelMap;
    }

    @Override
    public Map<String, Object> deleteStation(Station station) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean exists = stationRepository.existsStationByName(station.getName());
        if (exists) {
            if (stationRepository.deleteStationById(station.getId()) != 0) {
                modelMap.put("success", true);
            } else {
                modelMap.put("success", false);
                modelMap.put("errmsg", "删除失败");
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errmsg", "数据库中未找到待删除记录");
        }

        return modelMap;
    }

    @Override
    public Map<String, Object> updateStation(Station station) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean exists = stationRepository.existsStationById(station.getId());
        if (exists) {
            stationRepository.save(station);
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errmsg", "数据库中未找到待更新记录");
        }
        return modelMap;
    }

    @Override
    public Long getStationCount() {
        long count = stationRepository.count();

        return count;
    }
}
