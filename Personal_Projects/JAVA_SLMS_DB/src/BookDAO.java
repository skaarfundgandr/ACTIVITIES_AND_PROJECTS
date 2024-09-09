package JAVA_SLMS_DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDAO {
    ResultSet rs;
    Statement statement;
    PreparedStatement pStatement;
    private Connection conn;

    public BookDAO(Connection conn){
        try {
            this.conn = conn;
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addBook(String title, String author, String isbn, int numBooks){
        int rowsAffected;

        try {
            String query = "INSERT INTO Books VALUES (?, ?, ?, ?)";

            pStatement = conn.prepareStatement(query);
            pStatement.setString(1, title);
            pStatement.setString(2, author);
            pStatement.setString(3, isbn);
            pStatement.setInt(4, numBooks);

            rowsAffected = pStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book added successfully");
            } else {
                System.out.println("Failed to add book");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getBookInfo(String isbn){
        try {
            rs = statement.executeQuery("SELECT * FROM Books WHERE ISBN=" + isbn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public void printAllBooks(){
        try {
            rs = statement.executeQuery("SELECT * FROM Books");
            while (rs.next()) {
                System.out.println("Title: " + rs.getString("Title"));
                System.out.println("Author: " + rs.getString("Author"));
                System.out.println("ISBN: " + rs.getString("ISBN"));
                System.out.println("Number of books: " + rs.getInt("NumBooks"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
