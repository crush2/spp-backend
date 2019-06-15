package com.example.spp_backend.controller;

import com.example.spp_backend.entity.News;
import com.example.spp_backend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping(path = "/getlist/latestnews")
    public Map<String, Object> getLatestNewsList() {
        return newsService.getLatestNewsList();
    }

    @PostMapping(path = "/add/news")
    public Map<String, Object> addNews(@RequestBody News news) {
        return newsService.addNews(news);
    }

    @PostMapping(path = "/delete/news")
    public Map<String, Object> deleteNews(@RequestBody News news) {
        return newsService.deleteNews(news);
    }

    @PostMapping(path = "/update/news")
    public Map<String, Object> updateNews(@RequestBody News news) {
        return newsService.updateNews(news);
    }

    @GetMapping(path = "/getcount/allnews")
    public Long getAllNewsCount() {
        return newsService.getAllNewsCount();
    }

}
