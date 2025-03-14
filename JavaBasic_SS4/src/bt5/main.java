package bt5;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương N: ");
        int n = scanner.nextInt();
        scanner.close();

        boolean found = false;
        System.out.println("Các số hoàn hảo nhỏ hơn " + n + " là:");


        for (int i = 1; i < n; i++) {
            int sum = 0;

            // Tìm tổng các ước của số i
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }


            if (sum == i) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có số hoàn hảo nào nhỏ hơn " + n);
        }

    }
}

