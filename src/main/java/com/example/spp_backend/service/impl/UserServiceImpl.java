package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.LoginLog;
import com.example.spp_backend.entity.User;
import com.example.spp_backend.repository.UserRepository;
import com.example.spp_backend.service.LoginLogService;
import com.example.spp_backend.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LoginLogService loginLogService;

    @Override
    public Map<String, Object> code2Session(String code) {
        String appid = "***";
        String secret = "***";
        String uri = "https://api.weixin.qq.com/sns/jscode2session?"
                + "appid=" + appid
                + "&secret=" + secret
                + "&js_code=" + code
                + "&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            modelMap = objectMapper.readValue(result, Map.class);
        } catch (Exception e) {
            modelMap.put("fail", true);
            modelMap.put("errmsg", e);
        }
        return modelMap;
    }

    @Override
    public Map<String, Object> login(User userInfo) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Map<String, Object> result = code2Session(userInfo.getCode());
        if (modelMap.containsKey("fail")) {
            // 获取session失败
            modelMap.put("code2sessionsuccess", false);
        } else {
            modelMap.put("code2sessionsuccess", true);

            String openId = result.get("openid").toString();
            Boolean exists = userRepository.existsUserById(openId);
            if (exists) {
                modelMap.put("success", true);

                // 更新登陆日志
                LoginLog loginLog = new LoginLog();
                loginLog.setLoginType("login");
                loginLogService.addLoginLog(loginLog);

                //TODO:返回用户相关信息，如收藏、设置等
                // modelMap.put...
            } else {
                //添加新用户到数据库
                try {
                    userInfo.setId(openId);
                    userRepository.save(userInfo);
                    modelMap.put("success", true);

                    // 更新登陆日志
                    LoginLog loginLog = new LoginLog();
                    loginLog.setLoginType("register");
                    loginLogService.addLoginLog(loginLog);
                } catch (Exception e) {
                    modelMap.put("success", false);
                    modelMap.put("errmsg", e.toString());
                }
            }
        }

        return modelMap;
    }
}
