package com.example.andriodproject;

public class LandmarkList {
    private String landmark_name;
    private String landmark_location;
    private String landmark_info;


    public String getLandmark_name() {
        return landmark_name;
    }
    public void setLandmark_name(String landmark_name){
        this.landmark_name = landmark_name;
    }

    public String getLandmark_location() {
        return landmark_location;
    }
    public void setLandmark_location(String landmark_location){
        this.landmark_location = landmark_location;
    }

    public String getLandmark_info() {
        return landmark_info;
    }
    public void setLandmark_info(String landmark_info){
        this.landmark_info = landmark_info;
    }

    public LandmarkList(String landmark_name, String landmark_location, String landmark_info){
        this.landmark_name = landmark_name;
        this.landmark_location = landmark_location;
        this.landmark_info = landmark_info;
    }
}

