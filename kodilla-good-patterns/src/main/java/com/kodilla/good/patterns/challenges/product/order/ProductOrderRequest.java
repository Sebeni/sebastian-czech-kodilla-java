package com.kodilla.good.patterns.challenges.product.order;

public class ProductOrderRequest {
    private Item product;
    private int amount;
    private User user;


    public ProductOrderRequest(Item product, int amount, User user) {
        this.product = product;
        this.amount = amount;
        this.user = user;
    }

    public Item getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public User getUser() {
        return user;
    }
}
