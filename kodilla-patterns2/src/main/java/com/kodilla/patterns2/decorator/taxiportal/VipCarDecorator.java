package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class VipCarDecorator extends AbstractTaxiOrderDecorator {
    public static final String DESCR = " variant VIP";
    
    protected VipCarDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(10.00));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + DESCR;
    }
}
