package bt3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;
        System.out.print("nhap so a =");
        a= sc.nextInt();
        System.out.print("nhap so b =");
        b= sc.nextInt();
        boolean bang= a==b;
        boolean khac= a!=b;
        boolean lon_hon= a>b;
        boolean nho_hon= a<b;
        boolean lon_bang= a>=b;
        boolean nho_bang= a<=b;

        System.out.println("so a =  "+ a + " b = "+ b );
        System.out.println(" a == b  "+ bang);
        System.out.println(" a != b  "+ khac);
        System.out.println(" a > b  "+ lon_hon);
        System.out.println(" a < b  "+ nho_hon);
        System.out.println(" a >= b  "+ lon_bang);
        System.out.println(" a <= b  "+ nho_bang);




    }
}
