package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    private static Map<String, Boolean> possibleFlights = new HashMap<>();
    static{
        possibleFlights.put("JFK", true);
        possibleFlights.put("LAX", false);
    }
    
    
    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        if(possibleFlights.containsKey(flight.getDeparture()) && possibleFlights.containsKey(flight.getArrivalAirport())){
            return possibleFlights.get(flight.getArrivalAirport());
        } else {
            throw new RouteNotFoundException("Route not find!");
        }
    }
}
