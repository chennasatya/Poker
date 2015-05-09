package com.example.lovelyhearts.poker;

/**
 * Created by ryan on 4/21/15.
 */

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Date;
import java.util.UUID;

@ParseClassName("Tournament")
public class Tournament extends ParseObject {

    public String getWeek() {
        return getString("week");
    }
    public void setWeek(String value) {
        put("week", value);
    }

    public String getDate() {
        return getString("date");
    }
    public void setDate(String value) {
        put("date",value);
    }

    public String getTime() {
        return getString("time");
    }
    public void setTime(String value) {
        put("time",value);
    }

    public String getMaxPlayers() {
        return getString("maxPlayers");
    }
    public void setMaxPlayers(int value) {
        put("maxPlayers",value);
    }


    public String getLocation() {
        return getString("location");
    }
    public void setLocation(String value) {
        put("location",value);
    }


    public int getBuyIn() {
        return getInt("buyIn");
    }
    public void setBuyIn(int value) {
        put("buyIn", value);
    }


    public String getName() {
        return getString("name");
    }
    public void setName(String value) {
        put("name", value);
    }

    public String getObjectId() {
        return getString("ObjectId");
    }

    public int getSeats() { return getInt("seats");}
    public void setSeats(int value) { put("seats",value);}

    public int getTableNo() { return getInt("tableNo");}
    public void setTableNo(int value) { put("tableNo",value);}

    public void setUuidString() {
        UUID uuid = UUID.randomUUID();
        put("uuid", uuid.toString());
    }

    public String getUuidString() {
        return getString("uuid");
    }

    public static ParseQuery<Tournament> getQuery() {
        return ParseQuery.getQuery(Tournament.class);
    }
}
