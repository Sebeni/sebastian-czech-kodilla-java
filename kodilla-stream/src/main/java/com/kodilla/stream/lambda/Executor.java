package com.kodilla.stream.lambda;

public interface Executor {
    void process();
    
    static void anotherStatic(){
        System.out.println("another static method");
    }
    
    default void anotherDefault(){
        System.out.println("another default method");
    }
    
}
