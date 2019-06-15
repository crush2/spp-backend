package com.example.spp_backend.controller;

import com.example.spp_backend.entity.Admin;
import com.example.spp_backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    //好像有用。。 20190422-22：10
    @RequestMapping(path = {"/register/submit", "/login/submit"}, method = RequestMethod.OPTIONS)
    public String jumpOptions() {
        return "跳过啊";
    }


    @PostMapping(path = "/register/submit")
    public Map<String, Object> register(@RequestBody Admin admin) {
        return adminService.register(admin);
    }

    @PostMapping(path = "/login/submit")
    public Map<String, Object> login(@RequestBody Admin admin) {
        return adminService.login(admin);
    }

    @PostMapping(path = "/modifypassword/submit")
    public Map<String, Object> modifyPassword(@RequestParam(name = "name") String name,
                                              @RequestParam(name = "oldPassword") String oldPassword,
                                              @RequestParam(name = "newPassword") String newPassword) {
        return adminService.modifyPassword(name, oldPassword, newPassword);
    }

    @GetMapping(path = "/getlist/admin")
    public Map<String, Object> getAdminList() {
        return adminService.getAdminList();
    }

    @PostMapping(path = "/add/admin")
    public Map<String, Object> addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    @PostMapping(path = "/delete/admin")
    public Map<String, Object> deleteAdmin(@RequestBody Admin admin) {
        return adminService.deleteAdmin(admin);
    }

    @PostMapping(path = "/update/admin")
    public Map<String, Object> updateAdmin(@RequestBody Admin newAdmin) {
        return adminService.updateAdmin(newAdmin);
    }
}
