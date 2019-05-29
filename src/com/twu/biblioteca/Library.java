package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Movie> movies;
    private HashMap<String, String> LibraryCredentials; // Unique library number | Unique Password

    public Library(){
        this.books = new ArrayList<>();
        this.movies = new ArrayList<>();

        books.add(new Book("Le Petit Prince", "Antoine de Saint-Exupery", 1943));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        books.add(new Book("The Lion, the Witch and the Wardrobe", "C.S. Lewis", 1950));
    }


    public boolean Checkout(String title){
        Book book = BookSearch(title);
        boolean status = false;
        if (book != null) {
            book.Checkout();
            System.out.println("Thank you! Enjoy the book");
            status = true;
        }else{
            System.out.println("Sorry, that book is not available");
            status = false;
        }
        return status;
    }

    public boolean Return(String title) {
        boolean notFound = true;
        boolean status = false;
        for (Book book : this.books) {
            if (book.isCheckedOut() && book.getTitle().toLowerCase().equals(title.toLowerCase())) {
                book.Return();
                notFound = false;
                System.out.println("Thank you for returning the book");
                status = true;
            }
        }
        if (notFound) {
            System.out.println("That is not a valid book to return");
            status = false;
        }
        return status;
    }

    public Book BookSearch(String title){
        for (Book book : this.books){
            if (!book.isCheckedOut() && book.getTitle().toLowerCase().equals(title.toLowerCase())){
                return book;
            }
        }
        return null;
    }




    public boolean verifyPassword(){

        return false;
    }



    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Title\t\tAuthor\t\tPublished Year\n");
        for (Book book : this.books){
            if (!book.isCheckedOut()){
                sb.append(book.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }


}
