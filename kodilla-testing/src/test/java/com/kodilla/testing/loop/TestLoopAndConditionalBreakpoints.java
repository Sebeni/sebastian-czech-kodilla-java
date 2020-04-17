package com.kodilla.testing.loop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLoopAndConditionalBreakpoints {
    
    @Test
    public void testLoop() {
        long sum = 0;

        for (int i = 0; i < 1000; i++) {
            sum += i;
            System.out.println(String.format("[%d] Sum equals %d", i, sum));
        }

        assertEquals(499500, sum);
    }
    
}
