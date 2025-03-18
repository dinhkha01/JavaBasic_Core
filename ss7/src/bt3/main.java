package bt3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.print("nhap vao chuoi bat ki");
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        System.out.println("chuoi dao nguoc: " + sb.reverse().toString());

    }
}
