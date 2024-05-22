package database;

import java.sql.*;
import java.io.*;

public class Update_Table_data {

    public static void main(String[] args) {
        try {
            // Establishing connection:
            Connection con = ConnectionProvider.getConnection();

            // Update query:
            String q = "UPDATE table1 SET tName=?, tCity=? WHERE tId=?";

            // Reading user input:
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter new name: ");
            String name = br.readLine();
            System.out.println("Enter new city name: ");
            String city = br.readLine();
            System.out.println("Enter the student id: ");
            int id = Integer.parseInt(br.readLine());

            // Creating PreparedStatement:
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.setInt(3, id);

            // Executing update:
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("No data found for the provided student id.");
            }

            // Closing resources:
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console.");
            e.printStackTrace();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading user input.");
            e.printStackTrace();
        }
    }
}
