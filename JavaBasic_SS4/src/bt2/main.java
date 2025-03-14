package bt2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so n ");
        int n = sc.nextInt();
        while(n <=1){
            System.out.println( n+ " khong phai so nguyen to. Nhap lai" );
            n = sc.nextInt();
        }
        boolean check = true;
        for(int i = 2 ; i < n;i++) {
            if (n % i == 0) {
                check = false;
                break;
            }
        }
        if(check){
            System.out.println(n + " la so nguyen to");
        }else {
            System.out.println(n + " khong phai la so nguyen to");
        }
    }
}
