package bt4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo database và thêm dữ liệu mẫu
        initializeDatabase();

        // Lấy thông tin từ người dùng
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CHƯƠNG TRÌNH CHUYỂN KHOẢN LIÊN NGÂN HÀNG ===");
        System.out.print("Nhập ID tài khoản chuyển tiền: ");
        int fromAccountId = scanner.nextInt();

        System.out.print("Nhập ID tài khoản nhận tiền: ");
        int toAccountId = scanner.nextInt();

        System.out.print("Nhập số tiền cần chuyển: ");
        double amount = scanner.nextDouble();

        // Thực hiện chuyển khoản
        transferBetweenBanks(fromAccountId, toAccountId, amount);

        scanner.close();
    }

    public static void initializeDatabase() {
        Connection con = null;
        try {
            con = ConnectionDB.openConnection();
            createTable(con);
            insertSampleData(con);
        } catch (SQLException e) {
            System.out.println("Lỗi khi khởi tạo database: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(con);
        }
    }

    public static void createTable(Connection con) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS bank_accounts ("
                + "account_id INT PRIMARY KEY AUTO_INCREMENT,"
                + "account_name VARCHAR(100) NOT NULL,"
                + "balance DECIMAL(15,2) NOT NULL,"
                + "bank_name VARCHAR(100) NOT NULL)";

        try (PreparedStatement pst = con.prepareStatement(createTableSQL)) {
            pst.executeUpdate();
            System.out.println("Đã tạo bảng bank_accounts thành công!");
        }
    }

    public static void insertSampleData(Connection con) throws SQLException {
        // Kiểm tra xem bảng đã có dữ liệu chưa
        String checkDataSQL = "SELECT COUNT(*) FROM bank_accounts";
        try (PreparedStatement pst = con.prepareStatement(checkDataSQL);
             var rs = pst.executeQuery()) {
            if (rs.next() && rs.getInt(1) == 0) {
                // Thêm dữ liệu mẫu nếu bảng trống
                String insertSQL = "INSERT INTO bank_accounts (account_name, balance, bank_name) VALUES (?, ?, ?)";
                Object[][] sampleData = {
                        {"Nguyễn Văn A", 5000000.0, "Vietcombank"},
                        {"Trần Thị B", 3000000.0, "Techcombank"},
                        {"Lê Văn C", 8000000.0, "Agribank"},
                        {"Phạm Thị D", 2000000.0, "BIDV"}
                };

                try (PreparedStatement insertStmt = con.prepareStatement(insertSQL)) {
                    for (Object[] data : sampleData) {
                        insertStmt.setString(1, (String) data[0]);
                        insertStmt.setDouble(2, (Double) data[1]);
                        insertStmt.setString(3, (String) data[2]);
                        insertStmt.executeUpdate();
                    }
                    System.out.println("Đã thêm dữ liệu mẫu vào bảng!");
                }
            }
        }
    }

    public static void transferBetweenBanks(int fromAccountId, int toAccountId, double amount) {
        Connection con = null;
        try {
            con = ConnectionDB.openConnection();
            // Bắt đầu giao dịch
            con.setAutoCommit(false);

            // 1. Trừ tiền từ tài khoản ngân hàng A
            subtractFromAccount(con, fromAccountId, amount);

            // 2. Cộng tiền vào tài khoản ngân hàng B
            addToAccount(con, toAccountId, amount);

            // Nếu cả hai thành công, commit giao dịch
            con.commit();
            System.out.println("Chuyển khoản thành công!");

            // Hiển thị số dư mới
            displayAccountBalance(con, fromAccountId, "Tài khoản chuyển");
            displayAccountBalance(con, toAccountId, "Tài khoản nhận");

        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback();
                }
                System.out.println("Giao dịch thất bại, đã rollback: " + e.getMessage());
            } catch (SQLException ex) {
                System.out.println("Lỗi khi rollback: " + ex.getMessage());
            }
        } finally {
            ConnectionDB.closeConnection(con);
        }
    }

    private static void displayAccountBalance(Connection con, int accountId, String label) throws SQLException {
        String sql = "SELECT account_name, balance, bank_name FROM bank_accounts WHERE account_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, accountId);
            try (var rs = pst.executeQuery()) {
                if (rs.next()) {
                    System.out.printf("%s (%s - %s): Số dư mới: %,.2f VND%n",
                            label,
                            rs.getString("account_name"),
                            rs.getString("bank_name"),
                            rs.getDouble("balance"));
                }
            }
        }
    }

    private static void subtractFromAccount(Connection con, int accountId, double amount) throws SQLException {
        String sql = "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, amount);
            pst.setInt(2, accountId);
            pst.setDouble(3, amount);

            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Không thể trừ tiền: Tài khoản không tồn tại hoặc không đủ số dư");
            }
        }
    }

    private static void addToAccount(Connection con, int accountId, double amount) throws SQLException {
        String sql = "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, amount);
            pst.setInt(2, accountId);

            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Không thể cộng tiền: Tài khoản không tồn tại");
            }
        }
    }
}