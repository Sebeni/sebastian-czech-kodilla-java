package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.immutable.Book;
import com.kodilla.stream.immutable.BookDirectory;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class OldMain {
    public static void main(String[] args) {

        //Module 7.3
        //joining
        /*
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getTheBookList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
        
         */


        //Operacje terminalne - kolektory
        //toMap
        /*
        BookDirectory bd = new BookDirectory();
        Map<String, Book> mapresult = bd.getTheBookList().stream()
                .filter(book -> book.getYearOfPublication() > 2003)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + mapresult.size());
        mapresult.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
                
         */

        //toList
        /*
        BookDirectory bd = new BookDirectory();
        List<Book> result = bd.getTheBookList().stream()
                .filter(book -> book.getYearOfPublication()>2007)
                .collect(Collectors.toList());
        
        result.stream()
                .forEach(System.out::println);
                
         */
        
        
        /*
        //Stream na kolekcjach z dowolnymi obiektami
        BookDirectory bookDirectory = new BookDirectory();
        bookDirectory.getTheBookList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);
        */
        
        
        /*
        //czysty stream
        People.getList().stream().forEach(s -> System.out.println(s));
        //to samo tylko zapisane jako referencja do metody
        People.getList().stream()
                .forEach(System.out::println);
        
        
        //operacje transformujące Stream - map 
        People.getList().stream()
                .map(String::toUpperCase)
                //albo map(s -> s.toUpperCase());
                .forEach(System.out::println);
        
        //operacje filtrujące - filter
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);
                
        //Kaskadowe łączenie operacji na Stream
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(" ") + 2) + ".")
                .filter(s -> s.substring(0,1).equalsIgnoreCase("M"))
                .forEach(System.out::println);
         */
        /*
        //Module 7.2
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
        
         */


        //Exercise 7.1
        /*
        PoemBeautifier beautifier = new PoemBeautifier();
        String toBeautify = "Trying to understand lambdas";
        
        beautifier.beautify(toBeautify, String::toUpperCase);
        beautifier.beautify(toBeautify, s -> "!!!" + s + "!!!");
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
