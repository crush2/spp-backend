package com.example.spp_backend.repository;

import com.example.spp_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer>, JpaSpecificationExecutor {
    Boolean existsUserById(String id);
}
