package ACTIVITIES_AND_PROJECTS.OOPROG.JAVA_SLMS;

public class BookList {
    private Book book;

    public BookList(){
        book = null;
    }
    public BookList addBook(String title, String author, String isbn, int numBooks){
        Book newBook;

        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setISBN(isbn);
        newBook.numBooks = numBooks;
        newBook.nextBook = null;

        if (book == null){
            book = newBook;
        } else {
            while (book.nextBook != null) {
                book = book.nextBook;
            }
            book.nextBook = newBook;
        }

        return this;
    }
    public void displayBook(String isbn){
        String currIsbn = isbn.trim();

        while (book != null) {
            if (book.getISBN().equals(currIsbn)) {
                System.out.println(book.getTitle());
                System.out.println(book.getAuthor());
                System.out.println(book.getISBN());
                System.out.println("Number of copies available: " + book.numBooks);

                break;
            }
        }
    }
}