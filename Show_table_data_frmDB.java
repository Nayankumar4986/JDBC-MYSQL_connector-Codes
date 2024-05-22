package database;

import java.sql.*;

public class Show_table_data_frmDB {

    public static void main(String[] args) {
        try {
            // Load the driver
        	// Establishing connection:
            Connection con = ConnectionProvider.getConnection();

            // Create a query
            String query = "SELECT * FROM table1";
 
            // Create a statement
            Statement stmt = con.createStatement();
 
            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery(query);

            // Print the table data with proper formatting
            System.out.println("Data from table1:");
            System.out.printf("%-5s %-15s %-15s%n", "ID", "Name", "City");
            System.out.println("-------------------------------");
            while (rs.next()) {
                int id = rs.getInt("tId");
                String name = rs.getString("tName");
                String city = rs.getString("tCity");
                System.out.printf("%-5d %-15s %-15s%n", id, name, city);
            }

            // Close the resources
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console");
            e.printStackTrace();
        }
    }
}
