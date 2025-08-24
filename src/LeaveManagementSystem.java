import java.sql.*;
import java.util.Scanner;

public class LeaveManagementSystem {
    static final String DB_URL = "jdbc:mysql://localhost:3306/leavedb";
    static final String USER = "root";
    static final String PASS = "Jayasri@2005";

    public static void main(String[] args) {
        // JDBC code for connecting, inserting, fetching, etc.
        try {
            // 1. Connect to Database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            Scanner sc = new Scanner(System.in);

            System.out.println("1. Add Employee");
            System.out.println("2. Apply Leave");
            System.out.println("3. View Leaves");
            int choice = sc.nextInt();

            switch(choice) {
                case 1: // Add Employee
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter department: ");
                    String dept = sc.next();
                    String sqlInsert = "INSERT INTO employees(name, department) VALUES('" + name + "', '" + dept + "')";
                    stmt.executeUpdate(sqlInsert);
                    System.out.println("Employee added!");
                    break;

                case 2: // Apply Leave
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    System.out.print("Enter Leave Date (YYYY-MM-DD): ");
                    String date = sc.next();
                    System.out.print("Enter Reason: ");
                    String reason = sc.next();
                    String sqlLeave = "INSERT INTO leave_requests(emp_id, leave_date, reason) VALUES(" + empId + ", '" + date + "', '" + reason + "')";
                    stmt.executeUpdate(sqlLeave);
                    System.out.println("Leave applied!");
                    break;

                case 3: // View Leaves
                    ResultSet rs = stmt.executeQuery("SELECT * FROM leave_requests");
                    while(rs.next()) {
                        System.out.println("LeaveID: " + rs.getInt("leave_id") +
                                ", EmpID: " + rs.getInt("emp_id") +
                                ", Date: " + rs.getDate("leave_date") +
                                ", Reason: " + rs.getString("reason"));
                    }
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            // 2. Close connection
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

