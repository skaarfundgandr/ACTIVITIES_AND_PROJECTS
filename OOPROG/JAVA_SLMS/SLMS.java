package JAVA_SLMS;
import java.util.Scanner;

public class SLMS {
    public static void main(String[] args) {
        boolean loggedIn = false;
        int choice = 0, attempts = 0, numBooks;
        String title, author, isbn, input = "", username = "", password, userType;
        BorrowedList borrowedBooks;

        Scanner scan =  new Scanner(System.in);
        BookList list = new BookList();
        Accounts acc = new Accounts();
        
        do {
            try { // TODO Rework output
                if (loggedIn == false){
                    System.out.println("Login or Register? (press q to quit)");
                    input = scan.nextLine().toLowerCase();
                    if (input.equals("register")) {
                        System.out.print("Username: ");
                        username = scan.nextLine();
                        System.out.print("Password: ");
                        password = scan.nextLine();
                        System.out.print("Enter user type (User or Librarian): ");
                        userType = scan.nextLine().toLowerCase();

                        acc.addUser(username, password, userType);
                        loggedIn = acc.login(username, password);
                    }
                    if (input.equals("login")) {
                        System.out.print("Username: ");
                        username = scan.nextLine();
                        System.out.print("Password: ");
                        password = scan.nextLine();

                        loggedIn = acc.login(username, password);
                    }
                } // TODO Improve output
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
                            isbn = scan.nextLine().toUpperCase();
                            System.out.println("Enter the number of books");
                            numBooks = scan.nextInt();
                            // TODO Improve handling of this block
                            if (list.isUnique(isbn))
                                list = list.addBook(title, author, isbn, numBooks);
                            else{
                                System.out.println("Duplicate ISBN detected!");
                            }

                            System.out.println("Book successfully added");

                            break;
                        case 2:
                            System.out.println("Enter the ISBN of the book");
                            isbn = scan.nextLine();

                            list.displayBook(isbn);
                            break;
                        case 3:
                            System.out.println("Thank you for using our SLMS exiting...");
                            loggedIn = false;
                            break;
                        default:
                            System.out.println("Invalid choice! attempt " + (attempts + 1) + "of 3");
                            break;
                        }
                    } // TODO Improve outputs for user
                    if (loggedIn && acc.getUserType(username).equals("user")) {
                        System.out.println("1. Display all books");
                        System.out.println("2. Display borrowed books");
                        System.out.println("3. Borrow a book");
                        System.out.println("4. Return a book");
                        System.out.println("5. Exit");
                        System.out.print("Enter your choice: ");
                        choice = scan.nextInt();
                        scan.nextLine(); // Clear input buffer
                        switch (choice) {
                            case 1:
                                list.printAllBooks();
                                break;
                            case 2:
                                borrowedBooks = acc.getBorrowedList(username);
                                borrowedBooks.displayBook();
                                break;
                            case 3:
                                System.out.println("Enter the ISBN of the book that you would like to borrow:");
                                isbn = scan.nextLine();

                                borrowedBooks = acc.getBorrowedList(username);
                                borrowedBooks.addBook(list, isbn);
                                
                                break;
                            case 4:
                                System.out.println("Enter the ISBN of the book that you would like to return");
                                isbn = scan.nextLine();

                                borrowedBooks = acc.getBorrowedList(username);
                                borrowedBooks.returnBook(isbn);
                                
                                break;
                            case 5:
                                System.out.println("Thank you for using our SLMS");
                                loggedIn = false;
                                break;
                            default:
                                break;
                        }
                    }
                }
            catch (Exception e) { // TODO Write better error handling
                System.out.println("Invalid choice! attempt " + (attempts + 1) + " of 3");
                ++attempts;
                scan.nextLine(); // Clear input buffer
            }
        } while (!(input.equals("q")) && attempts < 3);
    }
}