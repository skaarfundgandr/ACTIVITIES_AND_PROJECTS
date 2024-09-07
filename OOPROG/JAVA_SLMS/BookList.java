package JAVA_SLMS;

public class BookList {
    private Book book;

    public BookList(){
        book = null;
    }
    public BookList addBook(String title, String author, String isbn, int numBooks){
        Book currBook = book;
        Book newBook = new Book();

        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setISBN(isbn);
        newBook.numBooks = numBooks;
        newBook.nextBook = null;

        if (book == null){
            book = newBook;
        } else {
            while (currBook.nextBook != null) {
                currBook = currBook.nextBook;
            }
            currBook.nextBook = newBook;
        }

        return this;
    }
    public void displayBook(String isbn){
        Book currBook = book;
        isbn = isbn.trim();

        while (currBook != null) {
            if (currBook.getISBN().equals(isbn)) {
                System.out.println("Title: " + currBook.getTitle());
                System.out.println("Author: " + currBook.getAuthor());
                System.out.println("ISBN: " + currBook.getISBN());
                System.out.println("Number of copies available: " + currBook.numBooks);
                System.out.println();

                break;
            }
            currBook = currBook.nextBook;
        }
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
    // Method to print all available books
    public void printAllBooks() {
        Book currBook = book;

        while (currBook != null) {
            System.out.println("Title: " + currBook.getTitle());
            System.out.println("Author: " + currBook.getAuthor());
            System.out.println("ISBN: " + currBook.getISBN());
            if (currBook.numBooks > 0) {
                System.out.println("Available");
            } else {
                System.out.println("Unavailable");
            }

            System.out.println();

            currBook = currBook.nextBook;
        }
    }
    public Book getBookList(){
        return this.book;
    }
}