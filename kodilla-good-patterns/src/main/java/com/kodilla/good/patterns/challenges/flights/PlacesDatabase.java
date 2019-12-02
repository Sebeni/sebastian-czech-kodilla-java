package com.kodilla.good.patterns.challenges.flights;

import java.util.*;

public class PlacesDatabase {
    private static final Set<Place> ALL_PLACES = new HashSet<>();
    static{
        EnumSet.allOf(PlaceName.class).forEach(destinationName -> ALL_PLACES.add(new Place(destinationName)));
    }

    public static Set<Place> getAllPlaces() {
        return ALL_PLACES;
    }
}
