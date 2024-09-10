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
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Books(Title string, Author string, ISBN string, NumBooks int)");
            statement.execute("CREATE TABLE IF NOT EXISTS Users(Username string, Password string, UserType string)");
            System.out.println("Database connection succeeded\n");
        } catch (SQLException e) {
            System.err.println("\nDatabase connection failed");
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return this.conn;
    }
    public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}