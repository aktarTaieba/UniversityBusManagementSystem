package busmanagement;

import java.sql.*;

public class RouteService {
    public static void addRoute(String name) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO routes(route_name) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.executeUpdate();
        System.out.println("Route Added!");
        con.close();
    }

    public static void editRoute(int id, String newName) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE routes SET route_name=? WHERE route_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, newName);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("✏️ Route Updated!");
        con.close();
    }

    public static void deleteRoute(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM routes WHERE route_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Route Deleted!");
        con.close();
    }
}