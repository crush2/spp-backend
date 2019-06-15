package com.example.spp_backend.repository;

import com.example.spp_backend.entity.Museum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MuseumRepository extends JpaRepository<Museum, Integer> {
    Boolean existsMuseumByName(String name);

    Boolean existsMuseumById(Integer id);

    Integer deleteMuseumById(Integer id);

    Museum findMuseumByName(String name);

    Museum findMuseumById(Integer id);

    List<Museum> findMuseumsByLongitudeBetweenAndLatitudeBetween(String minLng, String maxLng, String minLat, String maxLat);

    List<Museum> getMuseumsByNameContains(String keyword);
}
