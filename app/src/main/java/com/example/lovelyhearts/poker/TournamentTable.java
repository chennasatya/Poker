package com.example.lovelyhearts.poker;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by ryan on 4/21/15.
 */
@ParseClassName("TournamentTable")
public class TournamentTable extends ParseObject {

    private String TournamentId;   // Foreign key to the Tournament object
    private int TableId;
    private int NumberOfSeats;
    private boolean TableActive;   // Flag specifying that this table is active in the tournament
    private String Joined;
    private String Out;
    private String UserName;

    public void SetTableId(int id){ put("TableID", id);}
    public int GetTableId()
    {
        return getInt("TableID");
    }
    public void SetTournamentId(String id){put("TournamentId", id);}
    public String GetTournamentId(){
        return getString("TournamentId");
    }
    public void SetNumberOfSeats(int seats){
        put("NumberOfSeats", seats);
    }
    public int GetNumberOfSeats(){
        return getInt("TableID");
    }
    public void SetTableActive(boolean active){
        put("TableActive", active);
    }
    public boolean GetTableActive(){return getBoolean("TableActive");}
    public void SetJoined(String join){
        put("Joined", join);
    }
    public String GetJoined(){
        return getString("Joined");
    }
    public void SetOut(String active){
        put("Out", active);
    }
    public String GetOut(){
        return getString("Out");
    }
    public void SetUserName(String active){
        put("UserName", active);
    }
    public String GetUserName(){
        return getString("UserName");
    }
}
