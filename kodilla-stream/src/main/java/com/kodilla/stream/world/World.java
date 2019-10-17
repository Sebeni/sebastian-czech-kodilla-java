package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class World {
    private final List<Continent> continents = new ArrayList<>();

    public void addCountry(Continent... continent){
        continents.addAll(Arrays.asList(continent));
    }

    public List<Continent> getContinents() {
        return continents;
    }
}
