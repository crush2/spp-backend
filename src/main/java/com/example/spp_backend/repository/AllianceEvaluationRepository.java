package com.example.spp_backend.repository;

import com.example.spp_backend.entity.AllianceEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface AllianceEvaluationRepository extends JpaRepository<AllianceEvaluation, Integer>, CrudRepository<AllianceEvaluation, Integer>, JpaSpecificationExecutor {
    AllianceEvaluation getTopByOrderByCreateTimeDesc();

    Long countByCreateTimeIsAfter(Date today);

}
