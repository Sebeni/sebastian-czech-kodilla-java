package com.kodilla.testing.collection;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Random;

public class CollectionTestSuite {
    private static Random random = new Random();
    private static ArrayList<Integer> emptyList = new ArrayList<>();
    private static ArrayList<Integer> normalList = new ArrayList<>();
    private static OddNumbersExterminator testCase = new OddNumbersExterminator();

    @Rule
    public TestName name= new TestName();
 
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        Assert.assertEquals(0, testCase.exterminate(emptyList).size());
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        boolean allEvenExterminated = true;
        for(Integer i : testCase.exterminate(normalList)){
            if(i%2 != 0){
                allEvenExterminated = false;
                break;
            }
        }
        Assert.assertTrue(allEvenExterminated);
    }
    
    @BeforeClass
    public static void beforeClass(){
        for(int i = 0; i < 10; i++){
            int randomNum = random.nextInt(1000);
            normalList.add(randomNum);
            normalList.add(randomNum + 1);
        }
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
