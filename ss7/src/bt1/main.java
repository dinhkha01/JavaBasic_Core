package bt1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap tu thu nhat");
        String str1=  sc.nextLine();
        System.out.print("nhap tu thu 2");
        String str2= sc.nextLine();
        System.out.print("nhap tu thu 3");
        String str3= sc.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        sb.append(" ");
        sb.append(str2);
        sb.append(" ");
        sb.append(str3);
        String str = sb.toString();
        System.out.printf("%s",str);
    }
}
