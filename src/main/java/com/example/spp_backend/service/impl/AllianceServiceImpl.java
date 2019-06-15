package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.Alliance;
import com.example.spp_backend.repository.AllianceRepository;
import com.example.spp_backend.service.AllianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AllianceServiceImpl implements AllianceService {
    @Autowired
    AllianceRepository allianceRepository;

    @Override
    public List<Alliance> queryAllianceList() {
        return allianceRepository.findAll();
    }

    @Override
    public Map<String, Object> addAlliance(Alliance alliance) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean exists = allianceRepository.existsAllianceByName(alliance.getName());
        if (exists) {
            modelMap.put("success", false);
            modelMap.put("errmsg", "此场馆名称已存在");
        } else {
            allianceRepository.save(alliance);
            modelMap.put("success", true);
            modelMap.put("id", allianceRepository.findAllianceByName(alliance.getName()).getId());
        }
        return modelMap;
    }

    @Override
    public Map<String, Object> deleteAlliance(Alliance alliance) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean exists = allianceRepository.existsAllianceByName(alliance.getName());
        if (exists) {
            if (allianceRepository.deleteAllianceById(alliance.getId()) != 0) {
                modelMap.put("success", true);
            } else {
                modelMap.put("success", false);
                modelMap.put("errmsg", "删除失败");
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errmsg", "数据库中未找到待删除记录");
        }

        return modelMap;
    }

    @Override
    public Map<String, Object> updateAlliance(Alliance alliance) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean exists = allianceRepository.existsAllianceById(alliance.getId());
        if (exists) {
            allianceRepository.save(alliance);
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errmsg", "数据库中未找到待更新记录");
        }
        return modelMap;
    }

    @Override
    public Long getAllianceCount() {
        long count = allianceRepository.count();
        return count;
    }
}
