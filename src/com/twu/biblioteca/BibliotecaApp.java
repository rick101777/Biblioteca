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
                    "5. Exit Application");
            System.out.println("Enter your choice: ");
            try {
                choice = scan.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("Entry must be an integer!");
                System.exit(-1);
            }
            if (choice <= 0 || choice >= 5) { System.out.println("That is an invalid option. Try Again...");}
        }while (choice <= 0 || choice >= 5);


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

    public static User Login(){

        return null;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Library library = new Library();
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
                                    library.BookCheckout(checkoutTitle);
                                    // TODO
                                    // Give book to User
                                }else{
                                    // Prompt user to login
                                }

                                break;
                            case 2:
                                if (user != null) {
                                    //String returnTitle = getTitle(scan);
                                    //library.BookReturn(returnTitle);
                                    // TODO
                                }else{
                                    // Prompt user to login
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
                                    // TODO
                                    String movieName = getTitle(scan);
                                    Movie movie = library.MovieCheckout(movieName);
                                    // give book to user
                                }else {
                                    // prompt user to login
                                }
                                break;
                            case 2:
                                if (user != null){
                                    // Select a Movie to Return
                                    // TODO
                                    library.MovieReturn(null);
                                }else{
                                    // Prompt user to login
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
                    //TODO
                    break;
                case 4:
                    //TODO
                    break;
                case 5:
                    shouldRun = false;
                    break;
                default:
                    break;
            }
        }

    }

        // Display Options for user:
            // List Books
                // Options:
                    // Checkout book
                    // Return book
                    // Exit
            // Exit
}

