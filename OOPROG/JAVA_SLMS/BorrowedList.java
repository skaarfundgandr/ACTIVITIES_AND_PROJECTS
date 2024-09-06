package JAVA_SLMS;

public class BorrowedList extends BookList{
    private Book books;

    public BorrowedList(){
        books = null;
    }
    public BorrowedList addBook(BookList list, String isbn){
        Book borrowedBook;
        Book bookList = list.getBookList();

        if (bookList == null) {
            System.out.println("No books are currently available");
        } else {
            while (bookList != null) {
                if (bookList.getISBN().equals(isbn)) {
                    borrowedBook = bookList;
                    borrowedBook.nextBook = null;
                    if (books == null) {
                        books = borrowedBook;
                    } else {
                        while (books.nextBook != null) {
                            books = books.nextBook;
                        }
                        books.nextBook = borrowedBook;
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
}