package com.kodilla.good.patterns.challenges.food2door;

public class Order {
    private String name;
    private double amount;

    public Order(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
