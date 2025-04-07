package bt5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập một số nguyên dương lớn hơn 1: ");
            int number = Integer.parseInt(scanner.nextLine());

            if (number <= 1) {
                throw new IllegalArgumentException("Số phải lớn hơn 1");
            }

            if (isPrime(number)) {
                System.out.println(number + " là số nguyên tố");
            } else {
                System.out.println(number + " không phải là số nguyên tố");
            }

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Bạn phải nhập một số nguyên");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }


    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
