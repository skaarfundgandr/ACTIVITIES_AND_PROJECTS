package JAVA_SLMS_DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class Database {
    private Connection conn;
    private Statement statement;

    public Database() {
        try {
            Class.forName("org.sqlite.jdbc");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Books(Title string, Author string, ISBN string, NumBooks int)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users(Username string, Password string, UserType string)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS BorrowedBooks(Title string, Author string, ISBN string, NumBooks int)");
            System.out.println("Database connection succeeded");
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return this.conn;
    }
}