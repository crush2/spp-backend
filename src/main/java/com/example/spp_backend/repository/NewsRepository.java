package com.example.spp_backend.repository;

import com.example.spp_backend.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer>, CrudRepository<News, Integer>, JpaSpecificationExecutor {
    List<News> getAllByOrderByCreateTimeDesc();

    Boolean existsNewsByTitle(String title);

    News getNewsByTitle(String title);

    News getNewsById(Integer id);

    News getTopByOrderByCreateTimeDesc();

    Long countByCreateTimeIsAfter(Date today);

}
