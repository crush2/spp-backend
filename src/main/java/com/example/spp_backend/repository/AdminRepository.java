package com.example.spp_backend.repository;

import com.example.spp_backend.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminRepository extends JpaRepository<Admin, Integer>, JpaSpecificationExecutor {
    Boolean existsAdminByName(String name);

    Boolean existsAdminByNameAndPassword(String name, String password);

    Admin findAdminByNameAndPassword(String name, String password);
}
