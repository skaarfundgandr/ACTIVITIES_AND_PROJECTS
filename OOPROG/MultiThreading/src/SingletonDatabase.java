import java.sql.*;

class Database {
    private static Database instance = null;
    private Connection conn;
    private Statement statement;

    private Database() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            statement = conn.createStatement();
            initializeDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database Instance() {
        if (instance == null) {
            synchronized(Database.class) {
                instance = new Database();
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return this.conn;
    }

    public synchronized boolean addEntry(String entry) {
        try {
            String query = "INSERT INTO test VALUES(?)";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, entry);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void displayTable() {
        try {
            ResultSet rsSet = statement.executeQuery("SELECT * FROM test");

            while (rsSet.next()) {
                System.out.println(rsSet.getString("mssg"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializeDatabase() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS test(mssg string)";

            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class SingletonDatabase {
    public static void main(String[] args) {
        Database db = Database.Instance();
        Database db2 = Database.Instance();

        System.out.println(db.hashCode());
        System.out.println(db2.hashCode());

        db.addEntry("abc123");

        db.displayTable();
    }
}
