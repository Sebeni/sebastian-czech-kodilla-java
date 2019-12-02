package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class FlightDisplayer {
    
    public void display(SearchResultDto searchResult) {
        System.out.println(String.format("All flights %s %s", searchResult.getDirection(), searchResult.getSearchedPlaceName()));
        if(searchResult.getFilteredFlights().isEmpty()){
            System.out.println("NONE");
        } else {
            searchResult.getFilteredFlights().forEach(System.out::println);
        }
    }
    
}
