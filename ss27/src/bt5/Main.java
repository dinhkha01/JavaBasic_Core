package bt5;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Connection con = null;
        try {
            con = ConnectionDB.openConnection();
            createTableAndInsert(con);
            searchEmployeesByName(con);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(con);
            scanner.close();
        }
    }

    public static void createTableAndInsert(Connection con) throws SQLException {
        // Tạo bảng department
        String createDeptSql = "CREATE TABLE IF NOT EXISTS department (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50))";

        // Tạo bảng employee
        String createEmpSql = "CREATE TABLE IF NOT EXISTS employee (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50), " +
                "salary DOUBLE, " +
                "department_id INT, " +
                "FOREIGN KEY (department_id) REFERENCES department(id))";

        try (Statement stmt = con.createStatement()) {

            stmt.executeUpdate(createDeptSql);
            stmt.executeUpdate(createEmpSql);


            stmt.executeUpdate("DELETE FROM employee");
            stmt.executeUpdate("DELETE FROM department");


            stmt.executeUpdate("INSERT INTO department (name) VALUES " +
                    "('IT'), ('HR'), ('Finance'), ('Marketing')");


            ResultSet rs = stmt.executeQuery("SELECT id FROM department ORDER BY id");
            int[] deptIds = new int[4];
            int i = 0;
            while (rs.next()) {
                deptIds[i++] = rs.getInt(1);
            }


            stmt.executeUpdate("INSERT INTO employee (name, salary, department_id) VALUES " +
                    "('Kha', 5000, " + deptIds[0] + "), " +
                    "('Hao', 6000, " + deptIds[1] + "), " +
                    "('Tam Anh', 5500, " + deptIds[0] + "), " +
                    "('Thuan', 6500, " + deptIds[2] + ")");

            System.out.println("Đã tạo bảng và thêm dữ liệu mẫu thành công!");
        }
    }

    public static void searchEmployeesByName(Connection con) throws SQLException {
        System.out.println("\nTÌM KIẾM NHÂN VIÊN THEO TÊN");
        System.out.println("----------------------------------");

        System.out.print("Nhập tên nhân viên (có thể nhập một phần tên): ");
        String name = scanner.nextLine().trim();

        String sql = "SELECT e.id, e.name, e.salary, d.name AS dept_name " +
                "FROM employee e LEFT JOIN department d ON e.department_id = d.id " +
                "WHERE e.name LIKE ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1,name );


            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("\nKẾT QUẢ TÌM KIẾM");
                boolean hasResult = false;
                while (rs.next()) {
                    hasResult = true;
                    System.out.printf("%-5d %-20s %,-10.2f %-15s%n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("salary"),
                            rs.getString("dept_name"));
                }

                if (!hasResult) {
                    System.out.println("Không tìm thấy nhân viên phù hợp!");
                }
            }
        }
    }
}