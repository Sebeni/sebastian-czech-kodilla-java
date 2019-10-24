package com.kodilla.exception.test;

public class FlightRunner {
    
    public static void main(String[] args) {
        Flight possible = new Flight("LAX", "JFK");
        Flight impossible = new Flight("JFK", "LAX");
        Flight exception = new Flight("Okęcie", "JFK");
        
        FlightSearch fs = new FlightSearch();
        
        try{
            System.out.println(fs.findFlight(possible));
            System.out.println(fs.findFlight(impossible));
            System.out.println(fs.findFlight(exception));
        } catch (RouteNotFoundException e){
            System.out.println(e + " If you see this message try again");
        } finally {
            System.out.println("Thank you!");
        }
    }
}
