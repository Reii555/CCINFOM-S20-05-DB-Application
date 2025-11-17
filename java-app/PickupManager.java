import java.sql.*;

public class PickupManager {
    public static boolean updatePickupStatus(int orderId, String newStatus){
        
        /*// test print for noooww...
        System.out.println("Updating order " + orderId + " to status: " + newStatus);
        return true;*/

        String sql = "UPDATE Pickups SET STATUS = ? HERE ORDER_ID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pStatement = conn.prepareStatement(sql)) {

            pstmt.setString(1, newStatus);  //puts "status" into the first "?" in the sql string
            pstmt.setInt(2, orderId);       //puts orderId into the second "?" in the sql string

            int affectedRows = pStatement.executeUpdate();

            return affectedRows > 0;        //if one or more rows were affected, return true

        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean completePickupWPayment(int orderId, String paymentMethod){
        String sql = "UPDATE Pickups SET STATUS = 'Completed', PAYMENT_METHOD = ? WHERE ORDER_ID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pStatement = conn.prepareStatement(sql)) {

            pstmt.setString(1, paymentMethod);
            pstmt.setInt(2, orderId);

            int affectedRows = pStatement.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
            return false;
        }
    }    

}
