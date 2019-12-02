package com.kodilla.good.patterns.challenges.food2door.Shop.Processors;

import com.kodilla.good.patterns.challenges.food2door.Order;

import java.util.Map;

public interface OrderProcessor {
    boolean process(Order orderToProcess);
}
