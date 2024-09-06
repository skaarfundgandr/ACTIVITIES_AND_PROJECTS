package JAVA_SLMS;
import java.util.Scanner;

public class SLMS {
    public static void main(String[] args) {
        boolean loggedIn = false;
        int choice = 0, attempts = 0, numBooks;
        String title, author, isbn, input, username = "", password, userType;

        Scanner scan =  new Scanner(System.in);
        BookList list = new BookList();
        Accounts acc = new Accounts();
        
        do {
            try { // TODO Rework output and add accounts
                System.out.println("Login or Register?");
                input = scan.nextLine();
                if (input.equalsIgnoreCase("register")) {
                    System.out.print("Username: ");
                    username = scan.nextLine();
                    System.out.print("Password: ");
                    password = scan.nextLine();
                    System.out.print("Enter user type (User or Librarian): ");
                    userType = scan.nextLine().toLowerCase();

                    acc.addUser(username, password, userType);
                    loggedIn = acc.login(username, password);
                }
                if (input.equalsIgnoreCase("login")) {
                    System.out.print("Username: ");
                    username = scan.nextLine();
                    System.out.print("Password: ");
                    password = scan.nextLine();

                    loggedIn = acc.login(username, password);
                }
                if (loggedIn && acc.getUserType(username).equals("librarian")) {
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
                            // TODO Improve handling of this block
                            if (list.isUnique(isbn))
                                list = list.addBook(title, author, isbn, numBooks);
                            else{
                                System.out.println("Duplicate isbn detected!");
                            }

                            System.out.println("Book successfully added");

                            break;
                        case 2:
                            System.out.println("Enter the isbn of the book");
                            isbn = scan.nextLine();

                            list.displayBook(isbn);
                            break;
                        case 3:
                            System.out.println("Thank you for using our SLMS exiting...");
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid choice");
                ++attempts;
                scan.nextLine(); // Clear input buffer
            }
        } while (choice != 3 && attempts < 3);
    }
}