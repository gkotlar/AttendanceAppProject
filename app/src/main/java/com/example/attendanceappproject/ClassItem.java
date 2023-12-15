package com.example.attendanceappproject;

import com.google.type.DateTime;

import java.sql.Timestamp;
import java.util.Date;

public class ClassItem {
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public ClassItem(String time, String location, String className, String about) {
        this.time = time;
        this.location = location;
        ClassName = className;
        About = about;
    }

    private String location;
    private String ClassName;
    private String About;

}
