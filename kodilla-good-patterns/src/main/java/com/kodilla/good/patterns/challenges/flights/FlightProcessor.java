package com.kodilla.good.patterns.challenges.flights;

public class FlightProcessor {
    static {
        new Flight(PlaceName.WARSZAWA, PlaceName.WROCŁAW);
        new Flight(PlaceName.WARSZAWA, PlaceName.POZNAŃ, PlaceName.WROCŁAW);
        new Flight(PlaceName.WROCŁAW, PlaceName.WARSZAWA);
        new Flight(PlaceName.SZCZECIN, PlaceName.WARSZAWA);
        new Flight(PlaceName.SZCZECIN, PlaceName.BYDGOSZCZ, PlaceName.BIAŁYSTOK);
        new Flight(PlaceName.BIAŁYSTOK, PlaceName.BYDGOSZCZ, PlaceName.SZCZECIN);
        new Flight(PlaceName.GDAŃSK, PlaceName.LUBLIN, PlaceName.KRAKÓW);
        new Flight(PlaceName.KRAKÓW, PlaceName.LUBLIN, PlaceName.GDAŃSK);
        new Flight(PlaceName.GDAŃSK, PlaceName.WROCŁAW);
        new Flight(PlaceName.SZCZECIN, PlaceName.POZNAŃ);
        new Flight(PlaceName.WROCŁAW, PlaceName.LUBLIN);
        new Flight(PlaceName.WROCŁAW, PlaceName.KRAKÓW, PlaceName.LUBLIN, PlaceName.BIAŁYSTOK);
        new Flight(PlaceName.GDAŃSK, PlaceName.SZCZECIN, PlaceName.POZNAŃ, PlaceName.BYDGOSZCZ);
        new Flight(PlaceName.BYDGOSZCZ, PlaceName.SZCZECIN);
    }
    
    
    private FlightSearcher searcher;
    private FlightDisplayer displayer;

    public FlightProcessor(FlightSearcher searcher, FlightDisplayer displayer) {
        this.searcher = searcher;
        this.displayer = displayer;
    }
    
    public void process(PlaceName placeNameToSearch) {
        displayer.display(searcher.findAllFlightsFrom(placeNameToSearch));
        System.out.println("***");
        displayer.display(searcher.findAllFlightsTo(placeNameToSearch));
        System.out.println("***");
        displayer.display(searcher.findAllFlightsThrough(placeNameToSearch));
        System.out.println("END OF RESULTS \n");
    }
}
