package com.example.exercise11;

public class Team implements SoccerEntity{
    private String name;
    private String country;
    private String league;
    private String stadium;
    private Integer year;
    public Team(String name,String country,String league,String stadium,int year){
        this.name=name;
        this.country=country;
        this.league=league;
        this.stadium=stadium;
        this.year=year;
    }
    public String getId(){
        return league;
    }
    public String getName(){
        return name;
    }
    public String getCountry(){
        return country;
    }
}
