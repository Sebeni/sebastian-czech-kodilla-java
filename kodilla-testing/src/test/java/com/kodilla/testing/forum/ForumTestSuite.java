package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.*;

public class ForumTestSuite {
    private static int count = 0;
    
    
    public ForumTestSuite(){
        count++;
        System.out.println("CONSTRUCTOR");
    }
    
    @Before
    public void before(){
        System.out.println("Before every test");
        System.out.println("Class no " + count);
    }
    
    @After
    public void after(){
        System.out.println("After every test");
    }
    
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before all tests (only one)");
    }
    
    @AfterClass
    public static void afterClass(){
        System.out.println("After all tests (only one)");
    }
    
    
    @Test
    public void testCaseUsername(){
        
        //Given
        SimpleUser simpleUser = new SimpleUser("Joe");
        //When
        String result = simpleUser.getUserName();
        System.out.println("result getUserName() " + result);
        //Then
        Assert.assertEquals("Joe", result);
    }
    
    @Test
    public void testCaseRealName(){
      
        SimpleUser simpleUser2 = new SimpleUser("Agent", "Smith" );
        
        String realName = simpleUser2.getRealName();
        System.out.println("result getRealName() " + realName);
        
        Assert.assertEquals("Smith", realName);
    }
    
}
