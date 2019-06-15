package com.example.spp_backend.service;

import java.util.Map;

public interface RecommendService {
    Map<String, Object> getRecommendList(String longitude, String latitude);

}
