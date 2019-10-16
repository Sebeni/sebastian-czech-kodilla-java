package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.Arrays;

public class StreamMain {
    public static void main(String[] args) {
        //Module 7.2
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
        

        //Exercise 7.1
        /*
        PoemBeautifier beautifier = new PoemBeautifier();
        String toBeautify = "Trying to understand lambdas";
        
        beautifier.beautify(toBeautify, String::toUpperCase);
        beautifier.beautify(toBeautify, s -> "¯\\_(ツ)_/¯ " + s + " ¯\\_(ツ)_/¯");
        beautifier.beautify(toBeautify, s -> new StringBuilder(s).reverse().toString());
        
        beautifier.beautify(toBeautify, s -> {
            char[] charArray = s.toCharArray();
            for(int i = 0; i < charArray.length; i++){
                if(i%2==0) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                }
            }
            return String.copyValueOf(charArray);
            }
        );
        
        beautifier.beautify(toBeautify, s -> {
            String[] split = s.split("\\s+");
            StringBuilder result = new StringBuilder();
            for(int i = split.length-1; i >=0; i--){
                result.append(split[i]).append(" ");
            }
            return result.toString();
        });
         */
        
        //Module 7.1
        //standard OOP
        /*
        SaySomething saySomething = new SaySomething();
        saySomething.say();
         */
        
        //standard OOP
        /*
        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);
        
         */
        
        //Lambda without arguments
        /*
        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("This is lambda as variable");
        processor.execute(codeToExecute);
         */
        
        
        //Lambda without arguments
        /*
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is lambda as argument"));
        
        */
        
        //Anonymous class
        /*
        processor.execute(new Executor(){
            @Override
            public void process() {
                System.out.println("this is anonymous class");
            }
        });
         */
        
        //Lambda with arguments and a return type
        /*
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        
        //Lambda with interface
        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        
        //Lambda with method reference (static methods and object methods)
        System.out.println("Calculating expressions with static method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
        
         */
    }
}
