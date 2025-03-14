package bt4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int sum =0;
        System.out.println("nhap so n:");
        n = scanner.nextInt();
        while (n != 0) {
            sum += n;
            System.out.println("nhap so khac 0:");
            n = scanner.nextInt();

        }
        System.out.printf("tong cac so da nhap la: %d", sum);
    }
}
