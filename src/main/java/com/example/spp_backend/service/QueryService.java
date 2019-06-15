package com.example.spp_backend.service;

import com.example.spp_backend.entity.*;

import java.util.List;

public interface QueryService {
    List<Alliance> queryAllianceList();

    List<ExhibitionHall> queryExhibitionHallList(Integer allianceId);

    List<Museum> queryMuseumList();

    List<Station> queryStationList();

    List<University> queryUniversityList(Integer stationId);

    List<Curriculum> queryCurriculumList(Integer universityId);

}
