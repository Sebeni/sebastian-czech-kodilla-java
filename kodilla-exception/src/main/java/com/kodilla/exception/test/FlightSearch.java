package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    private static Map<String, Boolean> possibleFlights = new HashMap<>();
    static{
        possibleFlights.put("JFK", true);
        possibleFlights.put("LAX", false);
    }
    
    
    public void findFlight(Flight flight) throws RouteNotFoundException {
        if(possibleFlights.containsKey(flight.getDeparture()) && possibleFlights.containsKey(flight.getArrivalAirport())){
            printingMessages(flight);
        } else {
            throw new RouteNotFoundException("Route not find!");
        }
    }
    
    private void printingMessages(Flight flight){
        if(possibleFlights.get(flight.getArrivalAirport())){
            System.out.println("Route possible");
        } else {
            System.out.println("Route impossible");
        }
    }
}
