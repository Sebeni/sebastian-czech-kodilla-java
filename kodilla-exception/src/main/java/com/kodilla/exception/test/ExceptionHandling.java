package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge sc = new SecondChallenge();
        
        double x = 0;
        double y = 0;
        
        for (int i = 1; i < 10; i++){
            try{
                System.out.println(sc.probablyIWillThrowException((x+=0.5), (y+=0.5)));
            } catch (Exception e) {
                System.out.println("Exception occured. Arguments value x: " + x + " y: " + y);
            } finally {
                System.out.println("try num: #" + i + " has been finished");
            }
        }
    }
}
