package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {


    public static int mainMenu(Scanner scan){
        int choice = -1;
        do {
            System.out.println("Main Menu:\n\t " +
                    "1. List of Books \n\t " +
                    "2. List of Movies \n\t " +
                    "3. Login \n\t " +
                    "4. Account Information \n\t " +
                    "5. View Books Checked out \n\t " +
                    "6. View Movies Checked out \n\t " +
                    "7. Exit Application");
            System.out.println("Enter your choice: ");
            try {
                choice = scan.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("Entry must be an integer!");
                System.exit(-1);
            }
            if (choice <= 0 || choice >= 8) { System.out.println("That is an invalid option. Try Again...");}
        }while (choice <= 0 || choice >= 8);


        return choice;
    }

    public static int bookMenuOption(Scanner scan){
        int choice = -1;
        do {
            System.out.println("Book Action Menu:\n\t " +
                    "1. Checkout a Book \n\t " +
                    "2. Return a Book \n\t " +
                    "3. Return to Main Menu \n\t " +
                    "4. Exit Application");
            System.out.println("Enter your choice: ");
            try {
                choice = scan.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("Entry must be an integer!");
                System.exit(-1);
            }
            if (choice <= 0 || choice >= 5) {System.out.println("That is an invalid option. Try Again...");}
        }while(choice <= 0 || choice >= 5);
        return choice;
    }

    public static int movieMenuOption(Scanner scan){
        int choice = -1;
        do{
            System.out.println("Movie Action Menu:\n\t " +
                    "1. Checkout a Movie \n\t " +
                    "2. Return a Movie \n\t " +
                    "3. Return to Main Menu \n\t " +
                    "4. Exit Application");
            System.out.println("Enter your choice: ");
            try {
                choice = scan.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("Entry must be an integer!");
                System.exit(-1);
            }
            if (choice <= 0 || choice >= 5) {System.out.println("That is an invalid option. Try Again...");}
        }while(choice <= 0 || choice >= 5);
        return choice;
    }

    public static String getTitle(Scanner scan){
        String title = "";
        System.out.println("Enter the title: ");
        do {
            title = scan.nextLine();
        }while (title.equals(""));

        return title;
    }

    public static User Login(Scanner scan, Verification verifier){
        String libraryNumber = "";
        String password = "";
        User user;

        System.out.println("Enter Your Library Number (XXX-XXXX): ");
        do {
            libraryNumber = scan.nextLine();
        }while (libraryNumber.equals(""));

        System.out.println("Enter Your Password: ");
        do {
            password = scan.nextLine();
        }while(password.equals(""));

        user = verifier.Login(libraryNumber, password);


        return user;
    }

    public static Book returnBookOptions(Scanner scan, User user){
        if (user.getBookSize() > 0){
            Book book;
            int choice = -1;
            System.out.println(user.ListBooks());
            System.out.println("Enter the number of the book that you want to return: ");
            do {
                try {
                    choice = scan.nextInt();
                } catch (InputMismatchException ime) { }
            }while (choice == -1);
            book = user.getBook(choice);
            return book;
        }
        System.out.println("You currently do not have any books to return");

        return null;
    }

    public static Movie returnMovieOption(Scanner scan, User user){
        if (user.getMoviesSize() > 0){
            Movie movie;
            int choice = -1;
            System.out.println(user.ListMovies());
            System.out.println("Enter the number of the movie you want to return: ");
            do{
                try{
                    choice = scan.nextInt();
                }catch(InputMismatchException ime){}
            }while(choice == -1);
            movie = user.getMovie(choice);
            return movie;
        }
        System.out.println("You currently do not have any movies to return");
        return null;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Library library = new Library();
        Verification verifier = new Verification();
        User user = null;

        System.out.println("Welcome to Biblioteca. Your one stop-shop for great book titles in Bangalore!");

        boolean shouldRun = true;
        while (shouldRun){
            int MainActionChoice = mainMenu(scan);
            switch (MainActionChoice){
                case 1:
                    System.out.println(library.ListBooks());
                    boolean BookActions = true;
                    while (BookActions){
                        int BookActionChoice = bookMenuOption(scan);
                        switch (BookActionChoice){
                            case 1:
                                if (user != null) {
                                    String checkoutTitle = getTitle(scan);
                                    Book book = library.BookCheckout(checkoutTitle);
                                    if (book != null) {
                                        user.add(book);
                                        System.out.println(library.ListBooks());
                                    }
                                }else{
                                    user = Login(scan, verifier);
                                }

                                break;
                            case 2:
                                if (user != null) {
                                    Book book = returnBookOptions(scan, user);
                                    library.BookReturn(book);
                                }else{
                                    user = Login(scan, verifier);
                                }
                                break;
                            case 3:
                                BookActions = false;
                                break;
                            case 4:
                                BookActions = false;
                                shouldRun = false;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println(library.ListMovies());
                    boolean MovieActions = true;
                    while(MovieActions){
                        int MovieActionChoice = movieMenuOption(scan);
                        switch(MovieActionChoice){
                            case 1:
                                if (user != null){
                                    String movieName = getTitle(scan);
                                    Movie movie = library.MovieCheckout(movieName);
                                    if (movie != null) {
                                        user.add(movie);
                                        System.out.println(library.ListMovies());
                                    }
                                }else {
                                    user = Login(scan, verifier);
                                }
                                break;
                            case 2:
                                if (user != null){
                                    Movie movie = returnMovieOption(scan, user);
                                    library.MovieReturn(movie);
                                }else{
                                    user = Login(scan, verifier);
                                }
                                break;
                            case 3:
                                MovieActions = false;
                                break;
                            case 4:
                                MovieActions = false;
                                shouldRun = false;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 3:
                    if (user == null) {
                        user = Login(scan, verifier);
                    }else {
                        System.out.println("You are already logged in as "+ user.getName());
                    }
                    break;
                case 4:
                    System.out.println(user);
                    break;
                case 5:
                    if (user != null){
                        System.out.println(user.ListBooks());
                    }else{
                        user = Login(scan, verifier);
                    }
                    break;
                case 6:
                    if (user != null){
                        System.out.println(user.ListMovies());
                    }else{
                        user = Login(scan, verifier);
                    }
                    break;
                case 7:
                    shouldRun = false;
                    break;
                default:
                    break;
            }
        }
        scan.close();
    }
}

