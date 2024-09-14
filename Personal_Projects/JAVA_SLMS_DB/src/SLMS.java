package JAVA_SLMS_DB;

import java.util.Scanner;

public class SLMS {
    public static void main(String[] args) {
        int choice = 0, numBooks;

        String title, author, isbn;

        Scanner scan = new Scanner(System.in);
        Database db = new Database();
        BookDAO books = new BookDAO(db.getConnection());
        
        do {
            System.out.println("1. Add book");
            System.out.println("2. Display all books");
            System.out.println("3. Display book info");
            System.out.println("4. Exit");

            choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
                System.out.println("Enter title:");
                title = scan.nextLine();
                System.out.println("Enter Author:");
                author = scan.nextLine();
                System.out.println("Enter ISBN:");
                isbn = scan.nextLine().toUpperCase();
                System.out.println("Enter the number of books:");
                numBooks = scan.nextInt();
                scan.nextLine();

                books.addBook(title, author, isbn, numBooks);
            }
            if (choice == 2) {
                books.printAllBooks();
            }
            if (choice == 3) {
                System.out.println("Enter ISBN:");
                isbn = scan.nextLine();
                books.getBookInfo(isbn);
            }
        } while (choice != 4);
        db.closeConnection();
    }
}