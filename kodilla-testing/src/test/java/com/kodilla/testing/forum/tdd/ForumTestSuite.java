package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.*;

public class ForumTestSuite {
    private static int testCounter = 0;
    
    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests");
    }
    
    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests are finished");
    }
    
    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Prepering to execute test #" + testCounter);
    }
    
    @Test
    public void testAddPost(){
        ForumUser forumUser = new ForumUser("Aadaam", "Adam Smith");
        
        forumUser.addPost(forumUser.getName(), "First post!!!");
        
        Assert.assertEquals(1, forumUser.getPostsQuantity());
    }
    
    @Test
    public void testAddComment(){
        ForumUser forumUser = new ForumUser("Johnyy", "Adam Smith");
        ForumPost thePost = new ForumPost("Hi!", forumUser.getName());
        
        forumUser.addComment(thePost, forumUser.getName(), "Commenting my own post!!!");
                
        Assert.assertEquals(1, forumUser.getCommentsQuantity());
    }
    
    @Test
    public void testGetPost(){
        ForumUser forumUser = new ForumUser("Johnyy", "Adam Smith");
        ForumPost thePost = new ForumPost("Hi!", forumUser.getName());
        forumUser.addPost(forumUser.getName(), thePost.getPostBody());
        
        ForumPost retrievedPost = forumUser.getPost(0);
        
        Assert.assertEquals(thePost, retrievedPost);
    }

    @Test
    public void testGetComment(){
        ForumUser forumUser = new ForumUser("Johnyy", "Adam Smith");
        ForumPost thePost = new ForumPost("Hi!", forumUser.getName());
        ForumComment theComment = new ForumComment(thePost, "My comment", forumUser.getName());
        forumUser.addComment(thePost, forumUser.getName(), theComment.getCommentBody());
        
        ForumComment retrievedComment = forumUser.getComment(0);
        
        Assert.assertEquals(theComment, retrievedComment);
    }
    
    @Test
    public void testRemovePostNotExisting(){
        ForumUser forumUser = new ForumUser("Johnyy", "Adam Smith");
        ForumPost thePost = new ForumPost("Hi!", forumUser.getName());
        
        boolean result = forumUser.removePost(thePost);
        
        Assert.assertFalse(result);
    }
    
    @Test
    public void testRemoveCommentNotExisting(){
        ForumUser forumUser = new ForumUser("Johnyy", "Adam Smith");
        ForumPost thePost = new ForumPost("Hi!", forumUser.getName());
        ForumComment theComment = new ForumComment(thePost, "Body", forumUser.getName());

        boolean result = forumUser.removeComment(theComment);

        Assert.assertFalse(result);
    }
    
    @Test
    public void testRemoveExistingComment(){
        ForumUser forumUser = new ForumUser("Johnyy", "Adam Smith");
        ForumPost thePost = new ForumPost("Hi!", forumUser.getName());
        
        ForumComment theComment = new ForumComment(thePost, "Body", forumUser.getName());

        forumUser.addComment(thePost, forumUser.getName(), theComment.getCommentBody());
        
        boolean result = forumUser.removeComment(theComment);
        
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getCommentsQuantity());
    }
    
    @Test
    public void testRemoveExistingPost(){
        ForumUser forumUser = new ForumUser("Johnyy", "Adam Smith");
        ForumPost thePost = new ForumPost("Hi!", forumUser.getName());
        forumUser.addPost(forumUser.getName(), thePost.getPostBody());
        
        boolean result = forumUser.removePost(thePost);
        
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getPostsQuantity());
    }
}
