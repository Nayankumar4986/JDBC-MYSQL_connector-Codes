package database;


import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class insert_table_inDB {


	  public static void main(String[] args) {
	    try {
	      // Load the driver:
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      String url = "jdbc:mysql://localhost:3306/jdbc";
	      String username = "root";
	      String password = "kiit@mysql5946";
	      // Creating a connection
	      Connection con = DriverManager.getConnection(url, username, password);
	      
	      
	      
	      ///create a query
	      String q ="create table table1(tId int(20) primary key auto_increment, "
	      		+ "tName varchar(200) not null, tCity varchar(400))";
	      
	      //create a statement
	      Statement stmt= con.createStatement();
	           stmt.executeUpdate(q);  
	           System.out.println("Table created in a databases..");
	           con.close();
	           
	           

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
