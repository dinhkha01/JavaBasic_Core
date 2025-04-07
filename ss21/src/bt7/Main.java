package bt7;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 1000000;
        final int MIN_BALANCE = 50000;

        try {
            System.out.println("Số dư hiện tại: " + balance + " đồng");
            System.out.print("Nhập số tiền muốn rút: ");

            int withdrawAmount;
            try {
                withdrawAmount = sc.nextInt();
            } catch (InputMismatchException e) {
                throw new NumberFormatException("Lỗi: Vui lòng nhập một số hợp lệ!");
            }

            if (withdrawAmount <= 0) {
                throw new IllegalArgumentException("Lỗi: Số tiền rút phải lớn hơn 0!");
            }
            if (withdrawAmount > balance) {
                throw new IllegalArgumentException("Lỗi: Số tiền rút vượt quá số dư!");
            }
            if (balance - withdrawAmount < MIN_BALANCE) {
                throw new IllegalArgumentException("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
            }

            // Nếu tất cả điều kiện hợp lệ
            balance -= withdrawAmount;
            System.out.println("Rút tiền thành công! Số dư còn lại: " + balance + " đồng");

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
            System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
        }
    }
}