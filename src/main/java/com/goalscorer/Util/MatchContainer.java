package com.goalscorer.Util;

public class MatchContainer {
    private String date;
    private String team1;
    private String team2;
    private int firstInningsScore;
    private int firstInningsWickets;
    private int secondInningsScore;
    private int secondInningsWickets;
    private String matchWinner;
    private String wonBy;
    private String margin;

    // Getter and Setter methods for date
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Getter and Setter methods for team1
    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    // Getter and Setter methods for team2
    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    // Getter and Setter methods for firstInningsScore
    public int getFirstInningsScore() {
        return firstInningsScore;
    }

    public void setFirstInningsScore(int firstInningsScore) {
        this.firstInningsScore = firstInningsScore;
    }

    // Getter and Setter methods for firstInningsWickets
    public int getFirstInningsWickets() {
        return firstInningsWickets;
    }

    public void setFirstInningsWickets(int firstInningsWickets) {
        this.firstInningsWickets = firstInningsWickets;
    }

    // Getter and Setter methods for secondInningsScore
    public int getSecondInningsScore() {
        return secondInningsScore;
    }

    public void setSecondInningsScore(int secondInningsScore) {
        this.secondInningsScore = secondInningsScore;
    }

    // Getter and Setter methods for secondInningsWickets
    public int getSecondInningsWickets() {
        return secondInningsWickets;
    }

    public void setSecondInningsWickets(int secondInningsWickets) {
        this.secondInningsWickets = secondInningsWickets;
    }

    // Getter and Setter methods for matchWinner
    public String getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    // Getter and Setter methods for wonBy
    public String getWonBy() {
        return wonBy;
    }

    public void setWonBy(String wonBy) {
        this.wonBy = wonBy;
    }

    // Getter and Setter methods for margin
    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }
}
