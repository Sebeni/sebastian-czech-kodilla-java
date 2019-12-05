package com.kodilla.spring.codependency;

import org.springframework.stereotype.Component;

@Component
public class First {
    private Second second;

    public First(Second second) {
        System.out.println("FIRST constructor");
        this.second = second;
    }
    
    public void shout() {
        System.out.println("This is second instance in first");
    }
}
