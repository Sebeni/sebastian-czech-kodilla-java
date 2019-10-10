package com.kodilla.testing.collection;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CollectionTestSuite {
    //Exercise 6.3
    private static ArrayList<Integer> emptyList = new ArrayList<>();
    private static ArrayList<Integer> normalList;
    private static OddNumbersExterminator testCase = new OddNumbersExterminator();
    
    @Rule
    public TestName name= new TestName();
 
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        Assert.assertEquals(0, testCase.exterminate(emptyList).size());
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        List<Integer> result = testCase.exterminate(normalList);
        
        Assert.assertFalse(result.contains(5) || result.contains(7));
        Assert.assertTrue(result.contains(2) && result.contains(4));
        Assert.assertEquals(2, result.size());
    }
    
    @BeforeClass
    public static void beforeClass(){
        Integer[] array = {2,5,7,4};
        normalList = new ArrayList<>(Arrays.asList(array));
    }
    
    @Before
    public void beforeTest(){
        System.out.println("Executing " + name.getMethodName());
    }
    
    @After
    public void afterTest(){
        System.out.println(name.getMethodName() + " has been completed");
    }
    
    @AfterClass
    public static void afterClass(){
        System.out.println("All tests finished");
    }
    
}
