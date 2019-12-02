package com.kodilla.good.patterns.challenges.food2door;

public class Application {
//    in order to add new Food Producer you only need to write proper processor and add its name to FoodProducersNames
    
    public static void main(String[] args) {
        Food2DoorProcessor processor = new Food2DoorProcessor(new InformationRetriever(), new OrderCompleter());
        processor.processOrder();
        processor.processOrder();
        processor.processOrder();
    }
}
