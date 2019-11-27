package com.kodilla.stream.additional;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    
    static long getCountEmptyStringUsingJava8(List<String> strings){
        return strings.stream()
                .filter(String::isEmpty)
                .count();
    }


    static long getCountLength3UsingJava8(List<String> strings){
        return strings.stream()
                .filter(s -> s.length() == 3)
                .count();
    }

    static List<String> deleteEmptyStringsUsingJava8(List<String> strings){
        return strings.stream()
                .filter(s -> !(s.matches("^$")))
                .collect(Collectors.toList());
    }
    
    static String getMergedStringUsingJava8(List<String>strings, String delimiter){
        return strings.stream()
                .filter(s -> !(s.matches("^$")))
                .collect(Collectors.joining(delimiter));
    }
    
    static List<Integer> getSquaresJava8(List<Integer> numbers){
        return numbers.stream()
                .distinct()
                .map(integer -> integer*integer)
                .collect(Collectors.toList());
    }
    
    static Integer getMaxJava8(List<Integer> numbers){
        return numbers.stream()
                .mapToInt(value -> value)
                .max().orElse(Integer.MAX_VALUE);
    }
    
    static Integer getMinJava8(List<Integer> numbers){
        return numbers.stream()
                .mapToInt(value -> value)
                .min().orElse(Integer.MIN_VALUE);
    }
    
    public static Integer getSumJava8(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(value -> value)
                .sum();
    }

    public static Integer getAverageJava8(List<Integer> numbers) {
        return (int) numbers.stream()
                .mapToInt(value -> value)
                .average().orElse(0);
    }
}
