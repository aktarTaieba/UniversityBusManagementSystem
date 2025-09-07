package busmanagement;

import java.sql.*;

public class BusService {
    public static void addBus(String number, int capacity, int routeId) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO buses(bus_number, capacity, available_seats, route_id) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, number);
        ps.setInt(2, capacity);
        ps.setInt(3, capacity);
        ps.setInt(4, routeId);
        ps.executeUpdate();
        System.out.println("Bus Added!");
        con.close();
    }

    public static void editBus(int id, String newNumber) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE buses SET bus_number=? WHERE bus_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, newNumber);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("✏️ Bus Updated!");
        con.close();
    }

    public static void deleteBus(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM buses WHERE bus_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Bus Deleted!");
        con.close();
    }
}