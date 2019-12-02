package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.Shop.Processors.ExtraFoodShopProcessor;
import com.kodilla.good.patterns.challenges.food2door.Shop.Processors.GlutenFreeShopProcessor;
import com.kodilla.good.patterns.challenges.food2door.Shop.Processors.HealthyShopProcessor;

import java.util.*;

public class ProducersDatabase {
    private final static Set<FoodProducer> FOOD_PRODUCERS = new HashSet<>();
    static {
        FoodProducer gluten = new FoodProducer(FoodProducersNames.GLUTEN_FREE_SHOP, new GlutenFreeShopProcessor());
        FoodProducer extra = new FoodProducer(FoodProducersNames.EXTRA_FOOD_SHOP, new ExtraFoodShopProcessor());
        FoodProducer healthy = new FoodProducer(FoodProducersNames.HEALTHY_SHOP, new HealthyShopProcessor());
        ProducersDatabase.addProducers(gluten, extra, healthy);
    }
    
    
    public static void addProducers(FoodProducer ...producersToAdd){
        FOOD_PRODUCERS.addAll(Arrays.asList(producersToAdd));
    }

    public static Set<FoodProducer> getFoodProducers() {
        return FOOD_PRODUCERS;
    }

    public static FoodProducer getProducer(FoodProducersNames nameOfProducer){
        return FOOD_PRODUCERS.stream().filter(foodProducer -> foodProducer.getName().equals(nameOfProducer)).findAny().orElse(null);
    }
    
}
