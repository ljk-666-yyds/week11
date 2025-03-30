package com.example.exercise11;

import java.util.List;
import java.util.function.Predicate;

public class MatchRepository extends Repository<Match>{
    public CustomIterator<Match> getIterator() {
        return new MatchIterator(getAll());
    }
    public List<Match>filterByhomeTeam(String team){
        Predicate<Match> mat=match -> match.getHomeTeam().equalsIgnoreCase(team);
        return filter(mat);
    }
}
