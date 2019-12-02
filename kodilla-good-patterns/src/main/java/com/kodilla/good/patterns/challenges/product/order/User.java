package com.kodilla.good.patterns.challenges.product.order;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String address;
    private List<Item> productHistory = new ArrayList<>();

    public User(String userName, String address) {
        this.userName = userName;
        this.address = address;
    }

    public void addOrder(Item addItemToHistory) {
        productHistory.add(addItemToHistory);
    }

}
