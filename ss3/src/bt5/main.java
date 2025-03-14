package bt5;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao so dau tien ");
        int a= sc.nextInt();
        sc.nextLine();
        System.out.println("nhap vao phep toan  ");
        String b= sc.nextLine();
        System.out.println("nhap vao so thu hai  ");
        int c = sc.nextInt();
        switch (b){
            case "+":
                System.out.println(a+c);
                break;
            case "-":
                System.out.println(a-c);
                break;
            case "*":
                System.out.println(a*c);
            case "/":
                if(c==0){
                    System.out.println("khong the chia cho 0");
                    break;
                }else {
                    System.out.println(a/c);
                }
                break;
            default:
                System.out.println("phep toan khogn hop le");
        }
    }
}
