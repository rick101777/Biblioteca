package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private int year;       // year published
    private boolean isCheckedOut;


    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
        this.isCheckedOut = false;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getYear() {
        return this.year;
    }

    public boolean isCheckedOut(){
        return this.isCheckedOut;
    }


    // function will checkout a book from the biblioteca
    public boolean Checkout(){
        if (!this.isCheckedOut){
            this.isCheckedOut = true;

            return true;
        }
        return false;
    }

    // function will return a book to the biblioteca
    public boolean Return(){
        if (this.isCheckedOut){
            this.isCheckedOut = false;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.title);
        sb.append("\t|\t");
        sb.append(this.author);
        sb.append("\t|\t");
        sb.append(this.year);
        return sb.toString();
    }

}
