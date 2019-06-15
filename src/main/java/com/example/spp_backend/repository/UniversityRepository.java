package com.example.spp_backend.repository;

import com.example.spp_backend.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Integer> {
    University findUniversityById(Integer id);

    List<University> findUniversitiesByLongitudeBetweenAndLatitudeBetween(String minLng, String maxLng, String minLat, String maxLat);

}
