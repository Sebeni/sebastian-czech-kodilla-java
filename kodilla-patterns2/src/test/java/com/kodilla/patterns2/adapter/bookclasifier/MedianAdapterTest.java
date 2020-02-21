package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTest {

    @Test
    void publicationYearMedianTestOddNumOfBooks() {
        Set<Book> booksFromLibA = new HashSet<>();
        
        Book book1 = new Book("A", "B", 1999, "123");
        Book book2 = new Book("A", "B", 2015, "123");
        Book book3 = new Book("A", "B", 1748, "123");
        
        booksFromLibA.add(book1);
        booksFromLibA.add(book2);
        booksFromLibA.add(book3);

        Classifier classifier = new MedianAdapter();
        int median = classifier.publicationYearMedian(booksFromLibA);
        
        assertEquals(1999, median);
        
    }

    @Test
    void publicationYearMedianTestEvenNumOfBooks() {
        Set<Book> booksFromLibA = new HashSet<>();

        Book book1 = new Book("A", "B", 1999, "123");
        Book book2 = new Book("A", "B", 2015, "123");
        Book book3 = new Book("A", "B", 1748, "123");
        Book book4 = new Book("A", "B", 2020, "123");

        booksFromLibA.add(book1);
        booksFromLibA.add(book2);
        booksFromLibA.add(book3);
        booksFromLibA.add(book4);

        Classifier classifier = new MedianAdapter();
        int median = classifier.publicationYearMedian(booksFromLibA);

        assertEquals(2007, median);

    }
}