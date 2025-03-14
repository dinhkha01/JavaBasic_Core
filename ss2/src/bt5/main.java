package bt5;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        float a,b,chu_vi,Dien_tich;
        System.out.print("Nhap nhap chieu dai  va chieu rong: ");
        a = nhap.nextFloat();
        b= nhap.nextFloat();
        chu_vi= (a+b)* 2;
        Dien_tich= a* b;
        System.out.printf("chu vi = "+ chu_vi +"\n dien tich = "+ Dien_tich);

    }
}
