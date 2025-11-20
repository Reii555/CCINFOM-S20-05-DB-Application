import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ReportManager {

    public static List<CustomerPreferenceReport> getCustomerPreferences() {
        List<CustomerPreferenceReport> reportList = new ArrayList<>();

        String sql = "SELECT c.CUSTOMER_ID, c.CUSTOMER_FIRSTNAME, c.CUSTOMER_LASTNAME, " +
                     "(SELECT COUNT(*) FROM Deliveries d WHERE d.CUSTOMER_ID = c.CUSTOMER_ID) AS Delivery_Count, " +
                     "(SELECT COUNT(*) FROM Pickups p WHERE p.CUSTOMER_ID = c.CUSTOMER_ID) AS Pickup_Count, " +
                     "CASE WHEN (SELECT COUNT(*) FROM Deliveries d WHERE d.CUSTOMER_ID = c.CUSTOMER_ID) > " +
                     "(SELECT COUNT(*) FROM Pickups p WHERE p.CUSTOMER_ID = c.CUSTOMER_ID) " +
                     "THEN 'Delivery' ELSE 'Pickup' END AS Preferred_Method " +
                     "FROM Customers c ORDER BY c.CUSTOMER_ID";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CustomerPreferenceReport report = new CustomerPreferenceReport(
                    rs.getInt("CUSTOMER_ID"),
                    rs.getString("CUSTOMER_FIRSTNAME"),
                    rs.getString("CUSTOMER_LASTNAME"),
                    rs.getInt("Delivery_Count"),
                    rs.getInt("Pickup_Count"),
                    rs.getString("Preferred_Method")
                );
                reportList.add(report);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reportList;
    }
}
