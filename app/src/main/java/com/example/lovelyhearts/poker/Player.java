package com.example.lovelyhearts.poker;

/**
 * Created by ryan on 4/21/15.
 */
public class Player {
    private String playerId;
    private String playerName;
    private String overallRank;

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
