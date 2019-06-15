package com.example.spp_backend.repository;

import com.example.spp_backend.entity.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface LoginLogRepository extends JpaRepository<LoginLog, Integer>, CrudRepository<LoginLog, Integer>, JpaSpecificationExecutor {
    Long countByLoginTimeIsAfter(Date today);

    Long countByLoginTimeIsAfterAndLoginTypeEquals(Date today, String loginType);

    Long countByLoginTypeEquals(String loginType);

}
