package com.example.exercise11;

import java.util.List;

public class MatchIterator implements CustomIterator<Match> {
    private List<Match> match;
    private int index;

    public MatchIterator(List<Match> match) {
        this.match = match;
        this.index = 0;
    }

    public boolean hasNext() {
        return index < match.size();
    }

    public Match next() {
        if (hasNext()) {
            return match.get(index++);
        }
        return null;
    }
}
