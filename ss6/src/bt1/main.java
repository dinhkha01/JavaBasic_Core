package bt1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap chuoi bat ki");
        String str = sc.nextLine();

        String[] arr = str.split(" ");
        System.out.print("so tu da nhap la: " + arr.length);

    }
}
