package com.example.exercise11;

import java.util.List;

public class TeamIterator implements CustomIterator<Team> {
    private List<Team> teams;
    private int index;
    public TeamIterator(List<Team> teams) {
        this.teams = teams;
        this.index = 0;
    }
    public boolean hasNext() {
        return index < teams.size();
    }
    public Team next() {
        if (hasNext()) {
            return teams.get(index++);
        }
        return null;
    }
}
