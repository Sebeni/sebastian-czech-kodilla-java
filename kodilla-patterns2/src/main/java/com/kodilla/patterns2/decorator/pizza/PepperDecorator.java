package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PepperDecorator extends AbstractPizzaOrderDecorator {
    public PepperDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    public static final String DESCRIPTION = " + pepper";



    @Override
    public BigDecimal calculatePrice() {
        return super.calculatePrice().add(BigDecimal.valueOf(1.50));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + DESCRIPTION;
    }
}
