package com.example.spp_backend.repository;

import com.example.spp_backend.entity.Alliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AllianceRepository extends JpaRepository<Alliance, Integer>, CrudRepository<Alliance, Integer> {
    Boolean existsAllianceByName(String name);

    Boolean existsAllianceById(Integer id);

    Integer deleteAllianceById(Integer id);

    Alliance findAllianceByName(String name);

    Alliance findAllianceById(Integer id);

    List<Alliance> findAlliancesByLongitudeBetweenAndLatitudeBetween(String minLng, String maxLng, String minLat, String maxLat);

    List<Alliance> getAlliancesByNameContains(String keyword);
}
