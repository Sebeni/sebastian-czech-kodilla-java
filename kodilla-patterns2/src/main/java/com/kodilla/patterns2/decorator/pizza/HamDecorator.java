package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HamDecorator extends AbstractPizzaOrderDecorator {
    public HamDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    public static final String DESCRIPTION = " + ham";



    @Override
    public BigDecimal calculatePrice() {
        return super.calculatePrice().add(BigDecimal.valueOf(3.00));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + DESCRIPTION;
    }
}
