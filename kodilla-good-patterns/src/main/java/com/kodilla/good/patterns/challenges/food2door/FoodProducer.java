package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.Shop.Processors.OrderProcessor;

import java.util.Map;
import java.util.Objects;

public class FoodProducer {
    private FoodProducersNames name;
    private OrderProcessor orderProcessor;

    public FoodProducer(FoodProducersNames name, OrderProcessor orderProcessor) {
        this.name = name;
        this.orderProcessor = orderProcessor;
    }

    public boolean process(Order orderToProcess) {
        return orderProcessor.process(orderToProcess);
    }

    public FoodProducersNames getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodProducer)) return false;
        FoodProducer that = (FoodProducer) o;
        return name.equals(that.name) &&
                orderProcessor.equals(that.orderProcessor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, orderProcessor);
    }
}
