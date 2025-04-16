package bt5;

import bt5.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MENU:");
        System.out.println("1. Khởi tạo cơ sở dữ liệu và thêm dữ liệu mẫu");
        System.out.println("2. Tạo đơn hàng mới");
        System.out.print("Chọn tùy chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());


        if (choice == 1) {
            setupDatabase();
        } else if (choice == 2) {
            createNewOrder();
        } else {
            System.out.println("Tùy chọn không hợp lệ!");
        }
    }

    private static void createNewOrder() {
        Connection con = null;
        try {
            con = ConnectionDB.openConnection();

            // Bắt đầu giao dịch
            con.setAutoCommit(false);

            // Thêm đơn hàng mới
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập tên khách hàng:");
            String customerName = scanner.nextLine();

            // Sử dụng ngày hiện tại thay vì yêu cầu nhập
            Date orderDate = Date.valueOf(LocalDate.now());
            System.out.println("Sử dụng ngày hiện tại: " + orderDate);

            String insertOrderSQL = "INSERT INTO Orders (customer_name, order_date) VALUES (?, ?)";
            PreparedStatement orderStmt = con.prepareStatement(insertOrderSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            orderStmt.setString(1, customerName);
            orderStmt.setDate(2, orderDate);
            orderStmt.executeUpdate();

            // Lấy ID của đơn hàng vừa tạo
            int orderId;
            var generatedKeys = orderStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1);
                System.out.println("Đơn hàng mới đã được tạo với ID: " + orderId);
            } else {
                throw new SQLException("Không thể lấy được ID của đơn hàng vừa tạo");
            }

            // Thêm chi tiết đơn hàng
            String insertDetailSQL = "INSERT INTO OrderDetails (order_id, product_name, quantity) VALUES (?, ?, ?)";
            PreparedStatement detailStmt = con.prepareStatement(insertDetailSQL);

            System.out.println("Bạn muốn thêm bao nhiêu sản phẩm vào đơn hàng này?");
            int productCount = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng mới

            for (int i = 0; i < productCount; i++) {
                System.out.println("Nhập tên sản phẩm #" + (i+1) + ":");
                String productName = scanner.nextLine();

                System.out.println("Nhập số lượng cho " + productName + ":");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng mới

                if (quantity <= 0) {
                    throw new SQLException("Số lượng không hợp lệ: " + quantity + ". Số lượng phải lớn hơn 0.");
                }

                detailStmt.setInt(1, orderId);
                detailStmt.setString(2, productName);
                detailStmt.setInt(3, quantity);
                detailStmt.addBatch();
            }

            // Thực thi tất cả các lệnh insert chi tiết đơn hàng cùng một lúc
            detailStmt.executeBatch();

            // Nếu không có lỗi xảy ra, thực hiện commit giao dịch
            con.commit();
            System.out.println("Giao dịch đã hoàn thành thành công!");

        } catch (SQLException e) {
            // Nếu có lỗi xảy ra, rollback giao dịch
            if (con != null) {
                try {
                    System.err.println("Giao dịch đang được rollback. Lý do: " + e.getMessage());
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
            stmt.executeUpdate("DROP TABLE IF EXISTS OrderDetails");
            stmt.executeUpdate("DROP TABLE IF EXISTS Orders");
            System.out.println("Các bảng đã tồn tại đã được xóa thành công");
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa bảng: " + e.getMessage());
        }

        // Tạo bảng Orders
        String createOrdersTable = "CREATE TABLE Orders (" +
                "order_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "customer_name VARCHAR(255) NOT NULL, " +
                "order_date DATE NOT NULL" +
                ")";
        stmt.executeUpdate(createOrdersTable);
        System.out.println("Bảng Orders đã được tạo thành công");

        // Tạo bảng OrderDetails
        String createOrderDetailsTable = "CREATE TABLE OrderDetails (" +
                "detail_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "order_id INT NOT NULL, " +
                "product_name VARCHAR(255) NOT NULL, " +
                "quantity INT NOT NULL, " +
                "FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE, " +
                "CHECK (quantity > 0)" +
                ")";
        stmt.executeUpdate(createOrderDetailsTable);
        System.out.println("Bảng OrderDetails đã được tạo thành công");

        stmt.close();
    }

    private static void insertSampleData(Connection con) throws SQLException {
        // Thêm các đơn hàng mẫu
        String insertOrderSQL = "INSERT INTO Orders (customer_name, order_date) VALUES (?, ?)";
        PreparedStatement orderStmt = con.prepareStatement(insertOrderSQL, PreparedStatement.RETURN_GENERATED_KEYS);

        // Đơn hàng mẫu 1
        orderStmt.setString(1, "Nguyễn Văn A");
        orderStmt.setDate(2, Date.valueOf("2023-10-15"));
        orderStmt.executeUpdate();
        int order1Id = getGeneratedId(orderStmt);

        // Đơn hàng mẫu 2
        orderStmt.setString(1, "Trần Thị B");
        orderStmt.setDate(2, Date.valueOf("2023-10-16"));
        orderStmt.executeUpdate();
        int order2Id = getGeneratedId(orderStmt);

        // Đơn hàng mẫu 3
        orderStmt.setString(1, "Lê Văn C");
        orderStmt.setDate(2, Date.valueOf("2023-10-17"));
        orderStmt.executeUpdate();
        int order3Id = getGeneratedId(orderStmt);

        orderStmt.close();

        // Thêm chi tiết đơn hàng mẫu
        String insertDetailSQL = "INSERT INTO OrderDetails (order_id, product_name, quantity) VALUES (?, ?, ?)";
        PreparedStatement detailStmt = con.prepareStatement(insertDetailSQL);

        // Chi tiết cho đơn hàng 1
        detailStmt.setInt(1, order1Id);
        detailStmt.setString(2, "Laptop Dell XPS 13");
        detailStmt.setInt(3, 1);
        detailStmt.executeUpdate();

        detailStmt.setInt(1, order1Id);
        detailStmt.setString(2, "Chuột không dây Logitech");
        detailStmt.setInt(3, 2);
        detailStmt.executeUpdate();
        detailStmt.close();

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