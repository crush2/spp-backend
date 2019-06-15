package com.example.spp_backend.service;

import com.example.spp_backend.entity.Station;

import java.util.List;
import java.util.Map;

public interface StationService {
    List<Station> queryStationList();

    Map<String, Object> addStation(Station alliance);

    Map<String, Object> deleteStation(Station alliance);

    Map<String, Object> updateStation(Station newStation);

    Long getStationCount();
}
