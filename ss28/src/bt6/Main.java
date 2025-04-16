package bt6;

import bt6.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MENU:");
        System.out.println("1. Khởi tạo cơ sở dữ liệu và thêm dữ liệu mẫu");
        System.out.println("2. Tạo phòng ban mới và thêm nhân viên");
        System.out.print("Chọn tùy chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            setupDatabase();
        } else if (choice == 2) {
            createNewDepartmentWithEmployees();
        } else {
            System.out.println("Tùy chọn không hợp lệ!");
        }
    }

    private static void createNewDepartmentWithEmployees() {
        Connection con = null;
        try {
            con = ConnectionDB.openConnection();

            // Bắt đầu giao dịch
            con.setAutoCommit(false);

            // Thêm phòng ban mới
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập tên phòng ban mới:");
            String departmentName = scanner.nextLine();

            String insertDepartmentSQL = "INSERT INTO Departments (name) VALUES (?)";
            PreparedStatement deptStmt = con.prepareStatement(insertDepartmentSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            deptStmt.setString(1, departmentName);
            deptStmt.executeUpdate();

            // Lấy ID của phòng ban vừa tạo
            int departmentId;
            var generatedKeys = deptStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                departmentId = generatedKeys.getInt(1);
                System.out.println("Phòng ban mới đã được tạo với ID: " + departmentId);
            } else {
                throw new SQLException("Không thể lấy được ID của phòng ban vừa tạo");
            }

            // Thêm nhân viên thuộc phòng ban đó
            String insertEmployeeSQL = "INSERT INTO Employees (name, department_id) VALUES (?, ?)";
            PreparedStatement empStmt = con.prepareStatement(insertEmployeeSQL);

            System.out.println("Bạn muốn thêm bao nhiêu nhân viên vào phòng ban này?");
            int employeeCount = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng mới

            for (int i = 0; i < employeeCount; i++) {
                System.out.println("Nhập tên nhân viên #" + (i+1) + ":");
                String employeeName = scanner.nextLine();

                empStmt.setString(1, employeeName);
                empStmt.setInt(2, departmentId);
                empStmt.addBatch();
            }

            // Thực thi tất cả các lệnh insert nhân viên cùng một lúc
            empStmt.executeBatch();

            // Nếu không có lỗi xảy ra, thực hiện commit giao dịch
            con.commit();
            System.out.println("Tạo phònh ban thành công!");

        } catch (SQLException e) {
            // Nếu có lỗi xảy ra, rollback giao dịch
            if (con != null) {
                try {
                    System.err.println(" đang được rollback. Lý do: " + e.getMessage());
                    con.rollback();
                } catch (SQLException ex) {
                    System.err.println("Lỗi trong quá trình rollback: " + ex.getMessage());
                }
            }
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true); // Đặt lại auto-commit về true
                }
            } catch (SQLException e) {
                System.err.println("Lỗi khi đặt lại auto-commit: " + e.getMessage());
            }
            ConnectionDB.closeConnection(con);
        }
    }

    public static void setupDatabase() {
        Connection con = null;
        try {
            con = ConnectionDB.openConnection();
            con.setAutoCommit(false);

            createTables(con);
            insertSampleData(con);
            con.commit();
            System.out.println("Khởi tạo cơ sở dữ liệu thành công!");

        } catch (SQLException e) {
            // Rollback nếu có lỗi
            if (con != null) {
                try {
                    System.err.println("Khởi tạo cơ sở dữ liệu thất bại. Đang rollback. Lý do: " + e.getMessage());
                    con.rollback();
                } catch (SQLException ex) {
                    System.err.println("Lỗi trong quá trình rollback: " + ex.getMessage());
                }
            }
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                }
            } catch (SQLException e) {
                System.err.println("Lỗi khi đặt lại auto-commit: " + e.getMessage());
            }
            ConnectionDB.closeConnection(con);
        }
    }

    private static void createTables(Connection con) throws SQLException {
        Statement stmt = con.createStatement();

        // Xóa bảng nếu tồn tại
        try {
            stmt.executeUpdate("DROP TABLE IF EXISTS Employees");
            stmt.executeUpdate("DROP TABLE IF EXISTS Departments");
            System.out.println("Các bảng đã tồn tại đã được xóa thành công");
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa bảng: " + e.getMessage());
        }

        // Tạo bảng Departments
        String createDepartmentsTable = "CREATE TABLE Departments (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL" +
                ")";
        stmt.executeUpdate(createDepartmentsTable);
        System.out.println("Bảng Departments đã được tạo thành công");

        // Tạo bảng Employees
        String createEmployeesTable = "CREATE TABLE Employees (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "department_id INT NOT NULL, " +
                "FOREIGN KEY (department_id) REFERENCES Departments(id) ON DELETE CASCADE" +
                ")";
        stmt.executeUpdate(createEmployeesTable);
        System.out.println("Bảng Employees đã được tạo thành công");

        stmt.close();
    }

    private static void insertSampleData(Connection con) throws SQLException {
        // Thêm các phòng ban mẫu
        String insertDepartmentSQL = "INSERT INTO Departments (name) VALUES (?)";
        PreparedStatement deptStmt = con.prepareStatement(insertDepartmentSQL, PreparedStatement.RETURN_GENERATED_KEYS);

        // Phòng ban mẫu 1
        deptStmt.setString(1, "Phòng Nhân sự");
        deptStmt.executeUpdate();
        int dept1Id = getGeneratedId(deptStmt);

        // Phòng ban mẫu 2
        deptStmt.setString(1, "Phòng Kỹ thuật");
        deptStmt.executeUpdate();
        int dept2Id = getGeneratedId(deptStmt);

        deptStmt.close();

        // Thêm nhân viên mẫu
        String insertEmployeeSQL = "INSERT INTO Employees (name, department_id) VALUES (?, ?)";
        PreparedStatement empStmt = con.prepareStatement(insertEmployeeSQL);

        // Nhân viên cho phòng Nhân sự
        empStmt.setString(1, "Nguyễn Văn A");
        empStmt.setInt(2, dept1Id);
        empStmt.executeUpdate();

        empStmt.setString(1, "Trần Thị B");
        empStmt.setInt(2, dept1Id);
        empStmt.executeUpdate();

        // Nhân viên cho phòng Kỹ thuật
        empStmt.setString(1, "Lê Văn C");
        empStmt.setInt(2, dept2Id);
        empStmt.executeUpdate();

        empStmt.setString(1, "Phạm Thị D");
        empStmt.setInt(2, dept2Id);
        empStmt.executeUpdate();

        empStmt.close();

        System.out.println("Dữ liệu mẫu đã được thêm thành công");
    }

    private static int getGeneratedId(PreparedStatement stmt) throws SQLException {
        var generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        } else {
            throw new SQLException("Không thể lấy được ID đã tạo");
        }
    }
}