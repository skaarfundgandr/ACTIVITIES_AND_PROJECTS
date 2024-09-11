package JAVA_SLMS_DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {
    ResultSet rs;
    Statement statement;
    PreparedStatement pStatement;
    private Connection conn;

    public UserDAO(Connection conn){
        try {
            this.conn = conn;
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addUser(String username, String password, String UserType){
        try {
            if (isUnique(username)) {
                String query = "INSERT INTO Users VALUES (?, ?, ?)";

                pStatement = conn.prepareStatement(query);
                pStatement.setString(1, username);
                pStatement.setString(2, password);
                pStatement.setString(3, UserType);
                
                if (pStatement.executeUpdate() > 0) {
                    System.out.println("User registered successfully");
                } else {
                    System.out.println("Registration failed");
                }
                statement.execute("CREATE TABLE IF NOT EXISTS " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private boolean isUnique(String username){
        try {
            rs = statement.executeQuery("SELECT * FROM Users WHERE username=" + username);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
