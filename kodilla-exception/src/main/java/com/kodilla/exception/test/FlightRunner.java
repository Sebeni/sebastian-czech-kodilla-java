package com.kodilla.exception.test;

public class FlightRunner {
    
    public static void main(String[] args) {
        Flight possible = new Flight("LAX", "JFK");
        Flight impossible = new Flight("JFK", "LAX");
        Flight exception = new Flight("Okęcie", "JFK");
        
        FlightSearch fs = new FlightSearch();
        
        try{
            fs.findFlight(possible);
            fs.findFlight(impossible);
            fs.findFlight(exception);
        } catch (RouteNotFoundException e){
            System.out.println(e + " If you see this message try again");
        } finally {
            System.out.println("Thank you!");
        }
    }
}
