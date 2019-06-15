package com.example.spp_backend.repository;

import com.example.spp_backend.entity.MuseumEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface MuseumEvaluationRepository extends JpaRepository<MuseumEvaluation, Integer>, CrudRepository<MuseumEvaluation, Integer> {
    MuseumEvaluation getTopByOrderByCreateTimeDesc();

    Long countByCreateTimeIsAfter(Date today);

}
