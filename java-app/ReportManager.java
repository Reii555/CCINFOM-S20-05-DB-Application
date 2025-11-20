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

       // CustomerOrdersReport
    public static List<CustomerOrdersReport> getCustomerOrdersReport(int year, int month) {
    List<CustomerOrdersReport> reportList = new ArrayList<>();

    String sql = "SELECT c.customer_id, " +
                 "CONCAT(c.customer_lastname, ', ', c.customer_firstname) AS CustomerName, " +
                 "COUNT(DISTINCT d.delivery_id) AS Deliveries, " +
                 "COUNT(DISTINCT p.order_id) AS Pickups, " +
                 "SUM(CASE WHEN d.payment IS NOT NULL " +
                 "         THEN CAST(d.payment AS DECIMAL(10,2)) + d.delivery_fee ELSE 0 END) AS TotalTransactionAmount " +
                 "FROM customers c " +
                 "LEFT JOIN deliveries d ON c.customer_id = d.customer_id " +
                 "AND YEAR(d.delivery_date) = ? AND MONTH(d.delivery_date) = ? " +
                 "LEFT JOIN pickups p ON c.customer_id = p.customer_id " +
                 "GROUP BY c.customer_id, c.customer_lastname " +
                 "ORDER BY CustomerName ASC";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, year);
        stmt.setInt(2, month);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CustomerOrdersReport report = new CustomerOrdersReport(
                    rs.getInt("customer_id"),
                    rs.getString("CustomerName"),
                    rs.getInt("Deliveries"),
                    rs.getInt("Pickups"),
                    rs.getDouble("TotalTransactionAmount")
                );
                reportList.add(report);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return reportList;
}

}

