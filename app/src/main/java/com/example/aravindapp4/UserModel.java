package com.example.aravindapp4;

public class UserModel {

    String name,mobile,whatsapp,web;
    double lat,lng;
    int image;

    public UserModel(String name, String mobile, String whatsapp, String web, double lat, double lng) {
        this.name = name;
        this.mobile = mobile;
        this.whatsapp = whatsapp;
        this.web = web;
        this.lat = lat;
        this.lng = lng;
    }

    public UserModel(String name, String mobile, String whatsapp, String web, double lat, double lng, int image) {
        this.name = name;
        this.mobile = mobile;
        this.whatsapp = whatsapp;
        this.web = web;
        this.lat = lat;
        this.lng = lng;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
