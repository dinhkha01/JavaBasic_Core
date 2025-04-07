package bt1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap a va b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        try{
            int c = a/b;
            System.out.println(c);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }

}