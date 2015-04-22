package com.example.lovelyhearts.poker;

/**
 * Created by ryan on 4/21/15.
 */

import java.util.Date;

public class Tournament {
    private String date;
    private String time;
    private String location;
    private String week;

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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
}
