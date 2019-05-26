package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {

        Library library = new Library();
        library.add(new Book("Le Petit Prince", "Antoine de Saint-Exupery", 1943));
        library.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        library.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        library.add(new Book("The Lion, the Witch and the Wardrobe", "C.S. Lewis", 1950));

        Scanner scan = new Scanner(System.in);


        System.out.println("Welcome to Biblioteca. Your one stop-shop for great book titles in Bangalore!");
        int choice = 2;
        while(true){
            System.out.println("Main Menu:\n\t 1. List of books \n\t 2. Exit Application");
            System.out.println("Enter your choice: ");

            try {
                choice = scan.nextInt();
            }catch(InputMismatchException ime){ System.out.println("That is not a valid option."); }

            switch(choice){
                case 1:
                    System.out.println("");
                    System.out.println(library.toString());
                    boolean Continue = true;
                    while(Continue){
                        System.out.println("Book Action Menu:\n\t 1. Checkout a book \n\t 2. Return a book \n\t 3. Return to Main Menu \n\t 4. Exit Application");
                        System.out.println("Enter choice: ");
                        try{
                            choice = scan.nextInt();
                        }catch(InputMismatchException ime){ }
                        String bookTitle;
                        switch (choice){
                            case 1:
                                System.out.println("Enter book title: ");
                                bookTitle = scan.nextLine();
                                library.Checkout(bookTitle);
                                break;
                            case 2:

                                break;
                            case 3:
                                Continue = false;
                                break;
                            case 4:
                                System.exit(0);
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Application will close....");
                    System.exit(0);
                    break;
                default:
                    break;
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
}
