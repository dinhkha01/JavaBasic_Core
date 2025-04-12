package bt1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = ConnectionDB.openConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (con != null) {
            try {
                Statement stmt = con.createStatement();
                String sql = "CREATE TABLE USERS (" +
                        "id INT PRIMARY KEY," +
                        "name VARCHAR(255)," +
                        "email VARCHAR(255))";
                stmt.executeUpdate(sql);
                System.out.println("Tạo bảng USERS thành công!");
            } catch (SQLException e) {
                System.err.println("Lỗi khi tạo bảng: " + e.getMessage());
            } finally {
                ConnectionDB.closeConnection(con);
            }
        }
    }
}