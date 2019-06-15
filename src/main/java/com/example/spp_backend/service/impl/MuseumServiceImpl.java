package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.Museum;
import com.example.spp_backend.repository.MuseumRepository;
import com.example.spp_backend.service.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MuseumServiceImpl implements MuseumService {
    @Autowired
    MuseumRepository museumRepository;

    @Override
    public List<Museum> queryMuseumList() {
        return museumRepository.findAll();
    }

    @Override
    public Map<String, Object> addMuseum(Museum museum) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean exists = museumRepository.existsMuseumByName(museum.getName());
        if (exists) {
            modelMap.put("success", false);
            modelMap.put("errmsg", "此场馆名称已存在");
        } else {
            museumRepository.save(museum);
            modelMap.put("success", true);
            modelMap.put("id", museumRepository.findMuseumByName(museum.getName()).getId());
        }
        return modelMap;
    }

    @Override
    public Map<String, Object> deleteMuseum(Museum museum) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean exists = museumRepository.existsMuseumByName(museum.getName());
        if (exists) {
            if (museumRepository.deleteMuseumById(museum.getId()) != 0) {
                modelMap.put("success", true);
            } else {
                modelMap.put("success", false);
                modelMap.put("errmsg", "删除失败");
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errmsg", "数据库中待删除相应记录");
        }

        return modelMap;
    }

    @Override
    public Map<String, Object> updateMuseum(Museum museum) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean exists = museumRepository.existsMuseumById(museum.getId());
        if (exists) {
            museumRepository.save(museum);
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errmsg", "数据库中待更新相应记录");
        }
        return modelMap;
    }

    @Override
    public Long getMuseumCount() {
        long count = museumRepository.count();
        return count;
    }
}
