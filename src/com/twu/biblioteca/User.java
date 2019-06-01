package com.twu.biblioteca;


import java.util.ArrayList;

public class User {

    private String name;
    private String email;
    private String phoneNumber;
    private boolean isLoggedIn;
    private ArrayList<Book> books;
    private int booksSize;
    private ArrayList<Movie> movies;
    private int moviesSize;

    public User(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isLoggedIn = false;
        this.books = new ArrayList<>();
        this.booksSize = 0;
        this.movies = new ArrayList<>();
        this.moviesSize = 0;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public boolean isLoggedIn(){
        return this.isLoggedIn;
    }

    public void add(Book book){
        this.books.add(book);
        this.booksSize += 1;
    }

    public void add(Movie movie){
        this.movies.add(movie);
        this.moviesSize += 1;
    }

    public Book getBook(int index) {
        if (this.books.size() > 0) {
            Book book = this.books.remove(index);
            return book;
        }
        return null;
    }
    public Movie getMovie(int index){
        if (this.movies.size() > 0) {
            Movie movie = this.movies.remove(index);
            return movie;
        }
        return null;
    }

    public int getBookSize(){
        return this.booksSize;
    }

    public int getMoviesSize(){
        return this.moviesSize;
    }

    public String ListBooks(){
        StringBuilder sb = new StringBuilder();
        sb.append("Title\t\tAuthor\t\tPublished Year\n");

        for (int i = 0; i < this.booksSize; i++){
            Book book = this.books.get(i);
            if (!book.isCheckedOut()){
                sb.append("\t");
                sb.append(i);
                sb.append(".\t");
                sb.append(book);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String ListMovies(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name\t\tYear\t\tDirector\t\tRating\n");
        for (int i = 0; i < this.moviesSize; i++){
            Movie movie = this.movies.get(i);
            if (!movie.isCheckedout()){
                sb.append("\t");
                sb.append(i);
                sb.append(".\t");
                sb.append(movie);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tAccount Information\n");
        sb.append("\t");
        sb.append(this.name);
        sb.append("\n");
        sb.append("\t");
        sb.append(this.email);
        sb.append("\n");
        sb.append("\t");
        sb.append(this.phoneNumber);

        return sb.toString();
    }


}
