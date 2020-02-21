package com.kodilla.patterns2.observer.homework;


import java.util.ArrayDeque;
import java.util.Deque;


public class Student implements ObservableStudent {
    private String name;
    private final Deque<Exercise> homeworkList = new ArrayDeque<>();
    private ObserverMentor mentor;

    public Student(String name) {
        this.name = name;
    }

    public void sendHomeworkForChecking(Exercise exercise) {
        homeworkList.offerLast(exercise);
        notifyMentor();
    }

    
    
    @Override
    public void assignMentor(ObserverMentor observerMentor) {
        mentor = observerMentor;
    }

    @Override
    public void changeMentor(ObserverMentor observerMentor) {
        mentor = observerMentor;
    }

    @Override
    public void notifyMentor() {
        mentor.getHomeworkNotification(this);
    }

    public String getName() {
        return name;
    }

    public Deque<Exercise> getHomeworkList() {
        return homeworkList;
    }
}
