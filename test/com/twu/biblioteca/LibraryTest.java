package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    Library library;

    @Before
    public void init(){
        library = new Library();
        library.add(new Book("Le Petit Prince", "Antoine de Saint-Exupery", 1943));
        library.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        library.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        library.add(new Book("The Lion, the Witch and the Wardrobe", "C.S. Lewis", 1950));
    }

    @Test
    public void BookSearchTestSuccess(){
        Book book = library.BookSearch("Le Petit Prince");
        assertNotNull(book);
    }

    @Test
    public void BookSearchTestSuccess1(){
        Book book = library.BookSearch("Harry Potter and the Philosopher's Stone");
        assertNotNull(book);
    }

    @Test
    public void BookSearchTestSuccess2(){
        Book book = library.BookSearch("The Hobbit");
        assertNotNull(book);
    }

    @Test
    public void BookSearchTestSuccess3(){
        Book book = library.BookSearch("The Lion, the Witch and the Wardrobe");
        assertNotNull(book);
    }

    @Test
    public void CheckoutTestSuccess(){
        library.Checkout("Le Petit Prince");
        assertTrue(!library.toString().contains("Le Petit Prince"));
    }

    @Test
    public void CheckoutTestSuccess1(){
        library.Checkout("Harry Potter and the Philosopher's Stone");
        assertTrue(!library.toString().contains("Harry Potter and the Philosopher's Stone"));
    }

    @Test
    public void CheckoutTestSuccess2(){
        library.Checkout("The Hobbit");
        assertTrue(!library.toString().contains("The Hobbit"));
    }

    @Test
    public void CheckoutTestSuccess3(){
        library.Checkout("The Lion, the Witch and the Wardrobe");
        assertTrue(!library.toString().contains("The Lion, the Witch and the Wardrobe"));
    }

    @Test
    public void ReturnTestSuccess(){
        library.Checkout("Le Petit Prince");
        library.Return("Le Petit Prince");
        assertTrue(library.toString().contains("Le Petit Prince"));
    }

    @Test
    public void ReturnTestSuccess1(){
        library.Checkout("Harry Potter and the Philosopher's Stone");
        library.Return("Harry Potter and the Philosopher's Stone");
        assertTrue(library.toString().contains("Harry Potter and the Philosopher's Stone"));
    }

    @Test
    public void ReturnTestSuccess2(){
        library.Checkout("The Hobbit");
        library.Return("The Hobbit");
        assertTrue(library.toString().contains("The Hobbit"));
    }

    @Test
    public void ReturnTestSuccess3(){
        library.Checkout("The Lion, the Witch and the Wardrobe");
        library.Return("The Lion, the Witch and the Wardrobe");
        assertTrue(library.toString().contains("The Lion, the Witch and the Wardrobe"));
    }

    @Test
    public void CheckingOutCheckedOutBook(){
        String title = "Le Petit Prince";
        library.Checkout(title);
        boolean status = library.Checkout(title);
        assertFalse(status);
    }

    @Test
    public void CheckingOutCheckedOutBook1(){
        String title = "Harry Potter and the Philosopher's Stone";
        library.Checkout(title);
        boolean status = library.Checkout(title);
        assertFalse(status);
    }

    @Test
    public void CheckingOutCheckedOutBook2(){
        String title = "The Hobbit";
        library.Checkout(title);
        boolean status = library.Checkout(title);
        assertFalse(status);
    }

    @Test
    public void CheckingOutCheckedOutBook3(){
        String title = "The Lion, the Witch and the Wardrobe";
        library.Checkout(title);
        boolean status = library.Checkout(title);
        assertFalse(status);
    }

    @Test
    public void ReturningUncheckedOutBook(){
        String title = "Le Petit Prince";
        boolean status = library.Return(title);
        assertFalse(status);
    }

    @Test
    public void ReturningUncheckedOutBook1(){
        String title = "Harry Potter and the Philosopher's Stone";
        boolean status = library.Return(title);
        assertFalse(status);
    }

    @Test
    public void ReturningUncheckedOutBook2(){
        String title = "The Hobbit";
        boolean status = library.Return(title);
        assertFalse(status);
    }

    @Test
    public void ReturningUncheckedOutBook3(){
        String title = "The Lion, the Witch and the Wardrobe";
        boolean status = library.Return(title);
        assertFalse(status);
    }


    @Test
    public void IncorrectTitleBookSearch(){
        Book book = library.BookSearch("Le Peee");
        assertNull(book);
    }

}
