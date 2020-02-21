package com.kodilla.patterns2.observer.homework;

public class MentorNotificator implements ObserverMentor {
    @Override
    public void getHomeworkNotification(Student student) {
        System.out.println(String.format("Your student: %s has just sent you exercise: %s to check.\n" +
                "Number of exercises to check from that student: %d", 
                student.getName(), 
                student.getHomeworkList().peekLast().getName(), 
                student.getHomeworkList().size()));
    }
}
