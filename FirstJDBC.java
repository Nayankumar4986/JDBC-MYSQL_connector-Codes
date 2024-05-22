package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class FirstJDBC {

  public static void main(String[] args) {
    try {
      // Load the driver:
      Class.forName("com.mysql.cj.jdbc.Driver");

      String url = "jdbc:mysql://localhost:3306/jdbc";
      String username = "root";
      String password = "kiit@mysql5946";

      // Creating a connection
      Connection con = DriverManager.getConnection(url, username, password);

      if (con.isClosed()) {
        System.out.println("Connection is closed");
      } else {
        System.out.println("Connection created....");
      }
    } catch (ClassNotFoundException e) {
      System.out.println(
        "MySQL JDBC Driver not found. Include the JDBC driver in your library path."
      );
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("Connection failed. Check output console");
      e.printStackTrace();
    }
  } 
}

