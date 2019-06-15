package com.example.spp_backend.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean(name = "dataSource")
    public DataSource datasource(Environment env) {
        HikariDataSource hds = new HikariDataSource();
        hds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        hds.setUsername(env.getProperty("spring.datasource.username"));
        hds.setPassword(env.getProperty("spring.datasource.password"));
        hds.setDriverClassName(env.getProperty("spring.datasource.driver"));

        return hds;
    }
}
