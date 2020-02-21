package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MentorNotificatorTest {
    
    @Test
    public void testMentorNotificator() {
        MentorNotificator firstMentor = Mockito.spy(new MentorNotificator());
        MentorNotificator secondMentor = Mockito.spy(new MentorNotificator());
        
        
        Student Joe = new Student("Joe");
        Joe.assignMentor(firstMentor);
        
        Student Mike = new Student("Mike");
        Mike.assignMentor(firstMentor);
        
        Student Andy = new Student("Andy");
        Andy.assignMentor(secondMentor);
        
        Exercise first = new Exercise("FirstEX");
        Exercise second = new Exercise("SecondEX");
        Exercise third = new Exercise("ThirdEX");
        
        Joe.sendHomeworkForChecking(first);
        Joe.sendHomeworkForChecking(second);
        
        Mike.sendHomeworkForChecking(second);
        
        Andy.sendHomeworkForChecking(third);
        
        Mockito.verify(firstMentor, Mockito.times(2)).getHomeworkNotification(Joe);
        Mockito.verify(firstMentor, Mockito.times(1)).getHomeworkNotification(Mike);
        Mockito.verify(secondMentor, Mockito.times(1)).getHomeworkNotification(Andy);
        
    }
}