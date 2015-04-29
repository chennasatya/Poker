package com.example.lovelyhearts.poker;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by ryan on 4/21/15.
 */
@ParseClassName("TournamentTable")
public class TournamentTable extends ParseObject {

    private int TournamentId;   // Foreign key to the Tournament object
    private int TableId;
    private int NumberOfSeats;
    private boolean TableActive;   // Flag specifying that this table is active in the tournament


    public void TournamentTable(){
        //Default Constructor
    }
    public void SetTableId(int id)
    {
        this.TableId = id;
    }
    public int GetTableId()
    {
        return this.TableId;
    }
    public void SetTournamentId(int id){
        this.TournamentId = id;
    }
    public int GetTournamentId(){
        return this.TournamentId;
    }
    public void SetNumberOfSeats(int seats){
        this.NumberOfSeats = seats;
    }
    public int GetNumberOfSeats(){
        return this.NumberOfSeats;
    }
    public void SetTableActive(boolean active){
        this.TableActive = active;
    }
    public boolean GetTableActive(){
        return this.TableActive;
    }
}
