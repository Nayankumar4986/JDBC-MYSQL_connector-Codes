package database;

import java.sql.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class longimages_Filesize_Store_inDB {

    public static void main(String[] args) {
        try {
            // Load the driver:
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "kiit@mysql5946";
            
            // Using JFileChooser to select the image file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose an image file");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "png", "jpeg", "gif"));

            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                
                // Creating a connection
                try (Connection con = DriverManager.getConnection(url, username, password);
                     FileInputStream fis = new FileInputStream(selectedFile)) {
                    
                    // Create a query
                    String q = "INSERT INTO images(pic) VALUES(?)";
                    try (PreparedStatement pstmt = con.prepareStatement(q)) {
                        // Set the binary stream for the file input
                        pstmt.setBinaryStream(1, fis, fis.available());
                        
                        // Execute the update
                        pstmt.executeUpdate();
                        
                        System.out.println("Image inserted successfully into the database.");
                    }
                    
                    if (con.isClosed()) {
                        System.out.println("Connection is closed");
                    } else {
                        System.out.println("Connection created....");
                    }
                } catch (SQLException e) {
                    System.out.println("Connection failed. Check output console");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.println("File input error");
                    e.printStackTrace();
                }
            } else {
                System.out.println("File selection cancelled by user.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include the JDBC driver in your library path.");
            e.printStackTrace();
        }
    }
}
