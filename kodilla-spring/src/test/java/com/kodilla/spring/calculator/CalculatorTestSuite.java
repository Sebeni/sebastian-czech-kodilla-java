package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CalculatorTestSuite {
    
    @Test
    public void testCalculations() {
        
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calc = context.getBean(Calculator.class);
        
        double sum = calc.add(4.6, 5.4);
        double sub = calc.sub(10, 5);
        double mul = calc.mul(3.5, 2);
        double div = calc.div(9, 4.5);

        Assert.assertEquals(10, sum, 0);
        Assert.assertEquals(5, sub, 0);
        Assert.assertEquals(7, mul, 0);
        Assert.assertEquals(2, div, 0);
    }
}
