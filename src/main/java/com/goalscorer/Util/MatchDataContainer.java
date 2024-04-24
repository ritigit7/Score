package com.goalscorer.Util;

public class MatchDataContainer {
    private String playerName;
    private int runs;
    private int no;

    // Constructor
//    public MatchDataContainer(String playerName, int runs) {
//        this.playerName = playerName;
//        this.runs = runs;
//    }

    // Getter method for playerName
    public int getNo() {
        return no;
    }
    
    public void setNo(int no) {
        this.no = no;
    }
    public String getPlayerName() {
        return playerName;
    }
    // Setter method for playerName
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    // Getter method for runs
    public int getRuns() {
        return runs;
    }

    // Setter method for runs
    public void setRuns(int runs) {
        this.runs = runs;
    }

   
}
