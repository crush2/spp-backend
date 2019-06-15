package com.example.spp_backend.repository;

import com.example.spp_backend.entity.UniversityEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface UniversityEvaluationRepository extends JpaRepository<UniversityEvaluation, Integer>, CrudRepository<UniversityEvaluation, Integer> {
    UniversityEvaluation getTopByOrderByCreateTimeDesc();

    Long countByCreateTimeIsAfter(Date today);

}
