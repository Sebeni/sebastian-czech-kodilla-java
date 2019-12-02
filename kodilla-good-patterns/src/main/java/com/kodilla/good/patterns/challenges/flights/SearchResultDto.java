package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class SearchResultDto {
    private PlaceName searchedPlaceName;
    private List<Flight> filteredFlights;
    private String direction;

    public SearchResultDto(PlaceName searchedPlaceName, List<Flight> filteredFlights, String direction) {
        this.searchedPlaceName = searchedPlaceName;
        this.filteredFlights = filteredFlights;
        this.direction = direction;
    }

    public PlaceName getSearchedPlaceName() {
        return searchedPlaceName;
    }

    public List<Flight> getFilteredFlights() {
        return filteredFlights;
    }

    public String getDirection() {
        return direction;
    }
}
