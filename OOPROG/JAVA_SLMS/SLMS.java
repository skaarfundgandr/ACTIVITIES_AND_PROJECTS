package JAVA_SLMS;
import java.util.Scanner;

public class SLMS {
    public static void main(String[] args) {
        int choice = 0, attempts = 0, numBooks;
        String title, author, isbn;

        Scanner scan =  new Scanner(System.in);
        BookList list = new BookList();
        
        do {
            try {
                System.out.println("1. Add book");
                System.out.println("2. Display book");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scan.nextInt();
                scan.nextLine(); // Clear input buffer
                switch (choice) {
                    case 1:
                        System.out.println("Enter title");
                        title = scan.nextLine();
                        System.out.println("Enter author");
                        author = scan.nextLine();
                        System.out.println("Enter ISBN");
                        isbn = scan.nextLine();
                        System.out.println("Enter the number of books");
                        numBooks = scan.nextInt();

                        list = list.addBook(title, author, isbn, numBooks);
                        break;
                    case 2:
                        System.out.println("Enter the isbn of the book");
                        isbn = scan.nextLine();

                        list.displayBook(isbn);
                        break;

                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid choice");
                ++attempts;
                scan.nextLine(); // Clear input buffer
            }
        } while (choice != 3 && attempts < 3);
    }
}