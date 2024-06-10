package org.example.indianoil;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TruckService {

    public void logTruckArrival(String licensePlate, String driverName, String productType) {
        String sql = "INSERT INTO Trucks (license_plate, driver_name, product_type) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, licensePlate);
            pstmt.setString(2, driverName);
            pstmt.setString(3, productType);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void recordUnloading(int truckId, double quantity) {
        String sql = "UPDATE Trucks SET unloading_time = CURRENT_TIMESTAMP WHERE truck_id = ?";
        String sql2 = "INSERT INTO UnloadRecords (truck_id, product_type, quantity) SELECT truck_id, product_type, ? FROM Trucks WHERE truck_id = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt1 = conn.prepareStatement(sql);
             PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {

            pstmt1.setInt(1, truckId);
            pstmt1.executeUpdate();

            pstmt2.setDouble(1, quantity);
            pstmt2.setInt(2, truckId);
            pstmt2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

