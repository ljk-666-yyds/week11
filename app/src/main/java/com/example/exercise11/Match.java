package com.example.exercise11;

public class Match implements SoccerEntity{
    private String homeTeam;
    private String awayTeam;
    private String score;
    private String league;
    private String date;
    private String stadium;
    public Match(String homeTeam,String awayTeam,String score,String league, String date, String stadium){
        this.homeTeam=homeTeam;
        this.awayTeam=awayTeam;
        this.score=score;
        this.league = league;
        this.date = date;
        this.stadium = stadium;
    }
    public String getId(){
        return homeTeam;
    }
    public String getName(){
        return awayTeam;
    }
    public String getHomeTeam(){
        return homeTeam;
    }
    public String getAwayTeam(){
        return awayTeam;
    }
    public String getScore(){
        return score;
    }
}
