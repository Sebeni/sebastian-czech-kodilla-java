package com.kodilla.spring;

import com.kodilla.spring.forum.ForumUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

public class ForumUserTestSuite {
    @Test
    public void testGetUsername(){
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        ForumUser user = context.getBean(ForumUser.class);
        
//        when
        String name = user.getUserName();
        
//        then
        Assert.assertEquals("John Smith", name);
        
    }
    
}
