package bt3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao tuoi");
        int n = sc.nextInt();
        try{
            checkAge(n);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public static void checkAge(int age){
        if(age < 18 ){
            throw new IllegalArgumentException("oach con");
        }
        System.out.println("vượt mức pickaball");
    }
}
