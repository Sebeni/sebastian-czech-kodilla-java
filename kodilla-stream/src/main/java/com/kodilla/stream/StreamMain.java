package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.immutable.Book;
import com.kodilla.stream.immutable.BookDirectory;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        
        //Exercise 7.3
        Forum forum = new Forum();
        //just for checking
        //System.out.println(forum.getUserList());
        Map<Integer, ForumUser> resultMap = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex()=='M')
                //checking by birth year not actual birth date (omitting month and day)
                .filter(forumUser -> LocalDate.now().minusYears(forumUser.getBrithDate().getYear()).getYear() >= 20)
                .filter(forumUser -> forumUser.getPostCounter() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));
        
        resultMap.entrySet().stream()
                .forEach(System.out::println);
        
    }
}
