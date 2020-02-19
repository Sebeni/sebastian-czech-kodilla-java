package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class ChildSeatDecorator extends AbstractTaxiOrderDecorator {
    public final static String DESCR = " + child seat";
    
    protected ChildSeatDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(2.00));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + DESCR;
    }
}
