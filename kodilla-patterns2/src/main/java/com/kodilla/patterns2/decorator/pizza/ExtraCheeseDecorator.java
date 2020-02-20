package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheeseDecorator extends AbstractPizzaOrderDecorator {
    public ExtraCheeseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    
    public static final String DESCRIPTION = " + extra cheese";

    
    
    @Override
    public BigDecimal calculatePrice() {
        return super.calculatePrice().add(BigDecimal.valueOf(2.00));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + DESCRIPTION;
    }
}
