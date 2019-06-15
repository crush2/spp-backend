package com.example.spp_backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column(insertable = true, columnDefinition = "varchar default 'ordinary'")
    private String authority;

    @Column(insertable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Timestamp regTime;

    @Column(insertable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Timestamp lastLoginTime;

    public Admin() {
    }


    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
