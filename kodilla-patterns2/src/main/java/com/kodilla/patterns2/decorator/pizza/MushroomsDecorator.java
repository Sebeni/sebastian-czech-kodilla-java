package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MushroomsDecorator extends AbstractPizzaOrderDecorator {
    public MushroomsDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    public static final String DESCRIPTION = " + mushrooms";



    @Override
    public BigDecimal calculatePrice() {
        return super.calculatePrice().add(BigDecimal.valueOf(2.50));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + DESCRIPTION;
    }
}
