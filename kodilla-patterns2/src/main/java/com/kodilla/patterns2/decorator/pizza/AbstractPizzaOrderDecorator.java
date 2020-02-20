package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AbstractPizzaOrderDecorator implements PizzaOrder {
    private final PizzaOrder pizzaOrder;
    
    @Override
    public BigDecimal calculatePrice() {
        return pizzaOrder.calculatePrice();
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }

    public AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }
}
