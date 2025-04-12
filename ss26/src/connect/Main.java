package connect;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            // Kiểm tra nếu kết nối thành công
            if (connection != null) {
                System.out.println("Đã kết nối đến database thành công!");

                // Thực hiện các thao tác với database ở đây
                // Ví dụ: truy vấn SQL, cập nhật dữ liệu,...

            } else {
                System.out.println("Kết nối thất bại!");
            }
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }
}
