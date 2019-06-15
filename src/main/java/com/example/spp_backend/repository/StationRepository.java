package com.example.spp_backend.repository;

import com.example.spp_backend.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, Integer> {
    Boolean existsStationByName(String name);

    Boolean existsStationById(Integer id);

    Integer deleteStationById(Integer id);

    Station findStationByName(String name);

    List<Station> getStationsByNameContains(String keyword);

}
