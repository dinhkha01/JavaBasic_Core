package bt8;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------- Nhap thong tin Sv --------------- ");
        System.out.printf("nhap ma sv: ");
        String maSv= sc.nextLine();
        System.out.printf("nhap ten Sv: ");
        String tensv = sc.nextLine();
        System.out.printf("nhap sdt: ");
        String sdt = sc.nextLine();
        System.out.printf("nhap ngay sinh: ");
        String dobsv = sc.nextLine();
        System.out.printf("nhap gioi tinh (1: nam | 2: nu) :");
        int sex = sc.nextInt();
        System.out.print("--------------- Nhap diem Sv --------------- ");
        System.out.printf("nhap diem cac mon cua sv (mon1 -> mon2 -> mon3 ): ");
        float mon1= sc.nextFloat();
        float mon2= sc.nextFloat();
        float mon3= sc.nextFloat();
        float avg = (mon1+mon2+mon3)/3;
        System.out.println("ma sv: " + maSv + " | tensv: "+ tensv + " | gioi tinh: " + (sex == 1 ?"nam":"nu") + "\nsdt: " + sdt + " | dob: " + dobsv );
        System.out.println("mon1: " + mon1 + " |mon2: " + mon2 + " |mon3: " + mon3 + "\n diemTb: " + avg);
    }
}
