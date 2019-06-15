package com.example.spp_backend.service;

import com.example.spp_backend.entity.Alliance;

import java.util.List;
import java.util.Map;

public interface AllianceService {
    List<Alliance> queryAllianceList();

    Map<String, Object> addAlliance(Alliance alliance);

    Map<String, Object> deleteAlliance(Alliance alliance);

    Map<String, Object> updateAlliance(Alliance newAlliance);

    Long getAllianceCount();
}
