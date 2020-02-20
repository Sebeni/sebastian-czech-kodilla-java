package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderTestSuite {

    @Test
    void calculatePriceAllToppings() {
        PizzaOrder order = new BasicPizza();
        order = new ExtraCheeseDecorator(order);
        order = new HamDecorator(order);
        order = new MushroomsDecorator(order);
        order = new PepperDecorator(order);


        assertEquals(BigDecimal.valueOf(24.00), order.calculatePrice());
    }

    @Test
    void getDescriptionAllToppings() {
        PizzaOrder order = new BasicPizza();
        order = new ExtraCheeseDecorator(order);
        order = new HamDecorator(order);
        order = new MushroomsDecorator(order);
        order = new PepperDecorator(order);

        System.out.println(order.getDescription());
        
        assertEquals(
                BasicPizza.DESCRIPTION
                        + ExtraCheeseDecorator.DESCRIPTION
                        + HamDecorator.DESCRIPTION
                        + MushroomsDecorator.DESCRIPTION
                        + PepperDecorator.DESCRIPTION,
                order.getDescription());
    }
}