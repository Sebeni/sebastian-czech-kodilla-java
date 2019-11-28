package com.kodilla.good.patterns.challenges;

public class ProductInStockValidator implements InStockValidator {
    @Override
    public boolean itemInStock(Item item, int amount) {
        return ProductDatabase.getProductAmount(item) >= amount;
    }
}
