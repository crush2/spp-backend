package com.example.spp_backend.controller;

import com.example.spp_backend.entity.User;
import com.example.spp_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/user/login")
    public Map<String, Object> login(@RequestBody User userInfo) {
        return userService.login(userInfo);
    }
}
