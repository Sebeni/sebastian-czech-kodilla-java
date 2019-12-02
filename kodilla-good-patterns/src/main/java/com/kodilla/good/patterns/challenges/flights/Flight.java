package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private List<PlaceName> passingPlaceNames = new ArrayList<>();
    private String name;

    public Flight(PlaceName... placeNames) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < placeNames.length; i++) {
            PlaceName current = placeNames[i];

            if (i < placeNames.length - 1) {
                sb.append(current + " -> ");
            } else {
                sb.append(current);
            }
            passingPlaceNames.add(current);

        }
        name = sb.toString();
        addFlightsToPlace();
    }
    

    @Override
    public String toString() {
        return "Flight{" +
                "name='" + name + '\'' +
                '}';
    }
    
    private void addFlightsToPlace() {
        for(PlaceName current : passingPlaceNames){
            Place toAdd = PlacesDatabase.getAllPlaces().stream()
                    .filter(place -> place.getName().equals(current))
                    .findAny()
                    .orElse(null);

            if(toAdd != null){
                toAdd.addToFlights(this);
            }
        }
    }

    public String getName() {
        return name;
    }
}
