package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {

    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    public Library(){
        this.books = new ArrayList<>();
        this.movies = new ArrayList<>();

        books.add(new Book("Le Petit Prince", "Antoine de Saint-Exupery", 1943));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        books.add(new Book("The Lion, the Witch and the Wardrobe", "C.S. Lewis", 1950));


        movies.add(new Movie("The Godfather", 1972, "Francis Ford Coppola", 9.2));
        movies.add(new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 9.3));
        movies.add(new Movie("Shazam", 2019, "David Sandberg", 7.4));
        movies.add(new Movie("Avengers Endgame", 2019, "Anthony Russo", 8.8));
    }

/*----------------------------------------Book Methods-------------------------------------*/

    public Book BookCheckout(String title){
        Book book = BookSearch(title);
        if (book != null) {
            book.Checkout();
            System.out.println("Thank you! Enjoy the book");
        }else{
            System.out.println("Sorry, that book is not available");
        }
        return book;
    }

    public boolean BookReturn(String title) {
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



    public String ListBooks(){
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

/*---------------------------------------Movie Methods--------------------------------------------------*/

    public Movie MovieCheckout(String title){
        Movie movie = MovieSearch(title);
        if (movie != null){
            movie.Checkout();
            System.out.println("Thank you! Enjoy the movie.");
            return movie;
        }else {
            System.out.println("Sorry, that movie is not available");
        }
        return null;
    }

    public boolean MovieReturn(Movie movie){
        boolean notFound = true;
        boolean status = false;
        for (Book book : this.books) {
            if (book.isCheckedOut() && movie.getName().toLowerCase().equals(movie.getName().toLowerCase())) {
                book.Return();
                notFound = false;
                System.out.println("Thank you for returning the movie");
                status = true;
            }
        }
        if (notFound) {
            System.out.println("That is not a valid movie to return");
            status = false;
        }
        return status;
    }

    public Movie MovieSearch(String title){
        for (Movie movie : this.movies){
            if (!movie.isCheckedout() && movie.getName().toLowerCase().equals(title.toLowerCase())){
                return movie;
            }
        }
        return null;
    }


    public String ListMovies(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name\t\tYear\t\tDirector\t\tRating");
        for (Movie movie : this.movies){
            if (!movie.isCheckedout()){
                sb.append(movie.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}
