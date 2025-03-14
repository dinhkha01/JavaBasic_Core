package bt6;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        float a,b,c, avg;
        System.out.print("nhập tên sv: ");
        name = sc.nextLine();
        System.out.printf("nhap diem cua sv theo thu tu mon1 -> mon2 -> mon3");
        a= sc.nextFloat();
        b= sc.nextFloat();
        c= sc.nextFloat();
        avg= (a+b+c) /3;
        System.out.println("------ Thông tin sinh viên ---------");
        System.out.println("Ten Sv :  "+ name);
        System.out.println("mon1: " + a + "| mon2: " + b + "| mon3: " + c);
        System.out.println("diem TB: "+ avg);
        System.out.println(avg>5 ?"len ":" ngu");
    }
}
