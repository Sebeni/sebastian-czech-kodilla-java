package com.kodilla.patterns2.adapter.bookclasifier;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    
//    to avoid mistakes no imports of neither librarya nor libraryb
    @Override
    public int publicationYearMedian(Set<com.kodilla.patterns2.adapter.bookclasifier.librarya.Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> books = new HashMap<>();
        
        for(com.kodilla.patterns2.adapter.bookclasifier.librarya.Book bookFromLibA : bookSet) {
            books.put(
                    new BookSignature(bookFromLibA.getSignature()), 
                    new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(
                            bookFromLibA.getAuthor(), 
                            bookFromLibA.getTitle(), 
                            bookFromLibA.getPublicationYear()));
        }
        
        
        return medianPublicationYear(books);
    }
}
