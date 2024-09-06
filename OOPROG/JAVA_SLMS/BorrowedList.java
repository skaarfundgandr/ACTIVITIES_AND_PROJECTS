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
                }
                if (bookList.nextBook == null){
                    System.out.println("Book not found");
                    break;
                }
                bookList = bookList.nextBook;
            }
        }

        return this;
    }
    public BorrowedList returnBook(String isbn){
        Book currBook = book;
        Book prevBook = null;

        if (currBook.getISBN().equals(isbn)) {
            book = book.nextBook;
            return this;
        }
        while (currBook != null && !(book.getISBN().equals(isbn))) {
            prevBook = currBook;
            currBook = currBook.nextBook;
        }
        if (currBook != null) {
            prevBook.nextBook = currBook.nextBook;
        }

        return this;
    }
}