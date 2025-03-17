package bt3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap chuoi ban dau ");
        String str1 = sc.nextLine();
        System.out.print("nhap tu muon tim vi tri ");
        String str2 = sc.nextLine();
        System.out.printf("vi tri cua tu %s la: %d ", str2, str1.indexOf(str2)  );
    }
}
