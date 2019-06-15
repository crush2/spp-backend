package com.example.spp_backend.service;

import com.example.spp_backend.entity.Admin;

import java.util.Map;

public interface AdminService {
    //    Boolean checkExists(String name);
    Map<String, Object> register(Admin admin);

    Map<String, Object> login(Admin admin);

    Map<String, Object> modifyPassword(String name, String oldPassword, String newPassword);

    Map<String, Object> getAdminList();

    Map<String, Object> addAdmin(Admin admin);

    Map<String, Object> deleteAdmin(Admin admin);

    Map<String, Object> updateAdmin(Admin newAdmin);
}
