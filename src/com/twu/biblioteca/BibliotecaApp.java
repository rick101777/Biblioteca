package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {


    public static int mainMenu(Scanner scan){
        int choice = -1;
        do {
            System.out.println("Main Menu:\n\t 1. List of books \n\t 2. Exit Application");
            System.out.println("Enter your choice: ");
            choice = scan.nextInt();
            if (choice <= 0 || choice >= 3) { System.out.println("That is an invalid option. Try Again...");}
        }while (choice <= 0 || choice >= 3);


        return choice;
    }

    public static int bookMenuOption(Scanner scan){
        int choice = -1;
        do {
            System.out.println("Book Action Menu:\n\t 1. Checkout a book \n\t 2. Return a Book \n\t 3. Return to Main Menu \n\t 4. Exit Application");
            System.out.println("Enter your choice: ");
            choice = scan.nextInt();
        }while(choice <= 0 || choice >= 5);
        return choice;
    }

    public static String getTitle(Scanner scan){
        String title = "";
        do {

        }while (title != "");

        return title;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Library library = new Library();
        library.add(new Book("Le Petit Prince", "Antoine de Saint-Exupery", 1943));
        library.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        library.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        library.add(new Book("The Lion, the Witch and the Wardrobe", "C.S. Lewis", 1950));

        System.out.println("Welcome to Biblioteca. Your one stop-shop for great book titles in Bangalore!");

        boolean shouldRun = true;
        while (shouldRun){
            int MainActionChoice = mainMenu(scan);
            switch (MainActionChoice){
                case 1:
                    System.out.println(library.toString());
                    boolean BookActions = true;
                    while (BookActions){
                        int BookActionChoice = bookMenuOption(scan);
                        switch (BookActionChoice){
                            case 1:

                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2:
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

