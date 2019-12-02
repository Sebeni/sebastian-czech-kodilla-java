package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;

public class InformationDto {
    private Order order;
    private FoodProducer foodProducer;

    public InformationDto(Order order, FoodProducer foodProducer) {
        this.order = order;
        this.foodProducer = foodProducer;
    }

    public Order getOrder() {
        return order;
    }

    public FoodProducer getFoodProducer() {
        return foodProducer;
    }
}
