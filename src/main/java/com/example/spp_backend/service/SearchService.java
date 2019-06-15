package com.example.spp_backend.service;

import com.example.spp_backend.entity.Keyword;

import java.util.Map;

public interface SearchService {
    Map<String, Object> getResultList(Keyword keyword);
}
