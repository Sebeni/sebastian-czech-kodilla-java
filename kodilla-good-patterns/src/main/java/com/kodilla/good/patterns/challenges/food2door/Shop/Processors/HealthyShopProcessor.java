package com.kodilla.good.patterns.challenges.food2door.Shop.Processors;

import com.kodilla.good.patterns.challenges.food2door.Order;

import java.util.Map;

public class HealthyShopProcessor implements OrderProcessor {
    @Override
    public boolean process(Order orderToProcess) {
        System.out.println("HealthyShopProcessor");
        System.out.println("Healthy: " + orderToProcess.getName() + ", amount: " + orderToProcess.getAmount());
        return true;
    }
}
