package com.example.spp_backend.service;

import com.example.spp_backend.entity.User;

import java.util.Map;

public interface UserService {
    Map<String, Object> code2Session(String code);

    Map<String, Object> login(User userInfo);
}
