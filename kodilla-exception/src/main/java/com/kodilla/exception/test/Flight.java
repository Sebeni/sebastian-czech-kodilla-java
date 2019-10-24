package com.kodilla.exception.test;

public class Flight {
    private String departure;
    private String arrivalAirport;

    public Flight(String departure, String arrivalAirport) {
        this.departure = departure;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }
}
