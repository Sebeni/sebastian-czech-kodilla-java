package com.kodilla.good.patterns.challenges;

public class DisplayProductInfo implements DisplayInfo {
    public void display(Item item){
        System.out.println("Product name: " + item.getName() + ", price: " + item.getPrice());
    }
}
