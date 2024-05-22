package database;

import java.sql.*;
import java.util.Scanner;

public class scannerinput_from_table1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

            // Loop to insert multiple records
            while (true) {
                System.out.print("Enter name (or 'exit' to finish): ");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.print("Enter city: ");
                String city = scanner.nextLine();

                // Set values in the query
                pstmt.setString(1, name);
                pstmt.setString(2, city);
                pstmt.executeUpdate(); // Execute the insert

                System.out.println("Record inserted successfully into table1.");
            }

            // Close the resources
            pstmt.close();
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
        } finally {
            scanner.close();
        }
    }
}
