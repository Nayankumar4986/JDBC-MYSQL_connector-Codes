package database;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Image;

public class UserInput_Fetch_Img_DB extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserInput_Fetch_Img_DB frame = new UserInput_Fetch_Img_DB();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public UserInput_Fetch_Img_DB() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Fetch image from database and display
        fetchAndDisplayImage();
    }

    /**
     * Fetch image from database and display it.
     */
    private void fetchAndDisplayImage() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Get image ID from user input
            String input = JOptionPane.showInputDialog(this, "Enter Image ID:");
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid ID entered. Exiting.");
                return;
            }
            int imageId = Integer.parseInt(input.trim());

            // Establishing connection:
            con = ConnectionProvider.getConnection();

            // Prepare SQL query
            String query = "SELECT pic FROM images WHERE id = ?";

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, imageId); // Set image ID from user input

            // Execute query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Retrieve image data from ResultSet
                byte[] imageData = rs.getBytes("pic");

                // Convert byte array to BufferedImage
                ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
                BufferedImage image = ImageIO.read(bis);

                // Scale the image to the desired size
                int scaledWidth = 200;  // Desired width
                int scaledHeight = 200; // Desired height
                Image scaledImage = image.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

                // Display scaled image on JLabel
                JLabel lblImage = new JLabel(new ImageIcon(scaledImage));
                lblImage.setBounds(10, 10, scaledWidth, scaledHeight);
                contentPane.add(lblImage);
                contentPane.revalidate();
                contentPane.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "No image found with ID: " + imageId);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID format. Please enter a numeric ID.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
