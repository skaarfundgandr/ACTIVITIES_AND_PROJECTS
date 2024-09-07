package JAVA_SLMS;

public class BorrowedList extends BookList{
    private Book book;

    public BorrowedList(){
        book = null;
    }
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
                    } else {
                        System.out.println("You can only borrow a book once!");
                    }
                }
                if (bookList.nextBook == null){
                    System.out.println("Book not found");
                    break;
                }
                bookList = bookList.nextBook;
            }
        }

        return this;
    }// TODO increment returned books' number on main booklist by 1
    public BorrowedList returnBook(String isbn){
        boolean returned = false;

        Book currBook = book;
        Book prevBook = null;

        if (currBook.getISBN().equals(isbn)) {
            book = book.nextBook;
            returned = true;
        }
        while (currBook != null && !(book.getISBN().equals(isbn))) {
            prevBook = currBook;
            currBook = currBook.nextBook;
        }
        if (currBook != null) {
            prevBook.nextBook = currBook.nextBook;
            returned = true;
        }
        if (currBook == null) {
           System.out.println("You have not borrowed this book"); 
        }
        if (returned) {
            System.out.println("Book returned");
        }

        return this;
    }
    // Method to display all borrowed books
    public void displayBook(){
        Book currBook = book;

        while (currBook != null) {
            System.out.println("Title: " + currBook.getTitle());
            System.out.println("Author: " + currBook.getAuthor());
            System.out.println("ISBN: " + currBook.getISBN());
            System.out.println();
            currBook = currBook.nextBook;
        }
    }
}