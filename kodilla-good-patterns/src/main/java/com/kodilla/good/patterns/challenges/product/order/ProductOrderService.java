package com.kodilla.good.patterns.challenges.product.order;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {
    
    public void placeOrder(Item orderedItem, User user, int amount){
        ProductDatabase.removeProduct(orderedItem, amount);
        OrderDatabase.addOrder(orderedItem, amount, user, LocalDateTime.now());
        user.addOrder(orderedItem);
    }
    
}
