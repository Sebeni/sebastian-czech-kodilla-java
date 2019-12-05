package com.kodilla.spring.codependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Second {
    private First first;

    public Second() {
        System.out.println("SECOND constructor");
    }

    public void setFirst(First first) {
        System.out.println("SETTER in SECOND");
        this.first = first;
    }

    public void shout() {
        System.out.println("This is first instance in second");
    }
    
}
