import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // PASTE YOUR SUPABASE DATABASE URL, USER, AND PASSWORD HERE:
    private static final String URL = "postgresql://postgres:8wlWNkL8AefkTINF@db.zmtbnapxyxkktajtzjxc.supabase.co:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "8wlWNkL8AefkTINF";

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Supabase PostgreSQL successfully!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}
