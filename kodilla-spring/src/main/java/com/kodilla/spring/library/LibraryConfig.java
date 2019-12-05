package com.kodilla.spring.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {
    @Bean
    public Library library() {
//        System.out.println("LibraryConfig");
        return new Library(libraryDbController());
    }

    @Bean
    public LibraryDbController libraryDbController() {
        return new LibraryDbController();
    }
}
