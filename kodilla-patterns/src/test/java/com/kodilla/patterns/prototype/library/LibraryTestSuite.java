package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    private Library library = new Library("Original library");
    private Book one = new Book("First", "A", LocalDate.of(2011, 1, 1));
    private Book two = new Book("Second", "B", LocalDate.of(2012, 2, 2));
    private Book three = new Book("Third", "C", LocalDate.of(2013, 3, 3));


    @Before
    public void populateLibrary() {
        library.getBooks().add(one);
        library.getBooks().add(two);
        library.getBooks().add(three);
    }
    
    
    @Test
    public void testGetBooksWithCopy () {
        Library shallowCopy = library.shallowCopy();
        shallowCopy.setName("Shallow copy");
        Library deepCopy = library.deepCopy();
        deepCopy.setName("Deep copy");
        
        library.getBooks().remove(one);

        Assert.assertEquals(library, shallowCopy);
        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(2, shallowCopy.getBooks().size());
        
        Assert.assertNotEquals(library, deepCopy);
        Assert.assertEquals(3, deepCopy.getBooks().size());

        System.out.println(library);
        System.out.println(shallowCopy);
        System.out.println(deepCopy);

        
    }
    
}
