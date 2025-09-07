package busmanagement;

import java.sql.*;
import java.util.*;

public class SmartCardService {

    private static Map<Integer, List<StudentInfo>> busStudentMap = new HashMap<>();
    private static Set<String> scannedCards = new HashSet<>();

    public static void scanCard(String cardId) throws Exception {

        if (scannedCards.contains(cardId)) {
            System.out.println("Card ID " + cardId + " already scanned!");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT st.card_id, st.student_name, s.stop_name, b.bus_id, b.bus_number, " +
                            "b.available_seats, r.route_id " +
                            "FROM students st " +
                            "JOIN stoppages s on s.stop_id=st.stop_id " +
                            "JOIN routes r ON st.route_id = r.route_id " +
                            "JOIN buses b ON b.route_id = r.route_id " +
                            "WHERE st.card_id=?"
            );
            ps.setString(1, cardId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String student = rs.getString("student_name");
                String stop = rs.getString("stop_name");
                int busId = rs.getInt("bus_id");
                String busNumber = rs.getString("bus_number");
                int seats = rs.getInt("available_seats");
                int routeId = rs.getInt("route_id");

                if (seats > 0) {
                    System.out.println(student + " boarded Bus " + busNumber + " (Stop: " + stop + ")");
                    scannedCards.add(cardId);

                    StudentInfo sInfo = new StudentInfo(student, stop, busId, routeId, busNumber);
                    busStudentMap.putIfAbsent(busId, new ArrayList<>());
                    busStudentMap.get(busId).add(sInfo);

                    PreparedStatement update = con.prepareStatement(
                            "UPDATE buses SET available_seats=? WHERE bus_id=?"
                    );
                    update.setInt(1, seats - 1);
                    update.setInt(2, busId);
                    update.executeUpdate();

                } else {
                    System.out.println(" Bus " + busNumber + " is FULL!");
                }
            } else {
                System.out.println(" Invalid Card ID!");
            }
        }
    }

    public static void showScannedStudents() {
        System.out.println("\n--- Scanned Students ---");
        for (Integer busId : busStudentMap.keySet()) {
            System.out.println("Bus ID: " + busId);
            List<StudentInfo> students = busStudentMap.get(busId);
            for (StudentInfo s : students) {
                System.out.println("Student: " + s.name + ", Stop: " + s.stop);
            }
        }
    }

    public static void startBusJourney() throws Exception {
        for (Integer busId : busStudentMap.keySet()) {
            List<StudentInfo> students = busStudentMap.get(busId);
            if (students.isEmpty()) continue;

            int routeId = students.get(0).routeId;
            String busNumber = students.get(0).busNumber;

            System.out.println("\n=== Bus " + busNumber + " starting Route " + routeId + " ===");

            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement stopsQuery = con.prepareStatement(
                        "SELECT stop_name FROM stoppages WHERE route_id=? ORDER BY stop_id"
                );
                stopsQuery.setInt(1, routeId);
                ResultSet stops = stopsQuery.executeQuery();

                while (stops.next()) {
                    String currentStop = stops.getString("stop_name");
                    boolean stopHere = false;

                    for (StudentInfo s : students) {
                        if (s.stop.equalsIgnoreCase(currentStop)) {
                            System.out.println("STOP HERE at " + currentStop + " for " + s.name);
                            stopHere = true;
                        }
                    }

                    if (!stopHere) {
                        System.out.println("➡ Passing " + currentStop + " ... No student here.");
                    }

                    Thread.sleep(1000);
                }
            }

            System.out.println("=== Bus " + busNumber + " finished its journey ===\n");
        }

        busStudentMap.clear();
        scannedCards.clear();
    }

    static class StudentInfo {
        String name;
        String stop;
        int busId;
        int routeId;
        String busNumber;

        public StudentInfo(String name, String stop, int busId, int routeId, String busNumber) {
            this.name = name;
            this.stop = stop;
            this.busId = busId;
            this.routeId = routeId;
            this.busNumber = busNumber;
        }
    }
}