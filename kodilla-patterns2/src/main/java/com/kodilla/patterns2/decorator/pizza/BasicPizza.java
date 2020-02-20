package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizza implements PizzaOrder {
    public static final String DESCRIPTION = "Pizza with sauce and cheese"; 
    
    @Override
    public BigDecimal calculatePrice() {
        return BigDecimal.valueOf(15.00);
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
