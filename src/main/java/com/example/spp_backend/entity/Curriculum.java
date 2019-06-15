package com.example.spp_backend.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "station_university_curriculum")
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长主键
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "teacher")
    private String teacher;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "picture")
    private String picture;

    @Column(name = "pictures")
    private String pictures;

    @Column(name = "information")
    private String information;

    @Column(name = "audio")
    private String audio;

    @Column(name = "video")
    private String video;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "teacher_email")
    private String teacherEmail;

    @Column(name = "warn_time")
    private Timestamp warnTime;

    public Curriculum() {
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public Timestamp getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(Timestamp warnTime) {
        this.warnTime = warnTime;
    }
}
