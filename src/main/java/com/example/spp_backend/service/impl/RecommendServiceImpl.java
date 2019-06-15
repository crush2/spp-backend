package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.Alliance;
import com.example.spp_backend.entity.Museum;
import com.example.spp_backend.entity.University;
import com.example.spp_backend.repository.AllianceRepository;
import com.example.spp_backend.repository.MuseumRepository;
import com.example.spp_backend.repository.UniversityRepository;
import com.example.spp_backend.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    AllianceRepository allianceRepository;
    @Autowired
    MuseumRepository museumRepository;
    @Autowired
    UniversityRepository universityRepository;

    public List<String> getSquare(String longitude_str, String latitude_str) {
        double longitude = Double.valueOf(longitude_str);
        double latitude = Double.valueOf(latitude_str);

        //先计算查询点的经纬度范围
        double r = 6371;//地球半径千米
        double dis = 2;//0.5千米距离
        //Haversine公式计算球面距离
        double dlng = 2 * Math.asin(Math.sin(dis / (2 * r)) / Math.cos(latitude * Math.PI / 180));
        dlng = dlng * 180 / Math.PI;//角度转为弧度
        double dlat = dis / r;
        dlat = dlat * 180 / Math.PI;
        double minlat = latitude - dlat;
        double maxlat = latitude + dlat;
        double minlng = longitude - dlng;
        double maxlng = longitude + dlng;

        List<String> square = new ArrayList<String>();
        square.add(String.valueOf(minlng));
        square.add(String.valueOf(maxlng));
        square.add(String.valueOf(minlat));
        square.add(String.valueOf(maxlat));
        return square;
    }

    @Override
    public Map<String, Object> getRecommendList(String longitude, String latitude) {
        List<String> square = getSquare(longitude, latitude);
        Map<String, Object> modelMap = new HashMap<String, Object>();

        try {
            List<Alliance> recommendAllianceList = allianceRepository
                    .findAlliancesByLongitudeBetweenAndLatitudeBetween(square.get(0), square.get(1), square.get(2), square.get(3));
            List<Museum> recommendMuseumList = museumRepository
                    .findMuseumsByLongitudeBetweenAndLatitudeBetween(square.get(0), square.get(1), square.get(2), square.get(3));
            List<University> recommendUniversityList = universityRepository
                    .findUniversitiesByLongitudeBetweenAndLatitudeBetween(square.get(0), square.get(1), square.get(2), square.get(3));

            List<Map<String, Object>> recommendMapList = new ArrayList<Map<String, Object>>();

            for (Alliance allianceRecommend : recommendAllianceList) {
                Map<String, Object> recommendMap = new HashMap<String, Object>();
                recommendMap.put("type", 0);
                recommendMap.put("recommend", allianceRecommend);
                recommendMapList.add(recommendMap);
            }
            for (Museum museumRecommend : recommendMuseumList) {
                Map<String, Object> recommendMap = new HashMap<String, Object>();
                recommendMap.put("type", 1);
                recommendMap.put("recommend", museumRecommend);
                recommendMapList.add(recommendMap);
            }
            for (University universityRecommend : recommendUniversityList) {
                Map<String, Object> recommendMap = new HashMap<String, Object>();
                recommendMap.put("type", 2);
                recommendMap.put("recommend", universityRecommend);
                recommendMapList.add(recommendMap);
            }


            modelMap.put("success", true);
            modelMap.put("recommendList", recommendMapList);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.toString());
        }

        return modelMap;
    }
}
