package bt1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
             con = ConnectionDB.openConnection();
            createTable(con);
            searchById(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(con);
        }

    }

    public static void createTable(Connection con) {
        if (con == null) {
            throw new RuntimeException("Không thể kết nối đến database");
        }

        try {
            String createSql = "CREATE TABLE IF NOT EXISTS employees(" +
                    "id int primary key AUTO_INCREMENT," +
                    "name varchar(255)," +
                    "salary double precision)";

            try (PreparedStatement create = con.prepareStatement(createSql)) {
                create.executeUpdate();
                System.out.println("Đã tạo bảng employees (nếu chưa tồn tại)");
            }

            try (PreparedStatement delete = con.prepareStatement("DELETE FROM employees")) {
                delete.executeUpdate();
            }

            String insertSql = "INSERT INTO employees(name,salary) VALUES (?,?)";
            try (PreparedStatement insert = con.prepareStatement(insertSql)) {
                insert.setString(1, "a");
                insert.setDouble(2, 10000);
                insert.addBatch();

                insert.setString(1, "b");
                insert.setDouble(2, 20000);
                insert.addBatch();

                insert.setString(1, "c");
                insert.setDouble(2, 30000);
                insert.addBatch();

                int[] rows = insert.executeBatch();
                System.out.println("Đã thêm " + rows.length + " dòng");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void searchById(Connection con){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("nhap id muon tim");
            int id = Integer.parseInt(sc.nextLine());
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employees WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.printf("Tìm được id: %-3d | name: %-20s | salary: %-,5f%n",
                        rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"));
            } else {
                System.out.println("Không tìm thấy nhân viên với ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
