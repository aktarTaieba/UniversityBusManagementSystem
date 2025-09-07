package busmanagement;

import java.sql.*;

public class StoppageService {
    public static void addStoppage(int routeId, String stopName) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO stoppages(route_id, stop_name) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, routeId);
        ps.setString(2, stopName);
        ps.executeUpdate();
        System.out.println("Stoppage Added!");
        con.close();
    }
}