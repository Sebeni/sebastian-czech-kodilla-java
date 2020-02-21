package com.kodilla.patterns2.forum;

import com.kodilla.patterns2.observer.forum.ForumTopic;
import com.kodilla.patterns2.observer.forum.ForumUser;
import com.kodilla.patterns2.observer.forum.JavaHelpForumTopic;
import com.kodilla.patterns2.observer.forum.JavaToolsForumTopic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForumUserTest {

    @Test
    void update() {
        ForumTopic javaHelp = new JavaHelpForumTopic();
        ForumTopic javaTools = new JavaToolsForumTopic();
        
        ForumUser user1 = new ForumUser("John");
        ForumUser user2 = new ForumUser("Mike");
        ForumUser user3 = new ForumUser("Donald");
        
        
        javaHelp.registerObserver(user1);
        javaHelp.registerObserver(user2);
        
        javaTools.registerObserver(user2);
        javaTools.registerObserver(user3);
        
        javaHelp.addPost("HELP!");
        javaHelp.addPost("HELP PLEASE!");
        javaHelp.addPost("HELP PLEASE HELP!");
        javaTools.addPost("ERROR");
        javaTools.addPost("EXCEPTION");

        
        assertAll(
                () -> assertEquals(3, user1.getUpdateCount()),
                () -> assertEquals(5, user2.getUpdateCount()),
                () -> assertEquals(2, user3.getUpdateCount())
        );
        
    }
}