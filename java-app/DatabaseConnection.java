import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydatabase"; //replace whoever will make da db server
        String username = "root";       //replace whoever will make da db server
        String password = "password";   //replace whoever will make da db server

        return DriverManager.getConnection(url, username, password);
    }
}
