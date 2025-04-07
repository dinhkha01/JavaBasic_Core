package bt4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println(" nhap vao so nguyen ");
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(n);
        }catch (NumberFormatException e){
            System.out.println("khong phai so nguyen");

        }finally {
            System.out.println(":))))");
        }
    }


}

