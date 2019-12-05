package com.kodilla.spring;

import com.kodilla.spring.codependency.First;
import com.kodilla.spring.codependency.Second;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodependencyTestSuite {
    
    @Test
    public void showCodependency() {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        First first = context.getBean(First.class);
        Second second = context.getBean(Second.class);
        
        first.shout();
        second.shout();
        
        
    }
    
}
