package com.kodilla.good.patterns.challenges.food2door;
import java.util.Map;


public class OrderCompleter {
    
    public void completeOrder(InformationDto informationDto) {
       Order order = informationDto.getOrder();
        
        FoodProducer current = ProducersDatabase.getProducer(informationDto.getFoodProducer().getName());
        if(current.process(order)){
            System.out.println(order + " in: " + current.getName() + " completed");
        } else {
            System.out.println(order + " in: " + current.getName() + " failed");
        }
    }
    
}
