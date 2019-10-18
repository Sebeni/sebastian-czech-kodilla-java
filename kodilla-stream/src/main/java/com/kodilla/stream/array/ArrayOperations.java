package com.kodilla.stream.array;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {
    //Exercise 7.5
    static double getAverage(int[] numbers){
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);
        
        OptionalDouble result = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average();
        
        if(result.isPresent()){
            BigDecimal temp = new BigDecimal(result.getAsDouble());
            temp = temp.setScale(2, RoundingMode.HALF_UP);
            return temp.doubleValue();
        } else {
            return 0;
        }
    }
}
