package JAVA_SLMS;

public class Book {
    private String author;
    private String title;
    private String isbn;
    public int numBooks;
    public Book nextBook;

    
    public void setAuthor(String str){
        author = str;
    }
    public void setTitle(String str){
        title = str;
    }
    public void setISBN(String str){
        isbn = str;
    }

    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }
    public String getISBN(){
        return isbn;
    }
}