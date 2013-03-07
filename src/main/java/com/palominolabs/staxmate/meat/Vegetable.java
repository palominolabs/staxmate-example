package com.palominolabs.staxmate.meat;

import java.util.ArrayList;
import java.util.List;

final class Vegetable {
    private String name;
    private final List<String> preparations = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<String> getPreparations() {
        return preparations;
    }

    void setName(String name) {
        this.name = name;
    }
}
