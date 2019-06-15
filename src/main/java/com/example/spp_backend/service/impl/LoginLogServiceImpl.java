package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.LoginLog;
import com.example.spp_backend.repository.LoginLogRepository;
import com.example.spp_backend.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    LoginLogRepository loginLogRepository;

    @Override
    public Map<String, Object> addLoginLog(LoginLog loginLog) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        try {
            loginLogRepository.save(loginLog);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.toString());
        }
        return modelMap;
    }

    @Override
    public Long getAllRegisterCount() {
        return loginLogRepository.countByLoginTypeEquals("register");
    }

    @Override
    public Long getTodayRegisterCount() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date today = calendar.getTime();
        return loginLogRepository.countByLoginTimeIsAfterAndLoginTypeEquals(today, "register");
    }

    @Override
    public Long getAllLoginCount() {
        return loginLogRepository.count();
    }

    @Override
    public Long getTodayLoginCount() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date today = calendar.getTime();
        return loginLogRepository.countByLoginTimeIsAfter(today);
    }
}
