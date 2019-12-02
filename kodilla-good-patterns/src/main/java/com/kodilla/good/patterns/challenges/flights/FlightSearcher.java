package com.kodilla.good.patterns.challenges.flights;

import java.util.List;
import java.util.stream.Collectors;

public class FlightSearcher {

    public SearchResultDto findAllFlightsFrom(PlaceName fromWhere) {
        return new SearchResultDto(fromWhere, findAllFlights(fromWhere, Direction.FROM), Direction.FROM.toString());
    }

    public SearchResultDto findAllFlightsTo(PlaceName toWhere) {
        return new SearchResultDto(toWhere, findAllFlights(toWhere, Direction.TO), Direction.TO.toString());
    }
    
    public SearchResultDto findAllFlightsThrough(PlaceName throughWhere) {
        return new SearchResultDto(throughWhere, findAllFlights(throughWhere, Direction.THROUGH), Direction.THROUGH.toString());
    }


    private List<Flight> findAllFlights(PlaceName fromTo, Direction direction) {
        return PlacesDatabase.getAllPlaces().stream()
                .filter(place -> place.getName().equals(fromTo))
                .flatMap(place -> place.getFlights().stream())
                .filter(flight -> isPlaceInRightOrder(direction, flight, fromTo))
                .collect(Collectors.toList());
    }


    private boolean isPlaceInRightOrder(Direction direction, Flight flightToCheck, PlaceName searchedPlaceName) {
        String[] flights = flightToCheck.getName().split(" -> ");
        if (direction.equals(Direction.FROM)) {
            return flights[0].equals(searchedPlaceName.toString());
        } else if (direction.equals(Direction.TO)) {
            return  flights[flights.length - 1].equals(searchedPlaceName.toString());
        } else {
            return !flights[0].equals(searchedPlaceName.toString()) && !flights[flights.length - 1].equals(searchedPlaceName.toString());
        }
    }
    
    private enum Direction {
        FROM,
        TO,
        THROUGH
    }
}
