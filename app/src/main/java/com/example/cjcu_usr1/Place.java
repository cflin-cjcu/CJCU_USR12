package com.example.cjcu_usr1;

import java.io.Serializable;

public class Place implements Serializable {
    String p_img;
    String Name;
    String Dist;


    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    String Info;

    public Place(String name, String latitude, String longitude, String info, String p_img) {
        this.p_img = p_img;
        Name = name;
        Info = info;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    String latitude;
    String longitude;

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

    public String getP_img() {
        return p_img;
    }

    public void setP_img(String p_img) {
        this.p_img = p_img;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDist() {
        return Dist;
    }

    public void setDist(String dist) {
        Dist = dist;
    }

    public Place() {
        this.p_img = "";
        Name = "";
        Dist = "";
    }


    public Place(String p_img, String name, String dist) {
        this.p_img = p_img;
        Name = name;
        Dist = dist;
    }


}
