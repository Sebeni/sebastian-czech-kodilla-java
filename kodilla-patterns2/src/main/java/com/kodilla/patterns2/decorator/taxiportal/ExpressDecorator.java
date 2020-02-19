package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class ExpressDecorator extends AbstractTaxiOrderDecorator {
    public static final String DESCR = " express service";
    
    protected ExpressDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(5.00));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + DESCR;
    }
}
