package bt1;

public class BankAccount {
    // Thuộc tính private - không thể truy cập trực tiếp từ bên ngoài
    private String accountNumber;
    private double balance;
    private String ownerName;

    // Constructor
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Số dư ban đầu không được âm. Đặt về 0.");
            this.balance = 0;
        }
    }

    // Getter cho accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // Không có setter cho accountNumber - chỉ đọc, không thể thay đổi sau khi tạo

    // Getter cho balance
    public double getBalance() {
        return balance;
    }

    // Không có setter cho balance - chỉ có thể thay đổi thông qua deposit và withdraw

    // Getter cho ownerName
    public String getOwnerName() {
        return ownerName;
    }

    // Setter cho ownerName
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // Phương thức công khai để gửi tiền - kiểm tra tính hợp lệ trước khi thực hiện
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Gửi thành công " + amount + "đ. Số dư mới: " + balance + "đ");
        } else {
            System.out.println("Số tiền gửi phải lớn hơn 0!");
        }
    }

    // Phương thức công khai để rút tiền - kiểm tra tính hợp lệ trước khi thực hiện
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Số tiền rút phải lớn hơn 0!");
            return false;
        }

        if (amount > balance) {
            System.out.println("Số dư không đủ để rút tiền!");
            return false;
        }

        balance -= amount;
        System.out.println("Rút thành công " + amount + "đ. Số dư mới: " + balance + "đ");
        return true;
    }

    // Phương thức hiển thị thông tin tài khoản
    public void displayInfo() {
        System.out.println("Thông tin tài khoản:");
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Chủ tài khoản: " + ownerName);
        System.out.println("Số dư: " + balance + "đ");
    }
}
