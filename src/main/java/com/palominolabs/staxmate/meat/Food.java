package com.palominolabs.staxmate.meat;

import java.util.ArrayList;
import java.util.List;

public final class Food {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Vegetable> vegetables = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }
}
