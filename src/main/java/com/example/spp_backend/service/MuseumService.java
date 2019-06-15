package com.example.spp_backend.service;

import com.example.spp_backend.entity.Museum;

import java.util.List;
import java.util.Map;

public interface MuseumService {
    List<Museum> queryMuseumList();

    Map<String, Object> addMuseum(Museum alliance);

    Map<String, Object> deleteMuseum(Museum alliance);

    Map<String, Object> updateMuseum(Museum newMuseum);

    Long getMuseumCount();
}
