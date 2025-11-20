import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/delivery_pickup_db??useSSL=false&allowPublicKeyRetrieval=true"; //replace whoever will make da db server
        String username = "root";       //replace whoever will make da db server
        String password = "haisqluserhehehehe11)";   //replace with ur workbench pass

        return DriverManager.getConnection(url, username, password);
    }
}

