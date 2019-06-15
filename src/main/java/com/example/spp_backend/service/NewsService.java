package com.example.spp_backend.service;

import com.example.spp_backend.entity.News;

import java.util.Map;

public interface NewsService {
    Map<String, Object> getLatestNewsList();

    Map<String, Object> addNews(News news);

    Map<String, Object> deleteNews(News news);

    Map<String, Object> updateNews(News newNews);

    Long getAllNewsCount();
}
