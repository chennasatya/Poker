package com.example.lovelyhearts.poker;

/**
 * Created by ryan on 4/21/15.
 */

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

@ParseClassName("Tournament")
public class Tournament /*extends ParseObject*/ {
    private String date;
    private String time;
    private String location;
    private String week;
    private String maxPlayers;
    private int position;

    public String getMaxPlayers() { return maxPlayers;}

    public void setMaxPlayers(int position) { this.maxPlayers = maxPlayers;}

    public int getPosition() { return position;
    }

    public void setPosition(int position) { this.position = position;
    }




    public Tournament(){
        //Default Constructor
    }

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

    private int buyIn;
    public int getBuyIn() {  return buyIn;}

    public void setBuyIn(int buyIn) {this.buyIn = buyIn;}
}
