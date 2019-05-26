package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class BibliotecaApp {

    public static String ListBooks(ArrayList<Book> library){
        StringBuilder sb = new StringBuilder();
        sb.append("Title\t\tAuthor\t\tPublished Year\n");
        for (Book book : library){
            if (!book.isCheckedOut()){
                sb.append(book.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        ArrayList<Book> library = new ArrayList<>();
        library.add(new Book("Le Petit Prince", "Antoine de Saint-Exupery", 1943));
        library.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        library.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        library.add(new Book("The Lion, the Witch and the Wardrobe", "C.S. Lewis", 1950));

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Biblioteca. Your one stop-shop for great book titles {name}!");
        while(true){
            System.out.println("Options:\n 1. List of books \n 2. Exit Application");
            System.out.print("Enter your choice: ");
            int choice = 2;
            try {
                choice = scan.nextInt();
            }catch(InputMismatchException ime){ }
            switch(choice){
                case 1:
                    System.out.println("");
                    System.out.println(ListBooks(library));
//                    boolean Continue = true;
//                    while(Continue){
//                        System.out.println("Options:\n 1. Checkout a book \n 2. Return a book \n 3. Return to Main Menu \n 4. Exit Application");
//                        System.out.print("Enter choice: ");
//                        try{
//                            choice = scan.nextInt();
//                        }catch(InputMismatchException ime){ }
//                        switch (choice){
//                            case 1:
//                                break;
//                            case 2:
//                                System.out.print("Enter book title: ");
//                                String bookTitle = scan.next();
//                                break;
//                            case 3:
//                                Continue = false;
//                                break;
//                            case 4:
//                                System.exit(0);
//                                break;
//                            default:
//                                break;
//                        }
//                    }
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
