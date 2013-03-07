package com.palominolabs.staxmate.meat;

import java.util.ArrayList;
import java.util.List;

public final class Animal {

    private String name;

    private final List<Meat> meats = new ArrayList<>();

    public List<Meat> getMeats() {
        return meats;
    }

    public String getName() {

        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
