package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {


    public static int mainMenu(Scanner scan){
        int choice = -1;
        do {
            System.out.println("Main Menu:\n\t 1. List of books \n\t 2. Exit Application");
            System.out.println("Enter your choice: ");
            try {
                choice = scan.nextInt();
            }catch (InputMismatchException ime){
                System.out.println("Entry must be an integer!");
                System.exit(-1);
            }
            if (choice <= 0 || choice >= 3) { System.out.println("That is an invalid option. Try Again...");}
        }while (choice <= 0 || choice >= 3);


        return choice;
    }

    public static int bookMenuOption(Scanner scan){
        int choice = -1;
        do {
            System.out.println("Book Action Menu:\n\t 1. Checkout a book \n\t 2. Return a Book \n\t 3. Return to Main Menu \n\t 4. Exit Application");
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
        System.out.println("Enter the title of the Book: ");
        do {
            title = scan.nextLine();
        }while (title.equals(""));

        return title;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Library library = new Library();

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
                                String checkoutTitle = getTitle(scan);
                                library.Checkout(checkoutTitle);
                                break;
                            case 2:
                                String returnTitle = getTitle(scan);
                                library.Return(returnTitle);
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

