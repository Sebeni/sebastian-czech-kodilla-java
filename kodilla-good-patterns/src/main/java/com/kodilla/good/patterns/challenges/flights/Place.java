package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Place {
    private List<Flight> flights = new ArrayList<>();
    private PlaceName name;

    public Place(PlaceName name) {
        this.name = name;
    }

    public PlaceName getName() {
        return name;
    }

    public void addToFlights(Flight flight) {
        flights.add(flight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;
        Place that = (Place) o;
        return name == that.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
