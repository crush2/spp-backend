package com.example.spp_backend.repository;

import com.example.spp_backend.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface CurriculumRepository extends JpaRepository<Curriculum, Integer>, CrudRepository<Curriculum, Integer>, JpaSpecificationExecutor {
    Curriculum getCurriculumByName(String title);
    List<Curriculum> getAllByOrderByTimeDesc();
    Curriculum getCurriculumById(Integer id);
    List<Curriculum> getCurriculumByTimeBetween(Date tommorrow0, Date tommorrow24);
    List<Curriculum> getCurriculumByWarnTimeNull();
    List<Curriculum> getCurriculumByWarnTimeNotNull();
    List<Curriculum> getCurriculumByWarnTimeEquals(Date warnTime);
    List<Curriculum> getCurriculumByWarnTimeIsAfter(Date warnTime);
}