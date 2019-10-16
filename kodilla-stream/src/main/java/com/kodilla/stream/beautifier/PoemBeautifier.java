package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    
    public void beautify(String toBeautify, PoemDecorator decorator){
        System.out.println(decorator.decorate(toBeautify));
    }
    
}
