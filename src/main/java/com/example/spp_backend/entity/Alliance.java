package com.example.spp_backend.entity;


import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "alliances")
public class Alliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长主键
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "picture")
    private String picture;

    @Column(name = "pictures")
    private String pictures;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "audio")
    private String audio;

    @Column(name = "video")
    private String video;

    @Column(name = "mode_transportation")
    private String modeTransportation;

    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    private String zip_code;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "links")
    private String links;

    @Column(name = "shape")
    private String shape;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "information")
    private String information;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private List<ExhibitionHall> exhibitionHalls;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private List<AllianceEvaluation> allianceEvaluations;


    public Alliance() {
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

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
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

    public String getModeTransportation() {
        return modeTransportation;
    }

    public void setModeTransportation(String modeTransportation) {
        this.modeTransportation = modeTransportation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public List<ExhibitionHall> getExhibitionHalls() {
        return exhibitionHalls;
    }

    public void setExhibitionHalls(List<ExhibitionHall> exhibitionHalls) {
        this.exhibitionHalls = exhibitionHalls;
    }

    public List<AllianceEvaluation> getAllianceEvaluations() {
        return allianceEvaluations;
    }

    public void setAllianceEvaluations(List<AllianceEvaluation> allianceEvaluations) {
        this.allianceEvaluations = allianceEvaluations;
    }
}
