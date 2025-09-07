package busmanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            
            System.out.println("1. Add Route");
            System.out.println("2. Edit Route");
            System.out.println("3. Delete Route");
            System.out.println("4. Add Stoppage");
            System.out.println("5. Add Bus");
            System.out.println("6. Edit Bus");
            System.out.println("7. Delete Bus");
            System.out.println("8. Register Driver");
            System.out.println("9. View Drivers");
            System.out.println("10. Delete Driver");
            System.out.println("11. Add Student");
            System.out.println("12. View Students");
            System.out.println("13. Delete Student");
            System.out.println("14. Smart Card Scan");
            System.out.println("15. Start Journey");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Choose Option: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> { System.out.print("Route Name: "); RouteService.addRoute(sc.nextLine()); }
                case 2 -> { System.out.print("Route ID: "); int id=sc.nextInt(); sc.nextLine(); System.out.print("New Name: "); RouteService.editRoute(id, sc.nextLine()); }
                case 3 -> { System.out.print("Route ID: "); RouteService.deleteRoute(sc.nextInt()); }
                case 4 -> { System.out.print("Route ID: "); int rid=sc.nextInt(); sc.nextLine(); System.out.print("Stop Name: "); StoppageService.addStoppage(rid, sc.nextLine()); }
                case 5 -> { System.out.print("Bus Number: "); String b=sc.nextLine(); System.out.print("Capacity: "); int cap=sc.nextInt(); System.out.print("Route ID: "); int r=sc.nextInt(); BusService.addBus(b,cap,r); }
                case 6 -> { System.out.print("Bus ID: "); int bid=sc.nextInt(); sc.nextLine(); System.out.print("New Number: "); BusService.editBus(bid, sc.nextLine()); }
                case 7 -> { System.out.print("Bus ID: "); BusService.deleteBus(sc.nextInt()); }
                case 8 -> {
                    System.out.print("Driver Name: ");
                    String dn = sc.nextLine();
                    System.out.print("License: ");
                    String l = sc.nextLine();
                    System.out.print("Phone: ");
                    String p = sc.nextLine();
                    System.out.print("Bus ID: ");
                    int b = sc.nextInt();
                    DriverService.registerDriver(dn, l, p, b);
                }
                case 9 -> {
                    DriverService.viewDrivers();
                }
                case 10 -> {
                    System.out.print("Driver ID: ");
                    DriverService.deleteDriver(sc.nextInt());
                }
                case 11 -> { System.out.print("Student Name: ");String sn=sc.nextLine();System.out.print("Department: ");String sd=sc.nextLine(); System.out.print("Card ID: "); String c=sc.nextLine(); System.out.print("Route ID: "); int r=sc.nextInt(); sc.nextLine(); System.out.print("Stop ID: ");int si = sc.nextInt();;StudentService.addStudent(sn,sd,c,r,si); }
                case 12 -> StudentService.showStudents();
                case 13 -> { System.out.print("Student ID: "); StudentService.deleteStudent(sc.nextInt()); }
                case 14 -> {
                            System.out.println("\n-- Student Card Scanning --");
                            System.out.print("Enter Card ID: ");
                            String cardId = sc.nextLine();
                            SmartCardService.scanCard(cardId); 
                            System.out.println("Card scanned successfully!");
                            
                            SmartCardService.showScannedStudents();
                }
                case 15 -> {
                            System.out.println("\n --Starting Bus Journey--");
                            SmartCardService.startBusJourney();
               }
                
                case 0 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid Option!");
               
            }
    
        }
    }
}