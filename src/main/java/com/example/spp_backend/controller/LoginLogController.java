package com.example.spp_backend.controller;

import com.example.spp_backend.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginLogController {
    @Autowired
    LoginLogService loginLogService;

//    @PostMapping(path = "add/loginlog")
//    public Map<String,Object> addLoginLog(@RequestBody LoginLog loginLog){
//        return loginLogService.addLoginLog(loginLog);
//    }

    @GetMapping(path = "getcount/allregister")
    public Long getAllRegisterCount() {
        return loginLogService.getAllRegisterCount();
    }

    @GetMapping(path = "getcount/todayregister")
    public Long getTodayRegisterCount() {
        return loginLogService.getTodayRegisterCount();
    }

    @GetMapping(path = "getcount/alllogin")
    public Long getAllLoginCount() {
        return loginLogService.getAllLoginCount();
    }

    @GetMapping(path = "getcount/todaylogin")
    public Long getTodayLoginCount() {
        return loginLogService.getTodayLoginCount();
    }
}
