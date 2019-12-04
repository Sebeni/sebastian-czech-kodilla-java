package com.kodilla.good.patterns.challenges.flights;

public class FlightProcessor {
    static {
        new Flight(PlaceName.WARSZAWA, PlaceName.WROCLAW);
        new Flight(PlaceName.WARSZAWA, PlaceName.POZNAN, PlaceName.WROCLAW);
        new Flight(PlaceName.WROCLAW, PlaceName.WARSZAWA);
        new Flight(PlaceName.SZCZECIN, PlaceName.WARSZAWA);
        new Flight(PlaceName.SZCZECIN, PlaceName.BYDGOSZCZ, PlaceName.BIALYSTOK);
        new Flight(PlaceName.BIALYSTOK, PlaceName.BYDGOSZCZ, PlaceName.SZCZECIN);
        new Flight(PlaceName.GDANS, PlaceName.LUBLIN, PlaceName.KRAKOW);
        new Flight(PlaceName.KRAKOW, PlaceName.LUBLIN, PlaceName.GDANS);
        new Flight(PlaceName.GDANS, PlaceName.WROCLAW);
        new Flight(PlaceName.SZCZECIN, PlaceName.POZNAN);
        new Flight(PlaceName.WROCLAW, PlaceName.LUBLIN);
        new Flight(PlaceName.WROCLAW, PlaceName.KRAKOW, PlaceName.LUBLIN, PlaceName.BIALYSTOK);
        new Flight(PlaceName.GDANS, PlaceName.SZCZECIN, PlaceName.POZNAN, PlaceName.BYDGOSZCZ);
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
