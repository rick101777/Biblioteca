package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> library;

    public Library(){
        this.library = new ArrayList<>();
    }

    public void add(Book book){
        this.library.add(book);
    }

    public void Checkout(String title){
        Book book = BookSearch(title);
        if (book != null) {
            book.Checkout();
            System.out.println("Thank you! Enjoy the book");
        }else{
            System.out.println("Sorry, that book is not available");
        }
    }

    public void Return(String title) {
        boolean notFound = true;
        for (Book book : this.library) {
            if (book.isCheckedOut() && book.getTitle().toLowerCase().equals(title.toLowerCase())) {
                book.Return();
                notFound = false;
                System.out.println("Thank you for returning the book");
            }
        }
        if (notFound) {
            System.out.println("That is not a valid book to return");
        }
    }

    public Book BookSearch(String title){
        for (Book book : this.library){
            if (!book.isCheckedOut() && book.getTitle().toLowerCase().equals(title.toLowerCase())){
                return book;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Title\t\tAuthor\t\tPublished Year\n");
        for (Book book : this.library){
            if (!book.isCheckedOut()){
                sb.append(book.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }


}
