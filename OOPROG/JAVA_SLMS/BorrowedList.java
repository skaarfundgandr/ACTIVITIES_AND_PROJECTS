package JAVA_SLMS;

public class BorrowedList extends BookList{
    private Book book;

    public BorrowedList(){
        book = null;
    }
    // TODO Fix infinite loop if book is borrowed twice
    public BorrowedList addBook(BookList list, String isbn){
        Book borrowedBook = new Book();
        Book bookList = list.getBookList();

        if (bookList == null) {
            System.out.println("No books are currently available");
        } else {
            while (bookList != null) {
                if (bookList.getISBN().equals(isbn)) {
                    if (isUnique(isbn)){
                        --bookList.numBooks;
                        borrowedBook = bookList;
                        borrowedBook.nextBook = null;
                        if (book == null) {
                            book = borrowedBook;
                        } else {
                            while (book.nextBook != null) {
                                book = book.nextBook;
                            }
                            book.nextBook = borrowedBook;
                        }
                        break;
                    } else {
                        System.out.println("You can only borrow a book once!");
                    }
                }
                bookList = bookList.nextBook;
            }
            if (bookList == null) {
                System.out.println("Book not found");
            }
        }

        return this;
    }
    public BorrowedList returnBook(BookList mainList, String isbn){
        boolean returned = false;

        Book main = mainList.getBookList();
        Book currBook = book;
        Book prevBook = null;

        while (main != null) {
            if (main.getISBN().equals(isbn)) {
                break;
            }
            main = main.nextBook;
        }
        if (currBook.getISBN().equals(isbn) && book.nextBook == null) {
            book = null;
            returned = true;
        }
        else if (currBook.getISBN().equals(isbn) && book.nextBook != null) {
            book = book.nextBook;
            returned = true;
        }
        else {
            while (currBook != null && !(currBook.getISBN().equals(isbn))) {
            prevBook = currBook;
            currBook = currBook.nextBook;
            }
        }
        if (currBook != null && (returned == false)) {
            prevBook.nextBook = currBook.nextBook;
            returned = true;
        }
        if (currBook == null) {
           System.out.println("You have not borrowed this book"); 
        }
        if (returned) {
            ++main.numBooks;
            System.out.println("Book returned");
        }

        return this;
    }
    // Method to display all borrowed books
    public void displayBook(){
        Book currBook = book;

        if (currBook == null) {
            System.out.println("N/A\n");
        }
        while (currBook != null) {
            System.out.println("Title: " + currBook.getTitle());
            System.out.println("Author: " + currBook.getAuthor());
            System.out.println("ISBN: " + currBook.getISBN());
            System.out.println();
            currBook = currBook.nextBook;
        }
    }
}