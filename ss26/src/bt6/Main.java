package bt6;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = ConnectionDB.openConnection();
            createEmployeeTable(con);
            insertSampleData(con);
            displayEmployees(con);
        } catch (SQLException e) {
            System.err.println( e.getMessage());
            e.printStackTrace();
        } finally {
            if (con != null) {
                ConnectionDB.closeConnection(con);
            }
        }

    }
    public static void createEmployeeTable(Connection con) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS employees(" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(255)," +
                    "age INT," +
                    "salary DOUBLE)";
            stmt.executeUpdate(sql);
            System.out.println("Đã tạo bảng employees thành công!");
        }
    }
    public static void insertSampleData(Connection con) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate("DELETE FROM employees");
            String sql = "INSERT INTO employees(name, age, salary) VALUES " +
                    "('Nguyễn Văn A', 25, 15000000)," +
                    "('Trần Thị B', 30, 18000000)," +
                    "('Lê Văn C', 28, 22000000)," +
                    "('Phạm Thị D', 35, 25000000)," +
                    "('Hoàng Văn E', 40, 30000000)," +
                    "('Vũ Thị F', 27, 12000000)," +
                    "('Đặng Văn G', 32, 19000000)," +
                    "('Bùi Thị H', 29, 21000000)," +
                    "('Ngô Văn I', 45, 35000000)," +
                    "('Dương Thị K', 33, 28000000)";
            int rows = stmt.executeUpdate(sql);
            System.out.println("Đã thêm " + rows + " bản ghi vào bảng employees");
        }
    }
    public static void displayEmployees(Connection con) throws SQLException{
        try(Statement stmt = con.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total_employee FROM employees ");
            if(rs.next()){
                System.out.println("so luong nhan vien:  " +rs.getInt("total_employee"));
            }
            rs= stmt.executeQuery("SELECT AVG(salary) AS avg_salary From employees ");
            if(rs.next()){
                System.out.printf("Lương trung bình: %,.2f\n", rs.getDouble("avg_salary"));
            }
            rs =stmt.executeQuery("SELECT MAX(salary) as max_salary, MIN(salary) as min_salary From employees");
            if(rs.next()){
                System.out.printf("luong cao nhat: %,.0f \n", rs.getDouble("max_salary"));
                System.out.printf("luong thap nhat: %,.0f", rs.getDouble("min_salary"));
            }
        }
    }


}
