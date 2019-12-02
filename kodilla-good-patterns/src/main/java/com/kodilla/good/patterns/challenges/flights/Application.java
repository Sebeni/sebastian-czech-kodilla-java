package com.kodilla.good.patterns.challenges.flights;

import java.util.EnumSet;

public class Application {
    public static void main(String[] args) {
        FlightProcessor fp = new FlightProcessor(new FlightSearcher(), new FlightDisplayer());

        EnumSet.allOf(PlaceName.class).forEach(fp::process);
        
    }
}
