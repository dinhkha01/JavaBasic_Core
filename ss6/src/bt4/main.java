package bt4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap bat ki cai gi co so ");
        String str = sc.nextLine();
        String regex = "[0-9]";
        System.out.printf(str.replaceAll(regex,"*"));

    }
}
