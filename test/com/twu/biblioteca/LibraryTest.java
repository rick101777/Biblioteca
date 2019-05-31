package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    Library library;

    @Before
    public void init(){
        library = new Library();
    }


/*----------------------------------Book Tests------------------------------------------*/
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
        library.BookCheckout("Le Petit Prince");
        assertTrue(!library.ListBooks().contains("Le Petit Prince"));
    }

    @Test
    public void CheckoutTestSuccess1(){
        library.BookCheckout("Harry Potter and the Philosopher's Stone");
        assertTrue(!library.ListBooks().contains("Harry Potter and the Philosopher's Stone"));
    }

    @Test
    public void CheckoutTestSuccess2(){
        library.BookCheckout("The Hobbit");
        assertTrue(!library.ListBooks().contains("The Hobbit"));
    }

    @Test
    public void CheckoutTestSuccess3(){
        library.BookCheckout("The Lion, the Witch and the Wardrobe");
        assertTrue(!library.ListBooks().contains("The Lion, the Witch and the Wardrobe"));
    }

    @Test
    public void ReturnTestSuccess(){
        Book book = library.BookCheckout("Le Petit Prince");
        library.BookReturn(book);
        assertTrue(library.ListBooks().contains("Le Petit Prince"));
    }

    @Test
    public void ReturnTestSuccess1(){
        Book book = library.BookCheckout("Harry Potter and the Philosopher's Stone");
        library.BookReturn(book);
        assertTrue(library.ListBooks().contains("Harry Potter and the Philosopher's Stone"));
    }

    @Test
    public void ReturnTestSuccess2(){
        Book book = library.BookCheckout("The Hobbit");
        library.BookReturn(book);
        assertTrue(library.ListBooks().contains("The Hobbit"));
    }

    @Test
    public void ReturnTestSuccess3(){
        Book book = library.BookCheckout("The Lion, the Witch and the Wardrobe");
        library.BookReturn(book);
        assertTrue(library.ListBooks().contains("The Lion, the Witch and the Wardrobe"));
    }

    @Test
    public void CheckingOutCheckedOutBook(){
        String title = "Le Petit Prince";
        library.BookCheckout(title);
        Book status = library.BookCheckout(title);
        assertNull(status);
    }

    @Test
    public void CheckingOutCheckedOutBook1(){
        String title = "Harry Potter and the Philosopher's Stone";
        library.BookCheckout(title);
        Book status = library.BookCheckout(title);
        assertNull(status);
    }

    @Test
    public void CheckingOutCheckedOutBook2(){
        String title = "The Hobbit";
        library.BookCheckout(title);
        Book status = library.BookCheckout(title);
        assertNull(status);
    }

    @Test
    public void CheckingOutCheckedOutBook3(){
        String title = "The Lion, the Witch and the Wardrobe";
        library.BookCheckout(title);
        Book status = library.BookCheckout(title);
        assertNull(status);
    }

    @Test
    public void ReturningUncheckedOutBook(){
        Book book = library.BookSearch("Le Petit Prince");
        boolean status = library.BookReturn(book);
        assertFalse(status);
    }

    @Test
    public void ReturningUncheckedOutBook1(){
        Book book = library.BookSearch("Harry Potter and the Philosopher's Stone");
        boolean status = library.BookReturn(book);
        assertFalse(status);
    }

    @Test
    public void ReturningUncheckedOutBook2(){
        Book book = library.BookSearch("The Hobbit");
        boolean status = library.BookReturn(book);
        assertFalse(status);
    }

    @Test
    public void ReturningUncheckedOutBook3(){
        Book book = library.BookSearch("The Lion, the Witch and the Wardrobe");
        boolean status = library.BookReturn(book);
        assertFalse(status);
    }


    @Test
    public void IncorrectTitleBookSearch(){
        Book book = library.BookSearch("Le Peee");
        assertNull(book);
    }

/*---------------------------------Movie Tests------------------------------------------------*/

    @Test
    public void MovieSearchIncorrectTitle(){
        Movie movie = library.MovieSearch("Shawbank rejection");
        assertNull(movie);
    }

    @Test
    public void MovieSearchCorrectTitle(){
        Movie movie = library.MovieSearch("The Godfather");
        assertNotNull(movie);
    }

    @Test
    public void MovieReturnNotInLibraryDirectory(){
        Movie movie = new Movie("FAKE", 2077, "THE BEST", 0.5);

        assertFalse(library.MovieReturn(movie));
    }

    @Test
    public void MovieReturnIsNotCheckedout(){
        Movie movie = library.MovieSearch("The Godfather");
        assertFalse(library.MovieReturn(movie));

    }

    @Test
    public void MovieReturnIsCheckout(){
        Movie movie = library.MovieCheckout("The Godfather");
        assertTrue(library.MovieReturn(movie));
    }

    @Test
    public void MovieCheckoutIncorrectTitle(){
        assertNull(library.MovieCheckout("FAKE"));
    }

    @Test
    public void MovieCheckoutCorrectTitle(){
        assertNotNull(library.MovieCheckout("Shazam"));
    }


    @Test
    public void ListMoviesCheckedoutMovieDisappears(){
        library.MovieCheckout("Shazam");
        assertFalse(library.ListMovies().contains("Shazam"));
    }


    @Test
    public void ListMoviesReturnedMovieReappears(){
        Movie movie = library.MovieCheckout("Avengers Endgame");
        library.MovieReturn(movie);
        assertTrue(library.ListMovies().contains(movie.getName()));
    }


}
