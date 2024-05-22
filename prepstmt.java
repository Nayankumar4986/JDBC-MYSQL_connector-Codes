package database;

import java.sql.*;

public class prepstmt {

    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "kiit@mysql5946";
            // Creating a connection
            Connection con = DriverManager.getConnection(url, username, password);	      

            // Create a query
            String q = "INSERT INTO table1(tName, tCity) VALUES (?, ?)";

            // Get the prepared statement object
            PreparedStatement pstmt = con.prepareStatement(q);

            // Set values in the query for the first record
            pstmt.setString(1, "nayan kumar");
            pstmt.setString(2, "delhi");
            pstmt.executeUpdate(); // Execute the first insert

            // Set values in the query for the second record
            pstmt.setString(1, "rajashree deb");
            pstmt.setString(2, "kolkata");
            pstmt.executeUpdate(); // Execute the second insert

            System.out.println("Inserted successfully into table1");

            // Close the connection
            con.close();

            if (con.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection created....");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include the JDBC driver in your library path.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console");
            e.printStackTrace();
        }
    }
}
