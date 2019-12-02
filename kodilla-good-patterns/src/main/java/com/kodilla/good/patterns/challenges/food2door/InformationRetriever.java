package com.kodilla.good.patterns.challenges.food2door;

public class InformationRetriever {
    private static int counter = 0;
    
    
    public InformationDto retrieveInformation(){
        counter ++;
        Order orderToProcess = OrderGenerator.createRandomOrder();
        
        switch (counter){
            case 1:
                return new InformationDto(orderToProcess, ProducersDatabase.getProducer(FoodProducersNames.EXTRA_FOOD_SHOP));
            case 2:
                return new InformationDto(orderToProcess, ProducersDatabase.getProducer(FoodProducersNames.GLUTEN_FREE_SHOP));
            default:
                return new InformationDto(orderToProcess, ProducersDatabase.getProducer(FoodProducersNames.HEALTHY_SHOP));
        }
        
        
    }
    
    
}
