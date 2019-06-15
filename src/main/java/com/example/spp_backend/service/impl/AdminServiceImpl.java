package com.example.spp_backend.service.impl;

import com.example.spp_backend.entity.Admin;
import com.example.spp_backend.repository.AdminRepository;
import com.example.spp_backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Map<String, Object> register(Admin admin) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Boolean exists = adminRepository.existsAdminByName(admin.getName());
        if (exists) {
            modelMap.put("success", false);
            modelMap.put("errmsg", "用户名已被占用。");
        } else {
            admin.setAuthority("ordinary");
            adminRepository.save(admin);
            modelMap.put("success", true);
        }

        return modelMap;
    }

    @Override
    public Map<String, Object> login(Admin admin) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Boolean right = adminRepository.existsAdminByNameAndPassword(admin.getName(), admin.getPassword());
        if (right) {
            Admin admin1 = adminRepository.findAdminByNameAndPassword(admin.getName(), admin.getPassword());
            modelMap.put("success", true);
            // 保存当前登录时间
            Timestamp now = new Timestamp(System.currentTimeMillis());
            admin1.setLastLoginTime(now);
            adminRepository.save(admin1);

            modelMap.put("admin", admin1);

            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errmsg", "用户名或密码错误。");
            return modelMap;
        }
    }

    @Override
    public Map<String, Object> modifyPassword(String name, String oldPassword, String newPassword) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Boolean right = adminRepository.existsAdminByNameAndPassword(name, oldPassword);
        if (right) {
            Admin admin = adminRepository.findAdminByNameAndPassword(name, oldPassword);
            admin.setPassword(newPassword);
            adminRepository.save(admin);
            modelMap.put("success", true);
            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errmsg", "原用户名或原密码错误。");
            return modelMap;
        }
    }

    @Override
    public Map<String, Object> getAdminList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            List<Admin> adminList = adminRepository.findAll();
            modelMap.put("success", true);
            modelMap.put("adminList", adminList);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", "查询管理员列表出错");
        }

        return modelMap;
    }

    @Override
    public Map<String, Object> addAdmin(Admin admin) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Boolean exists = adminRepository.existsAdminByName(admin.getName());
        if (exists) {
            modelMap.put("success", false);
            modelMap.put("errmsg", "当前用户名已占用");

        } else {
            adminRepository.save(admin);
            modelMap.put("success", true);
        }
        return modelMap;
    }

    @Override
    public Map<String, Object> deleteAdmin(Admin admin) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
//            Admin realadmin = adminRepository.getAdminByTitle(admin.getTitle());
            adminRepository.deleteById(admin.getId());
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e);
        }

        return modelMap;
    }

    @Override
    public Map<String, Object> updateAdmin(Admin newAdmin) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            adminRepository.save(newAdmin);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.toString());
        }

        return modelMap;
    }

}
