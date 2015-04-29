package com.example.lovelyhearts.poker;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by ryan on 4/21/15.
 */
public class Player extends ParseObject{
    private String playerId;
    private String playerName;
    private String overallRank;

    public void Player(){
        //Default constructor
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getOverallRank() {
        return overallRank;
    }

    public void setOverallRank(String overallRank) {
        this.overallRank = overallRank;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
