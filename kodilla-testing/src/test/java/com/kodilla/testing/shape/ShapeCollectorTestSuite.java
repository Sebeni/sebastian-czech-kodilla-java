package com.kodilla.testing.shape;

import org.junit.*;
import org.junit.rules.TestName;

public class ShapeCollectorTestSuite {
    private static Square square = new Square(2.0);
    private static Triangle triangle = new Triangle(2.0, 2.0);
    private static Circle circle = new Circle(2.0);
    private ShapeCollector sc = new ShapeCollector();
    
    @Test
    public void testAddFigure(){
        sc.addFigure(square);
        
        Assert.assertEquals(1, sc.getShapeList().size());
        Assert.assertEquals(new Square(2.0), sc.getShapeList().get(0));
    }
    
    @Test
    public void testRemoveNonexistentFigure(){
        String message = sc.removeFigure(square);
        
        Assert.assertEquals("There is no such figure in shape list", message);
    }
    
    @Test
    public void testRemoveExistingFigure(){
        sc.addFigure(square);
        String message = sc.removeFigure(square);

        Assert.assertEquals("Figure removed", message);
        Assert.assertEquals(0, sc.getShapeList().size());
    }
    
    @Test
    public void testGetFigure(){
        sc.addFigure(square);
        
        Shape shape = sc.getFigure(0);
        
        Assert.assertEquals(new Square(2.0), shape);
    }
    
    @Test
    public void testGetFigureIndexOutOfBound(){
        sc.addFigure(square);
        
        Shape shape = sc.getFigure(100);
        
        //when out of bound return null shape
        Assert.assertNull(shape);
    }
    
    @Test
    public void testGetFigureNegativeIndex(){
        sc.addFigure(square);

        Shape shape = sc.getFigure(-100);

        //when negative index return null shape
        Assert.assertNull(shape);
    }
    
    
    @Test
    public void testShowFigures(){
        sc.addFigure(square);
        sc.addFigure(triangle);
        sc.addFigure(circle);
        
        String expectedResult = "square 4.0 triangle 2.0 circle 12.56 ";
        Assert.assertEquals(expectedResult, sc.showFigures());
    }
    
    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("Starting tests");
    }
    
    @AfterClass
    public static void afterAllTest(){
        System.out.println("All test has been finished");
    }

    @Rule
    public TestName name = new TestName();

    @Before
    public void beforeTest(){
        System.out.println("Executing " + name.getMethodName());
    }

    @After
    public void afterTest(){
        System.out.println(name.getMethodName() + " has been completed");
    }
    
}
