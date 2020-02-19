package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaxiOrderTestSuite {

    @Test
    void testBasicTaxiOrderGetCost() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        
        BigDecimal calculatedCost = theOrder.getCost();
        
        assertEquals(BigDecimal.valueOf(5.00), calculatedCost);
        
    }

    @Test
    void testGetDescription() {
        TaxiOrder theOrder = new BasicTaxiOrder();

        String description = theOrder.getDescription();

        assertEquals("Drive a course", description);
    }
    
    @Test
    void testTaxiNetworkGetCost() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);


        BigDecimal calculatedCost = theOrder.getCost();

        assertEquals(BigDecimal.valueOf(40.00), calculatedCost);
        
    }

    @Test
    void testTaxiNetworkGetDescription() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        String description = theOrder.getDescription();

        assertEquals("Drive a course by Taxi Network", description);
    }
    
   @Test
    void testMyTaxiWithChildSeatGetCost() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        
        BigDecimal theCost = theOrder.getCost();
        
        assertEquals(BigDecimal.valueOf(37.00), theCost);
   }

    @Test
    void testMyTaxiWithChildSeatGetDescription() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        String description = theOrder.getDescription();

        assertEquals(BasicTaxiOrder.DESCR + MyTaxiNetworkOrderDecorator.DESCR + ChildSeatDecorator.DESCR, description);
    }

    @Test
    void testUberWithTwoChildSeatGetCost() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        BigDecimal theCost = theOrder.getCost();

        assertEquals(BigDecimal.valueOf(29.00), theCost);
    }

    @Test
    void testUberWithTwoChildSeatGetDescription() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        String description = theOrder.getDescription();

        assertEquals(BasicTaxiOrder.DESCR + UberNetworkOrderDecorator.DESCR + ChildSeatDecorator.DESCR + ChildSeatDecorator.DESCR, description);
    }
    
    @Test
    void testVipTaxiWithChildSeatExpressGetCost() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        
        BigDecimal theCost = theOrder.getCost();
        System.out.println(theCost);
        
        assertEquals(BigDecimal.valueOf(52.00), theCost);
    }
    
    
    
    @Test
    void testVipTaxiWithChildSeatExpressGetDescription() {
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        String description = theOrder.getDescription();
        System.out.println(description);

        assertEquals(BasicTaxiOrder.DESCR + TaxiNetworkOrderDecorator.DESCR + VipCarDecorator.DESCR + ChildSeatDecorator.DESCR, description);
    }
   
}