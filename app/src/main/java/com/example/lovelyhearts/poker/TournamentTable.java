package com.example.lovelyhearts.poker;

import com.parse.ParseObject;

/**
 * Created by ryan on 4/21/15.
 */
public class TournamentTable extends ParseObject {

    private int TournamentId;   // Foreign key to the Tournament object
    private int TableId;
    private int NumberOfSeats;
    private boolean TableActive;   // Flag specifying that this table is active in the tournament


    public TournamentTable(){
        //Default Constructor
    }
    void SetTableId(int id)
    {
        this.TableId = id;
    }
    int GetTableId()
    {
        return this.TableId;
    }
    void SetTournamentId(int id){
        this.TournamentId = id;
    }
    int GetTournamentId(){
        return this.TournamentId;
    }
    void SetNumberOfSeats(int seats){
        this.NumberOfSeats = seats;
    }
    int GetNumberOfSeats(){
        return this.NumberOfSeats;
    }
    void SetTableActive(boolean active){
        this.TableActive = active;
    }
    boolean GetTableActive(){
        return this.TableActive;
    }
}
