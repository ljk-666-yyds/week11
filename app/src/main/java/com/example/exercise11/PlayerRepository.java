package com.example.exercise11;

import java.util.List;
import java.util.function.Predicate;

public class PlayerRepository extends Repository<Player>{
    public CustomIterator<Player> getIterator() {
        return new PlayerIterator(getAll());
    }
    public List<Player> filterByTeam(String team){
        Predicate <Player> play=player -> player.getTeam().equalsIgnoreCase(team);
        return filter(play);
    }
}
