
package busmanagement;


import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/bus_management";
        String user = "root";   
        String pass = "";       
        return DriverManager.getConnection(url, user, pass);
    }
}