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
        for (Book book : this.library) {
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
