package console;

import library.Book;
import library.Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;

        while(running){
            System.out.println("Welcome to the Library Management System");
            System.out.println("1. Add a book");
            System.out.println("2. View all books");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(title, author);
                    library.addBook(newBook);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
