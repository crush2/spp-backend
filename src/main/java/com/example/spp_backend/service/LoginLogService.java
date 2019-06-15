package com.example.spp_backend.service;

import com.example.spp_backend.entity.LoginLog;

import java.util.Map;

public interface LoginLogService {
    Map<String, Object> addLoginLog(LoginLog loginLog);

    Long getAllRegisterCount();

    Long getTodayRegisterCount();

    Long getAllLoginCount();

    Long getTodayLoginCount();
}
