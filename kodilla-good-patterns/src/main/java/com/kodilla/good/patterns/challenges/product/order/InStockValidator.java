package com.kodilla.good.patterns.challenges.product.order;

public interface InStockValidator {
    boolean itemInStock(Item item, int amount);
}
