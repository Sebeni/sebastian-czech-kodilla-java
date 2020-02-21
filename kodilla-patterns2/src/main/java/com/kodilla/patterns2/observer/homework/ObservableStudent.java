package com.kodilla.patterns2.observer.homework;

public interface ObservableStudent {
    void assignMentor(ObserverMentor observerMentor);
    void changeMentor(ObserverMentor observerMentor);
    void notifyMentor();
}
