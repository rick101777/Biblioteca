package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    User user;
    Book book;
    Movie movie;

    @Before
    public void init(){
        user = new User("Charlie", "c.Charlie@domain.com", "847-244-8954");
        book = new Book("This One", "HIM", 1999);
        movie = new Movie("Sky", 1965, "That Dude", 5.5);
    }

    @Test
    public void getNameTest(){
        assertNotNull(user.getName());
    }

    @Test
    public void getEmailTest(){
        assertNotNull(user.getEmail());
    }

    @Test
    public void getPhoneNumber(){
        assertNotNull(user.getPhoneNumber());
    }

    @Test
    public void LoggedInStatusTest(){
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void addBookTest(){
        user.add(book);
        assertTrue(user.getBookSize() > 0);
    }

    @Test
    public void getBookTest(){
        user.add(book);
        assertTrue(user.getBook(0).equals(book));
    }

    @Test
    public void addMovieTest(){
        user.add(movie);
        assertTrue(user.getMoviesSize() > 0);
    }

    @Test
    public void getMovieTest(){
        user.add(movie);
        assertTrue(user.getMovie(0).equals(movie));
    }

    @Test
    public void appendedBookIsListed(){
        user.add(book);
        String list = user.ListBooks();
        assertTrue(list.contains(book.getTitle()));
    }

    @Test
    public void appendedMovieIsListed(){
        user.add(movie);
        String list = user.ListMovies();
        assertTrue(list.contains(movie.getName()));
    }


}
