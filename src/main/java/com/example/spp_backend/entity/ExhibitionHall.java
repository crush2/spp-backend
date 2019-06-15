package com.example.spp_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "alliance_exhibitionhall")
public class ExhibitionHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长主键
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "picture")
    private String picture;

    @Column(name = "pictures")
    private String pictures;

    @Column(name = "audio")
    private String audio;

    @Column(name = "video")
    private String video;

    @Column(name = "time")
    private String time;

    @Column(name = "parent_id")
    private String parentId;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
