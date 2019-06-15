package com.example.spp_backend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "station_university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "picture")
    private String picture;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "audio")
    private String audio;

    @Column(name = "video")
    private String video;

    @Column(name = "address")
    private String address;

    @Column(name = "mode_transportation")
    private String modeTransportation;

    @Column(name = "shape")
    private String shape;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "parent_id")
    private Integer parentId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private List<Curriculum> curriculumList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private List<UniversityEvaluation> universityEvaluations;

    public University() {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getModeTransportation() {
        return modeTransportation;
    }

    public void setModeTransportation(String modeTransportation) {
        this.modeTransportation = modeTransportation;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Curriculum> getCurriculumList() {
        return curriculumList;
    }

    public void setCurriculumList(List<Curriculum> curriculumList) {
        this.curriculumList = curriculumList;
    }

    public List<UniversityEvaluation> getUniversityEvaluations() {
        return universityEvaluations;
    }

    public void setUniversityEvaluations(List<UniversityEvaluation> universityEvaluations) {
        this.universityEvaluations = universityEvaluations;
    }
}
