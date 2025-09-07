package busmanagement;

import java.sql.*;

public class StudentService {
    public static void addStudent(String name,String department,String cardId, int routeId, int stopId) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO students(student_name, department, card_id, route_id, stop_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2,department);
        ps.setString(3, cardId);
        ps.setInt(4, routeId);
        ps.setInt(5, stopId);
        ps.executeUpdate();
        System.out.println("Student Added!");
        con.close();
    }

    public static void showStudents() throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT st.student_id, st.student_name, st.card_id, r.route_name, s.stop_name " +
                     "FROM students st JOIN stoppages s on s.stop_id=st.stop_id join routes r ON st.route_id = r.route_id";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        System.out.println("\n Students:");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("student_id") +
                    ", Name: " + rs.getString("student_name") +
                    ", Card: " + rs.getString("card_id") +
                    ", Route: " + rs.getString("route_name") +
                    ", Stop: " + rs.getString("stop_name"));
        }
        con.close();
    }

    public static void deleteStudent(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM students WHERE student_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Student Deleted!");
        con.close();
    }
}