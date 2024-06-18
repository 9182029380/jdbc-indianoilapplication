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
                "jdbc:mysql://localhost:3306/studentdatabase", "root", "root")) {

            // Step 3: Create a statement
            Statement stmt = con.createStatement();

            // Step 4: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM studentsinfo");

            // Step 5: Process the results
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " +
                        rs.getString(2)+ " " + rs.getString(3)+ " "+ rs.getString(4));
            }

            // Step 6: Close the connections (automatically handled by try-with-resources)


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
