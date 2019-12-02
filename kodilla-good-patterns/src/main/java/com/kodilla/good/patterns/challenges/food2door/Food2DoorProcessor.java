package com.kodilla.good.patterns.challenges.food2door;

public class Food2DoorProcessor {
    private InformationRetriever informationRetriever;
    private OrderCompleter orderCompleter;

    public Food2DoorProcessor(InformationRetriever informationRetriever, OrderCompleter orderCompleter) {
        this.informationRetriever = informationRetriever;
        this.orderCompleter = orderCompleter;
    }

    public void processOrder(){
        InformationDto informationDto = informationRetriever.retrieveInformation();
        orderCompleter.completeOrder(informationDto);
        System.out.println("END");
    }
    
}
