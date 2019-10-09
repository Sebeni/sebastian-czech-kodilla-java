package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        int sum = calc.add(5, 12);
        int diff = calc.substract(100, 65);
        
        if(sum == (5+12)){
            System.out.println("add correct");
        } else {
            System.out.println("add ERROR");
        }
        
        if(diff == (100-65)){
            System.out.println("diff correct");
        } else {
            System.out.println("diff ERROR");
        }
    }
}
