package JAVA_SLMS;

public class BorrowedList extends BookList{
    private Book book;
    private BookList list;

    public BorrowedList(BookList bookList){
        list = bookList;
        book = null;
    }
    
}