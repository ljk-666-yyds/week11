package com.example.exercise11;

import java.util.List;
import java.util.function.Predicate;
public class TeamRepository extends Repository<Team> {
    public CustomIterator<Team> getIterator() {
        return new TeamIterator(getAll());
    }

    public List<Team> filterByLeague(String league) {
        Predicate<Team> tea=team -> team.getId().equalsIgnoreCase(league);
        return filter(tea);
    }
}

