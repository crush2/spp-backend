package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.*;
import com.example.spp_backend.repository.AllianceRepository;
import com.example.spp_backend.repository.MuseumRepository;
import com.example.spp_backend.repository.StationRepository;
import com.example.spp_backend.repository.UniversityRepository;
import com.example.spp_backend.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QueryServiceImpl implements QueryService {
    @Autowired
    AllianceRepository allianceRepository;
    @Autowired
    MuseumRepository museumRepository;
    @Autowired
    StationRepository stationRepository;
    @Autowired
    UniversityRepository universityRepository;

    @Override
    public List<Alliance> queryAllianceList() {
        return allianceRepository.findAll();
    }

    @Override
    public List<ExhibitionHall> queryExhibitionHallList(Integer allianceId) {
        Optional<Alliance> opt = Optional.of(allianceRepository.findById(allianceId)
                .orElseThrow(() -> new IllegalArgumentException()));
        Alliance alliance = opt.get();
        return alliance.getExhibitionHalls();
    }

    public List<Museum> queryMuseumList() {
        return museumRepository.findAll();
    }

    public List<Station> queryStationList() {
        return stationRepository.findAll();
    }

    @Override
    public List<University> queryUniversityList(Integer stationId) {
        Optional<Station> opt = Optional.of(stationRepository.findById(stationId)
                .orElseThrow(() -> new IllegalArgumentException()));
        Station station = opt.get();
        return station.getUniversityList();
    }

    @Override
    public List<Curriculum> queryCurriculumList(Integer universityId) {
        Optional<University> opt = Optional.of(universityRepository.findById(universityId)
                .orElseThrow(() -> new IllegalArgumentException()));
        University university = opt.get();
        return university.getCurriculumList();
    }
}
