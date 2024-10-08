package JAVA_SLMS;

public class BorrowedList extends BookList{
    private Book book;

    public BorrowedList(){
        book = null;
    }
    public BorrowedList addBook(BookList list, String isbn){
        Book borrowedBook = new Book();
        Book bookList;
        
        Book currBook = this.book;
        bookList = list.getBookList();

        if (bookList == null) {
            System.out.println("No books are currently available");
        } else {
            while (bookList != null) {
                if (bookList.getISBN().equals(isbn)) {
                    if (isUnique(isbn) && bookList.numBooks > 0){
                        borrowedBook.setTitle(bookList.getTitle());
                        borrowedBook.setAuthor(bookList.getAuthor());
                        borrowedBook.setISBN(bookList.getISBN());
                        borrowedBook.nextBook = null;
                        --bookList.numBooks;
                        if (this.book == null) {
                            this.book = borrowedBook;
                        } else {
                            while (currBook.nextBook != null) {
                                currBook = currBook.nextBook;
                            }
                            currBook.nextBook = borrowedBook;
                        }
                        System.out.println("Book successfully borrowed");
                        break;
                    } else if (bookList.numBooks < 1){
                        System.out.println("Book is currently unavailable");
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
    public boolean isUnique(String isbn){
        Book currBook = this.book;
        isbn = isbn.trim();

        while (currBook != null) {
            if (currBook.getISBN().equals(isbn))
                return false;
            currBook = currBook.nextBook;
        }
        return true;
    }
    // Method to display all borrowed books
    public void displayBook(){
        Book currBook = this.book;

        if (currBook == null) {
            System.out.println("N/A\n");
        }
        while (currBook != null) {
            System.out.println("\nTitle: " + currBook.getTitle());
            System.out.println("Author: " + currBook.getAuthor());
            System.out.println("ISBN: " + currBook.getISBN());
            System.out.println();
            currBook = currBook.nextBook;
        }
    }
}