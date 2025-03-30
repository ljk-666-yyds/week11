package com.example.exercise11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class Repository<T> {
    public List<T> items = new ArrayList<>();

    public List<T> getAll() {
        return items;
    }
    public void clear() {
        items.clear();
    }
    public void add(T item) {
        items.add(item);
    }
    public abstract CustomIterator<T> getIterator();

    public List<T> filter(Predicate<T> predicate) {
        CustomIterator<T> iterator = getIterator();
        List<T> filteredItems = new ArrayList<>();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (predicate.test(item)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }
}


