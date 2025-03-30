package com.example.exercise11;

public class Player implements SoccerEntity{
    private String name;
    private Integer age;
    private String country;
    private String position;
    private String team;
    private Integer number;
    public Player(String name,Integer age,String country,String position,String team,Integer number){
        this.name=name;
        this.age=age;
        this.country=country;
        this.position=position;
        this.team=team;
        this.number=number;
    }
    public String getId(){
        return team;
    }
    public String getName(){
        return name;
    }
    public String getTeam(){
        return team;
    }
}
