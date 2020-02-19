package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class BasicTaxiOrder implements TaxiOrder {

    public static final String DESCR = "Drive a course";

    @Override
    public BigDecimal getCost() {
        return BigDecimal.valueOf(5.00);
    }

    @Override
    public String getDescription() {
        return DESCR;
    }
}
