package com.kodilla.good.patterns.challenges.food2door.Shop.Processors;

import com.kodilla.good.patterns.challenges.food2door.Order;



public class GlutenFreeShopProcessor implements OrderProcessor {
    @Override
    public boolean process(Order orderToProcess) {
        System.out.println("GlutenFreeShopProcessor");
        System.out.println("Gluten Free: " + orderToProcess.getName() + ", amount: " + orderToProcess.getAmount());
        return true;
    }
}
