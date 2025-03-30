package com.example.exercise11;

import java.util.List;

public class PlayerIterator implements CustomIterator<Player> {
    private List<Player> players;
    private int index;

    public PlayerIterator(List<Player> players) {
        this.players = players;
        this.index = 0;
    }

    public boolean hasNext() {
        return index < players.size();
    }

    public Player next() {
        if (hasNext()) {
            return players.get(index++);
        }
        return null;
    }
}

