package bt6;

import java.sql.*;
import java.util.Scanner;
//DELIMITER //
//CREATE PROCEDURE calculateTotalSalaryByDept(
//        IN dept_id INT,
//        OUT total_salary DOUBLE
//)
//BEGIN
//SELECT SUM(salary) INTO total_salary
//FROM employee
//WHERE department_id = dept_id;
//
//IF total_salary IS NULL THEN
//SET total_salary = 0;
//END IF;
//END //

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Connection con = null;
        try {
            con = ConnectionDB.openConnection();
            calculateDepartmentSalary(con);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(con);
            scanner.close();
        }
    }

    public static void calculateDepartmentSalary(Connection con) throws SQLException {
        System.out.println("\nTÍNH TỔNG LƯƠNG THEO PHÒNG BAN");
        System.out.println("----------------------------------");
        System.out.print("Nhập ID phòng ban: ");
        int deptId = Integer.parseInt(scanner.nextLine());
        // Tham số thứ 2 là OUT parameter
        try (CallableStatement cstmt = con.prepareCall("{call calculateTotalSalaryByDept(?, ?)}")) {
            cstmt.setInt(1, deptId);
            cstmt.registerOutParameter(2, Types.DOUBLE);
            cstmt.execute();

            double totalSalary = cstmt.getDouble(2);

            System.out.printf("Tổng lương của phòng ban ID %d: %,.2f%n", deptId, totalSalary);
            System.out.println("----------------------------------");
        }
    }
}
