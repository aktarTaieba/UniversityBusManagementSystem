
package busmanagement;

import java.sql.*;

public class DriverService {

    public static void registerDriver(String name, String license, String phone, int busId) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO drivers(driver_name, license_number, phone, assigned_bus) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, license);
        ps.setString(3, phone);
        ps.setInt(4, busId);
        ps.executeUpdate();
        System.out.println("Driver Registered!");
        con.close();
    }

    public static void viewDrivers() throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM drivers";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("-- Driver List --");
        while (rs.next()) {
            System.out.println(
                "ID: " + rs.getInt("driver_id") +
                ", Name: " + rs.getString("driver_name") +
                ", License: " + rs.getString("license_number") +
                ", Phone: " + rs.getString("phone") +
                ", Assigned Bus: " + rs.getInt("assigned_bus")
            );
        }
        con.close();
    }

    public static void updateDriver(int id, String name, String license, String phone, int busId) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE drivers SET driver_name=?, license_number=?, phone=?, assigned_bus=? WHERE driver_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, license);
        ps.setString(3, phone);
        ps.setInt(4, busId);
        ps.setInt(5, id);
        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Driver Updated!");
        } else {
            System.out.println("No driver found with ID: " + id);
        }
        con.close();
    }

    public static void deleteDriver(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM drivers WHERE driver_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Driver Deleted!");
        } else {
            System.out.println("No driver found with ID: " + id);
        }
        con.close();
    }
}