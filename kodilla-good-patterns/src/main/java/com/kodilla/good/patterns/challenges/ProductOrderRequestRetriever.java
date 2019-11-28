package com.kodilla.good.patterns.challenges;

public class ProductOrderRequestRetriever {
    
    public ProductOrderRequest retrieve() {
        User user = new User("ABC", "WallSt");
        Item product = new Product("Banana", 3.80);
        return new ProductOrderRequest(product, 20, user);
    }
    
}
