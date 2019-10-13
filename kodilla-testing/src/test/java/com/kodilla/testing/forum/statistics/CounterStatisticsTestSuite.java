package com.kodilla.testing.forum.statistics;

import org.junit.*;
import org.junit.rules.TestName;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class CounterStatisticsTestSuite {
    //exercise 6.5
    private static Counter counter = new Counter();
    private static Statistics mockStat = Mockito.mock(Statistics.class);

    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting tests");
    }

    @Before
    public void beforeTest() {
        System.out.println("Executing " + name.getMethodName());
    }

    @After
    public void afterTest() {
        System.out.println(name.getMethodName() + " has been completed");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("All tests has been completed");
    }

    //gdy liczba postów = 0,
    @Test
    public void testPostCount0() {
        Mockito.when(mockStat.postsCount()).thenReturn(0);

        counter.calculateAdvStatistics(mockStat);

        counter.showStatistics();

        Assert.assertEquals(0, counter.getPostCount());
        Assert.assertEquals(0, counter.getAvgCommentNumPerPost(), 0);
        Assert.assertEquals(0, counter.getAvgPostNumPerUser(), 0);
    }

    //gdy liczba postów = 1000,
    @Test
    public void testCommentCount1000() {
        List<String> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add("User#" + i);
        }
        
        Mockito.when(mockStat.postsCount()).thenReturn(50);
        Mockito.when(mockStat.commentsCount()).thenReturn(1000);
        Mockito.when(mockStat.usersNames()).thenReturn(list);

        counter.calculateAdvStatistics(mockStat);

        counter.showStatistics();
        Assert.assertEquals(1000, counter.getCommentCount());
        Assert.assertEquals(5, counter.getAvgPostNumPerUser(), 0);
        Assert.assertEquals(100, counter.getAvgCommentNumPerUser(), 0);
        Assert.assertEquals(20, counter.getAvgCommentNumPerPost(), 0);
    }

    //gdy liczba komentarzy = 0,
    @Test
    public void testCommentCount0() {
        Mockito.when(mockStat.commentsCount()).thenReturn(0);

        counter.calculateAdvStatistics(mockStat);

        counter.showStatistics();
        Assert.assertEquals(0, counter.getCommentCount(), 0);
        Assert.assertEquals(0, counter.getAvgCommentNumPerPost(), 0);
        Assert.assertEquals(0, counter.getAvgCommentNumPerUser(), 0);
    }

    //gdy liczba komentarzy < liczba postów,
    @Test
    public void testCommentCountLessThanPostCount() {
        Mockito.when(mockStat.postsCount()).thenReturn(1000);
        Mockito.when(mockStat.commentsCount()).thenReturn(100);

        counter.calculateAdvStatistics(mockStat);
        counter.showStatistics();

        Assert.assertTrue(counter.getCommentCount() < counter.getPostCount());
    }

    //gdy liczba komentarzy > liczba postów,
    @Test
    public void testCommentCountMoreThanPostCount() {
        Mockito.when(mockStat.postsCount()).thenReturn(100);
        Mockito.when(mockStat.commentsCount()).thenReturn(1000);

        counter.calculateAdvStatistics(mockStat);
        counter.showStatistics();

        Assert.assertTrue(counter.getCommentCount() > counter.getPostCount());
    }

    //gdy liczba użytkowników = 0,
    @Test
    public void testUserCount0() {
        Mockito.when(mockStat.usersNames()).thenReturn(new ArrayList<>());

        counter.calculateAdvStatistics(mockStat);
        counter.showStatistics();

        Assert.assertEquals(0, counter.getUserCount());
        Assert.assertEquals(0, counter.getAvgCommentNumPerUser(), 0);
        Assert.assertEquals(0, counter.getAvgPostNumPerUser(), 0);
    }

    //gdy liczba użytkowników = 100.
    @Test
    public void testUserCount100() {
        List<String> listOfUsers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listOfUsers.add("User#" + i);
        }
        Mockito.when(mockStat.usersNames()).thenReturn(listOfUsers);

        counter.calculateAdvStatistics(mockStat);
        counter.showStatistics();

        Assert.assertEquals(100, counter.getPostCount());
    }
}
