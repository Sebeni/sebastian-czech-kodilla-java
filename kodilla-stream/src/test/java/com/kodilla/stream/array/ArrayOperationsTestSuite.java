package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        int[] array = {1, 2, 3, 4, 5};
        
        double result = ArrayOperations.getAverage(array);
        
        Assert.assertEquals(3.0, result, 0);
        
    }
    
    @Test
    public void testGetAverageWithEmptyArray(){
        int[] array = {};
        
        double result = ArrayOperations.getAverage(array);
        
        Assert.assertEquals(0, result, 0);
    }
}
