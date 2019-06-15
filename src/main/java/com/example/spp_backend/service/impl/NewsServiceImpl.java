package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.News;
import com.example.spp_backend.repository.NewsRepository;
import com.example.spp_backend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepository;

    @Override
    public Map<String, Object> getLatestNewsList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            List<News> latestNewsList = newsRepository.getAllByOrderByCreateTimeDesc();
            modelMap.put("success", true);
            modelMap.put("latestNewsList", latestNewsList);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e);
        }

        return modelMap;
    }

    @Override
    public Map<String, Object> addNews(News news) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            newsRepository.save(news);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e);
        }
        return modelMap;
    }

    @Override
    public Map<String, Object> deleteNews(News news) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            News realnews = newsRepository.getNewsByTitle(news.getTitle());
            newsRepository.deleteById(realnews.getId());
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e);
        }

        return modelMap;
    }

    @Override
    public Map<String, Object> updateNews(News newNews) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            News oldNews = newsRepository.getNewsById(newNews.getId());
            newsRepository.save(newNews);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e);
        }

        return modelMap;
    }

    @Override
    public Long getAllNewsCount() {
        return newsRepository.count();
    }

}
