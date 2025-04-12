package bt7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
            // Mở kết nối đến database my_db_7
            con = ConnectionDB.openConnection();

            // Tạo bảng departments và employees
            createTables(con);

            // Thêm dữ liệu mẫu
            insertSampleData(con);

            // Thực hiện truy vấn JOIN và hiển thị kết quả
            displayEmployeeDepartmentInfo(con);

        } catch (SQLException e) {
            System.err.println("Lỗi database: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (con != null) {
                ConnectionDB.closeConnection(con);
            }
        }
    }

    private static void createTables(Connection con) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS departments (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "location VARCHAR(50))");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employees (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "department_id INT, " +
                    "salary DOUBLE, " +
                    "FOREIGN KEY (department_id) REFERENCES departments(id))");
            System.out.println("Đã tạo bảng departments và employees thành công!");
        }
    }

    private static void insertSampleData(Connection con) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate("DELETE FROM employees");
            stmt.executeUpdate("DELETE FROM departments");
            stmt.executeUpdate("INSERT INTO departments(name, location) VALUES " +
                    "('IT', 'Hà Nội'), " +
                    "('Kế toán', 'Hồ Chí Minh'), " +
                    "('Nhân sự', 'Đà Nẵng'), " +
                    "('Kinh doanh', 'Hải Phòng'), " +
                    "('Marketing', 'Cần Thơ')");
            int rows = stmt.executeUpdate("INSERT INTO employees(name, department_id, salary) VALUES " +
                    "('Nguyễn Văn An', 1, 15000000), " +
                    "('Trần Thị Bình', 1, 18000000), " +
                    "('Lê Văn Cường', 2, 12000000), " +
                    "('Phạm Thị Dung', 3, 20000000), " +
                    "('Hoàng Văn Em', 4, 17000000), " +
                    "('Vũ Thị Phương', 2, 13000000), " +
                    "('Đặng Văn Giang', 1, 22000000), " +
                    "('Bùi Thị Hương', 5, 16000000)");
            System.out.println("Đã thêm " + rows + " bản ghi mẫu vào bảng employees\n");
        }
    }

    private static void displayEmployeeDepartmentInfo(Connection con) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(
                    "SELECT e.name AS employee_name, " +
                            "d.name AS department_name, " +
                            "d.location, " +
                            "e.salary " +
                            "FROM employees e " +
                            "JOIN departments d ON e.department_id = d.id " );
            System.out.println("Danh sách nhân viên và thông tin phòng ban:");
            System.out.println("------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("Employee: %s, Department: %s, Location: %s, Salary: %,.2f\n",
                        rs.getString("employee_name"),
                        rs.getString("department_name"),
                        rs.getString("location"),
                        rs.getDouble("salary"));
            }

            System.out.println("------------------------------------------------------------");
        }
    }
}