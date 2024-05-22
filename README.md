# JDBC Project

This repository contains Java code examples demonstrating various JDBC (Java Database Connectivity) operations, such as connecting to a MySQL database, inserting data, updating data, fetching data, and displaying images stored in the database.

## Files

### 1. `ConnectionProvider.java`
This file provides a utility class for establishing a connection to the MySQL database. It includes the method `getConnection()` which returns a `Connection` object.

### 2. `Displayimg_FrmDB.java`
This file demonstrates how to fetch an image from the database using a user-provided image ID and display it in a JFrame. It uses a `JOptionPane` to prompt the user for the image ID and scales the image to a specified size before displaying it.

### 3. `FirstJDBC.java`
This file contains a basic example of connecting to a MySQL database and inserting an image into the database using a `PreparedStatement`.

### 4. `Show_table_data_frmDB.java`
This file demonstrates how to fetch and display data from a table in the database. It retrieves all records from `table1` and prints them to the console in a tabular format.

### 5. `Update_Table_data.java`
This file provides an example of updating records in a database table. It uses a `BufferedReader` to read user input from the console to update specific fields in `table1`.

### 6. `UserInput_Fetch_Img_DB.java`
This file shows how to fetch an image from the database based on a user-provided ID, similar to `Displayimg_FrmDB.java`, but with a focus on user input for the ID.

### 7. `imagesave_INDB.java`
This file demonstrates how to save an image into the database. It reads an image file from the filesystem and inserts it into the `images` table.

### 8. `insert_table_inDB.java`
This file contains an example of inserting data into a table in the database. It prompts the user for data via the console and inserts the data into `table1`.

### 9. `longimages_Filesize_Store_inDB.java`
This file provides an example of handling larger image files and storing them in the database, addressing potential issues with file size.

### 10. `prepstmt.java`
This file demonstrates the usage of `PreparedStatement` for executing SQL queries with parameters, ensuring safe and efficient database operations.

### 11. `scannerinput_from_table1.java`
This file uses `Scanner` to take user input from the console to insert multiple records into `table1` in the database.

## How to Use

1. **Set Up the Database:**
   - Ensure you have MySQL installed and running.
   - Create a database named `jdbc` and tables as per your requirements.
   - Update the database connection details (URL, username, password) in the code.

2. **Compile and Run:**
   - Compile the Java files using a Java compiler.
   - Run the main class files to execute the desired operations.

3. **Dependencies:**
   - Ensure you have the MySQL JDBC driver in your classpath.

## Contributing

If you have suggestions for improvements or new features, feel free to create a pull request or open an issue.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
