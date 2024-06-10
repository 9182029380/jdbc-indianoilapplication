package org.example.JDBC;

import java.sql.*;

public class Firstprogram {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://javatest.cf4gogm44l1y.us-east-1.rds.amazonaws.com:3306/students", "admin", "123456789")) {

            // Step 3: Create a statement
            Statement stmt = con.createStatement();

            // Step 4: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

            // Step 5: Process the results
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

            // Step 6: Close the connections (automatically handled by try-with-resources)


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
