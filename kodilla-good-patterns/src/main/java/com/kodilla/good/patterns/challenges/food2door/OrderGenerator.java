package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OrderGenerator {
    private static Random rand = new Random();
    
    private static String[] foodList = {"Vegetables", "legumes", "beans", "fruit", "lean meats", "poultry", "fish", "eggs", 
            "tofu", "nuts", "seeds", "legumes", "beans", "grain", "mostly wholegrain or high cereal fibre varieties",
            "milk", "yogurt", "cheese"};
    
    
    public static Order createRandomOrder() {
        return new Order(foodList[rand.nextInt(foodList.length)], rand.nextDouble() * rand.nextInt(1000));
    }
    
}
