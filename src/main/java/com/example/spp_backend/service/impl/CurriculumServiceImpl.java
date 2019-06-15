package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.Curriculum;
import com.example.spp_backend.repository.CurriculumRepository;
import com.example.spp_backend.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CurriculumServiceImpl implements CurriculumService {
    @Autowired
    CurriculumRepository curriculumRepository;

    @Override
    public Map<String, Object> getLatestCurriculumList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            List<Curriculum> latestCurriculumList = curriculumRepository.getAllByOrderByTimeDesc();
            modelMap.put("success", true);
            modelMap.put("latestCurriculumList", latestCurriculumList);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e);
        }

        return modelMap;
    }
    
    @Override
    public Map<String, Object> addCurriculum(Curriculum curriculum) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            curriculumRepository.save(curriculum);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e);
        }
        return modelMap;
    }

    @Override
    public Map<String, Object> deleteCurriculum(Curriculum curriculum) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            Curriculum realcurriculum = curriculumRepository.getCurriculumByName(curriculum.getName());
            curriculumRepository.deleteById(realcurriculum.getId());
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e);
        }

        return modelMap;
    }

    @Override
    public Map<String, Object> updateCurriculum(Curriculum newCurriculum) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            Curriculum oldCurriculum = curriculumRepository.getCurriculumById(newCurriculum.getId());
            curriculumRepository.save(newCurriculum);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e);
        }

        return modelMap;
    }
    
    //  获得所需时间
    private Date getNeedTime(int hour, int minute, int second, int addDay, int... args) {
        Calendar calendar = Calendar.getInstance();
        if (addDay != 0) {
            calendar.add(Calendar.DATE, addDay);
        }
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        if (args.length == 1) {
            calendar.set(Calendar.MILLISECOND, args[0]);
        }
        return calendar.getTime();
    }


    @Override
    public List<Curriculum> getTommorrowCurriculumList() {
        Date tommorrowStart = getNeedTime(0,0,0,1);
        Date tommorrowEnd = getNeedTime(23,59,59,1);
        List<Curriculum> tommorrowCurriculunmList = curriculumRepository.getCurriculumByTimeBetween(tommorrowStart, tommorrowEnd);

        return tommorrowCurriculunmList;
    }

    @Override
    public List<Curriculum> getWarnedCurriculumList() {
        return curriculumRepository.getCurriculumByWarnTimeNotNull();
    }

    @Override
    public List<Curriculum> getNotWarnedCurriculumList() {
        return curriculumRepository.getCurriculumByWarnTimeNull();
    }

    @Override
    public Map<String,Object> getWarnList() {
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("warned", getWarnedCurriculumList());
        modelMap.put("notwarned", getNotWarnedCurriculumList());
        return modelMap;
    }


}
