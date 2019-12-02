package com.kodilla.good.patterns.challenges.food2door.Shop.Processors;

import com.kodilla.good.patterns.challenges.food2door.Order;

import java.util.Map;

public class ExtraFoodShopProcessor implements OrderProcessor {
    @Override
    public boolean process(Order orderToProcess) {
        System.out.println("ExtraFoodShopProcessor");
        System.out.println("Extra: " + orderToProcess.getName() + ", amount: " + orderToProcess.getAmount());
        return true;
    }
}
