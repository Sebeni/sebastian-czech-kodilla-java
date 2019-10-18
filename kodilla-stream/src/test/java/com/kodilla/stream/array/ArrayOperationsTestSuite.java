package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //3.83
        int[] arrayRoundDown = {1, 2, 3, 4, 5, 8};
        
        //one element
        int[] arrayOneElement = {5};
        
        //5.67
        int[] arrayRoundUp = {11, 4, 2};
        
        double resultRoundDown = ArrayOperations.getAverage(arrayRoundDown);
        double resultOneElement = ArrayOperations.getAverage(arrayOneElement);
        double resultRoundUp = ArrayOperations.getAverage(arrayRoundUp);
        
        Assert.assertEquals(3.83, resultRoundDown, 0);
        Assert.assertEquals(5.00, resultOneElement, 0);
        Assert.assertEquals(5.67, resultRoundUp, 0);
    }
    
    @Test
    public void testGetAverageWithEmptyArray(){
        int[] array = {};
        
        double result = ArrayOperations.getAverage(array);
        
        Assert.assertEquals(0, result, 0);
    }
}
