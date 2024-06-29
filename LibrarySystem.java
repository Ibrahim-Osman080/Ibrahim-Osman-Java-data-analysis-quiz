import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }
}

public class LibrarySystem {
    private static List<Book> library = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after integer input

            switch (choice) {
                case 1:
                    addBooks(scanner);
                    break;
                case 2:
                    borrowBooks(scanner);
                    break;
                case 3:
                    returnBooks(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nLibrary System Menu:");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline after integer input

        // Check if the book already exists
        boolean bookExists = false;
        for (Book book : library) {
            if (book.title.equalsIgnoreCase(title)) {
                book.quantity += quantity;
                bookExists = true;
                break;
            }
        }

        // If book is new, add it to the library
        if (!bookExists) {
            library.add(new Book(title, author, quantity));
        }

        System.out.println("Book added/updated successfully.");
    }

    private static void borrowBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity to borrow: ");
        int borrowQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline after integer input

        // Find the book in the library
        boolean bookFound = false;
        for (Book book : library) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.quantity >= borrowQuantity) {
                    book.quantity -= borrowQuantity;
                    System.out.println("Books borrowed successfully.");
                } else {
                    System.out.println("Insufficient copies available.");
                }
                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Book not found in library.");
        }
    }

    private static void returnBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity to return: ");
        int returnQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline after integer input

        // Find the book in the library
        boolean bookFound = false;
        for (Book book : library) {
            if (book.title.equalsIgnoreCase(title)) {
                book.quantity += returnQuantity;
                System.out.println("Books returned successfully.");
                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Book not found in library.");
        }
    }
}
