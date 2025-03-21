package bt1;

public class main {
    public static void main(String[] args) {
        // Tạo tài khoản ngân hàng
        BankAccount account = new BankAccount("12345678", "Nguyễn Văn A", 1000000);

        // Hiển thị thông tin ban đầu
        account.displayInfo();

        // Sử dụng các phương thức công khai để thao tác với đối tượng
        account.deposit(500000);
        account.withdraw(200000);

        // Cố gắng rút số tiền lớn hơn số dư
        account.withdraw(2000000);

        // Thay đổi tên chủ tài khoản
        account.setOwnerName("Nguyễn Văn B");
        account.displayInfo();

        // Không thể truy cập trực tiếp vào thuộc tính private
        // account.balance = -1000000; // Lỗi biên dịch
        // account.accountNumber = "87654321"; // Lỗi biên dịch
    }
}
