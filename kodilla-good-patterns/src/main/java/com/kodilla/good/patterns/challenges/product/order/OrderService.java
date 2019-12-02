package com.kodilla.good.patterns.challenges.product.order;

public interface OrderService {
    void placeOrder(Item orderedItem, User user, int amount);
}
